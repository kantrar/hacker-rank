import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CloudyDay {

	private static class DisjointSet {
		private DisjointSet parent;
		private int rank;
	}

	// Incomplete
	public static long maximumPeople(long[] population, int[] location, long[] cloudLocation, long[] cloudRange) {
		Map<Integer, Long> cityPopulation = new TreeMap<>();

		for (int i = 0; i < population.length; i++) {
			Long pop = cityPopulation.getOrDefault(location[i] - 1, 0L);
			cityPopulation.put(location[i] - 1, pop + population[i]);

			pop = cityPopulation.getOrDefault(location[i] + 2, 0L);
			cityPopulation.put(location[i] + 2, pop - population[i]);
		}

		List<Integer> cityList = cityPopulation.keySet().stream().collect(Collectors.toList());

		Map<Integer, Integer> startCloudCoverCity = new HashMap<>();
		Map<Integer, Integer> endCloudCoverCity = new HashMap<>();

		Map<Integer, Long> cloudCovers = findNoCloudCoversCity(cloudLocation, cloudRange, cityList, startCloudCoverCity,
				endCloudCoverCity);

		List<Integer> cloudCoversList = cloudCovers.keySet().stream().collect(Collectors.toList());

		long accPop = 0L;
		for (Integer city : cityList) {
			Long pop = cityPopulation.get(city);
			accPop += pop;
			cityPopulation.put(city, accPop);
		}

		long acc = 0;
		for (Integer city : cloudCoversList) {
			long noClouds = cloudCovers.get(city);
			acc += noClouds;
			cloudCovers.put(city, acc);
		}

		long totalPopulation = 0;
		long maxPopulation = Long.MIN_VALUE;

		Set<Integer> allLocation = new TreeSet<>();
		allLocation.addAll(cloudCovers.keySet());
		allLocation.addAll(cityPopulation.keySet());

		for (Integer loc : allLocation) {
			Long covers = cloudCovers.getOrDefault(loc, 0L);
			Long pop = cityPopulation.getOrDefault(loc, 0L);

			int prevCloud;
			int idx = cloudCoversList.indexOf(loc);
			if (idx - 1 < 0) {
				prevCloud = cloudCoversList.get(0);
			} else {
				prevCloud = cloudCoversList.get(idx - 1);
			}

			if (covers == 0L || cloudCovers.get(prevCloud) == 0L) {
				totalPopulation += pop;
			}
		}

		for (int i = 0; i < cloudLocation.length; i++) {
			Integer startIndex = startCloudCoverCity.getOrDefault(i, null);
			Integer endIndex = endCloudCoverCity.getOrDefault(i, null);

			if (startIndex == null || endIndex == null) {
				continue;
			}

			Long clouds = cloudCovers.get(cityList.get(startIndex));
			if (clouds == null) {
				continue;
			}

			int idx = cloudCoversList.indexOf(cityList.get(startIndex));
			int nextIdx = idx++;

			int lastCity = cityList.get(endIndex);
			if (nextIdx >= cloudCoversList.size()) {
				lastCity = cloudCoversList.get(nextIdx);

			}

			long popBeforeStartIndex = (startIndex - 1 < 0 ? 0L : cityPopulation.get(cityList.get(startIndex - 1)));
			long currentPop = cityPopulation.get(lastCity) - popBeforeStartIndex;

			if (clouds == 1L) {
				maxPopulation = Math.max(maxPopulation, currentPop);
				continue;
			}

		}

		return maxPopulation == Long.MIN_VALUE ? totalPopulation : totalPopulation + maxPopulation;
	}

	private static Map<Integer, Long> findNoCloudCoversCity(long[] cloudLocation, long[] cloudRange, List<Integer> cityList,
			Map<Integer, Integer> startCloudCoverCity, Map<Integer, Integer> endCloudCoverCity) {
		Map<Integer, Long> cloudCovers = new TreeMap<>();
		for (int i = 0; i < cloudLocation.length; i++) {
			long startCloud = cloudLocation[i] - cloudRange[i];
			long endCloud = cloudLocation[i] + cloudRange[i];

			if (startCloud < 0) {
				startCloud = 0;
			}

			int startIndex = findCityIndexAfter(cityList, startCloud);
			int endIndex = findCityIndexBefore(cityList, endCloud);

			if (startIndex >= cityList.size()) {
				continue;
			}

			if (endIndex < 0) {
				continue;
			}

			startCloudCoverCity.put(i, startIndex);
			endCloudCoverCity.put(i, endIndex);

			int cityAtStartIndex = cityList.get(startIndex);
			long prev = cloudCovers.getOrDefault(cityAtStartIndex, 0L);
			cloudCovers.put(cityAtStartIndex, prev + 1);

			if (endIndex + 1 < cityList.size()) {
				int cityAtEndIndex = cityList.get(endIndex + 1);
				prev = cloudCovers.getOrDefault(cityAtEndIndex, 0L);
				cloudCovers.put(cityAtEndIndex, prev - 1);
			}
		}

		return cloudCovers;
	}

	private static int findCityIndexBefore(List<Integer> cityList, long cloud) {
		int left = 0;
		int right = cityList.size();
		int mid = (left + right) / 2;

		while (left < right) {
			if (cityList.get(mid) > cloud) {
				right = mid;
			} else if (cityList.get(mid) < cloud) {
				left = mid + 1;
			} else {
				return mid;
			}
			mid = (left + right) / 2;
		}

		if (mid < 0) {
			mid = 0;
		}

		if (mid == cityList.size()) {
			mid = mid - 1;
		}

		if (cityList.get(mid) > cloud) {
			return mid - 1;
		} else {
			return mid;
		}
	}

	private static int findCityIndexAfter(List<Integer> cityList, long cloud) {
		int left = 0;
		int right = cityList.size();
		int mid = (left + right) / 2;

		while (left < right) {
			if (cityList.get(mid) > cloud) {
				right = mid;
			} else if (cityList.get(mid) < cloud) {
				left = mid + 1;
			} else {
				return mid;
			}
			mid = (left + right) / 2;
		}

		if (mid < 0) {
			mid = 0;
		}

		if (mid >= cityList.size()) {
			mid = mid - 1;
		}

		if (cityList.get(mid) < cloud) {
			return mid + 1;
		} else {
			return mid;
		}
	}

	// Timeout
	public static long maximumPeople2(long[] population, long[] location, long[] cloudLocation, long[] cloudRange) {
		Map<Long, Long> cityPopulation = new TreeMap<>();
		for (int i = 0; i < population.length; i++) {
			Long previousPopulation = cityPopulation.getOrDefault(location[i], 0L);
			cityPopulation.put(location[i], previousPopulation + population[i]);
		}

		List<Long> cityList = cityPopulation.keySet().stream().collect(Collectors.toList());

		Map<Integer, Integer> startCloudCoverCity = new HashMap<>();
		Map<Integer, Integer> endCloudCoverCity = new HashMap<>();

		// How many clouds cover each cities
		Map<Long, Long> cloudCovers = findCloudCovers(cloudLocation, cloudRange, cityList, startCloudCoverCity,
				endCloudCoverCity);

		// Gets city population without clouds
		long totalPopulation = 0L;
		for (Long cityLoc : cityPopulation.keySet()) {
			Long cloudCover = cloudCovers.get(cityLoc);
			if (cloudCover == null) {
				totalPopulation += cityPopulation.get(cityLoc);
			}
		}

		long maxPopulation = Long.MIN_VALUE;
		for (int i = 0; i < cloudLocation.length; i++) {

			Integer startIndex = startCloudCoverCity.getOrDefault(i, null);
			Integer endIndex = endCloudCoverCity.getOrDefault(i, null);

			if (startIndex == null || endIndex == null) {
				continue;
			}

			Long currentPop = 0L;
			for (int j = startIndex; j <= endIndex; j++) {
				Long cityCovered = cityList.get(j);
				Long cloudCover = cloudCovers.getOrDefault(cityCovered, 0L);
				if (cloudCover == 1L) {
					currentPop += cityPopulation.getOrDefault(cityCovered, 0L);
				}
			}

			maxPopulation = Math.max(maxPopulation, currentPop);
		}

		return maxPopulation == Long.MIN_VALUE ? totalPopulation : totalPopulation + maxPopulation;
	}

	private static Map<Long, Long> findCloudCovers(long[] cloudLocation, long[] cloudRange, List<Long> cityList,
			Map<Integer, Integer> startCloudCoverCity, Map<Integer, Integer> endCloudCoverCity) {
		Map<Long, Long> cloudCovers = new TreeMap<>();
		for (int i = 0; i < cloudLocation.length; i++) {
			long startCloud = cloudLocation[i] - cloudRange[i];
			long endCloud = cloudLocation[i] + cloudRange[i];

			if (startCloud < 0) {
				startCloud = 0;
			}

			int startIndex = findCityAfter(cityList, startCloud);
			int endIndex = findCityBefore(cityList, endCloud);

			if (startIndex >= cityList.size()) {
				continue;
			}

			if (endIndex < 0) {
				continue;
			}

			startCloudCoverCity.put(i, startIndex);
			endCloudCoverCity.put(i, endIndex);

			for (int j = startIndex; j <= endIndex; j++) {
				Long cityCovered = cityList.get(j);
				Long prevCloudCovers = cloudCovers.getOrDefault(cityCovered, 0L);
				cloudCovers.put(cityCovered, prevCloudCovers + 1);
			}
		}
		return cloudCovers;
	}

	private static int findCityBefore(List<Long> cityList, long cloud) {
		int left = 0;
		int right = cityList.size();
		int mid = (left + right) / 2;

		while (left < right) {
			if (cityList.get(mid) > cloud) {
				right = mid;
			} else if (cityList.get(mid) < cloud) {
				left = mid + 1;
			} else {
				return mid;
			}
			mid = (left + right) / 2;
		}

		if (mid < 0) {
			mid = 0;
		}

		if (mid == cityList.size()) {
			mid = mid - 1;
		}

		if (cityList.get(mid) > cloud) {
			return mid - 1;
		} else {
			return mid;
		}
	}

	private static int findCityAfter(List<Long> cityList, long cloud) {
		int left = 0;
		int right = cityList.size();
		int mid = (left + right) / 2;

		while (left < right) {
			if (cityList.get(mid) > cloud) {
				right = mid;
			} else if (cityList.get(mid) < cloud) {
				left = mid + 1;
			} else {
				return mid;
			}
			mid = (left + right) / 2;
		}

		if (mid < 0) {
			mid = 0;
		}

		if (mid >= cityList.size()) {
			mid = mid - 1;
		}

		if (cityList.get(mid) < cloud) {
			return mid + 1;
		} else {
			return mid;
		}
	}
}