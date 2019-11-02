import java.util.HashMap;
import java.util.Map;

public class TriplesWithBitwiseAndEqualToZero {
	public int countTriplets(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int a: A) {
			map.put(a, map.getOrDefault(a, 0) + 1);
		}

		Map<Integer, Integer> map2 = new HashMap<>();
		for (int a: A) {
			for (int key : map.keySet()) {
				map2.put(a & key, map2.getOrDefault(a & key, 0) + map.get(key));
			}
		}

		Map<Integer, Integer> map3 = new HashMap<>();
		for (int a: A) {
			for (int key : map2.keySet()) {
				map3.put(a & key, map3.getOrDefault(a & key, 0) + map2.get(key));
			}
		}

		return map3.getOrDefault(0, 0);
	}
}
