import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MajorityChecker {
	int shard;
	int[] arr;
	Map<Integer, Integer> map;
	Map<Integer, List<Integer>> sortedMap;

	public MajorityChecker(int[] arr) {
		this.arr = arr;

		map = new TreeMap<>();
		sortedMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			if (!sortedMap.containsKey(arr[i])) {
				sortedMap.put(arr[i], new ArrayList<>());
			}
			sortedMap.get(arr[i]).add(i);
		}

		sortedMap = sortedMap.entrySet().stream().sorted((a, b) -> b.getValue().size() - a.getValue().size())
				.collect(Collectors.toMap(a -> a.getKey(), a -> a.getValue(), (e1, e2) -> e1, LinkedHashMap::new));

		shard = (int) Math.sqrt(arr.length);
	}

	public int query(int left, int right, int threshold) {
		if (right - left + 1 > shard) {
			for (int key : sortedMap.keySet()) {
				List<Integer> positions = sortedMap.get(key);
				if (positions.size() < threshold) {
					break;
				}
				int leftIdx = Collections.binarySearch(positions, left);
				int rightIdx = Collections.binarySearch(positions, right);

				leftIdx = leftIdx < 0 ? -(leftIdx + 1) : leftIdx;
				rightIdx = rightIdx < 0 ? -(rightIdx + 1) : rightIdx;

				if (rightIdx - leftIdx >= threshold) {
					return key;
				}
			}
		} else {
			for (int i = left; i < right; i++) {
				if (map.get(arr[i]) >= threshold) {
					return arr[i];
				}
			}
		}
		return -1;
	}
}
