import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MaximumPoints {
	public static int maximumPoints(int[] input) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < input.length; i++) {
			int count = map.getOrDefault(input[i], 0);
			map.put(input[i], count + 1);
		}

		List<Integer> keys = map.keySet().stream().collect(Collectors.toList());
		return pickPoints(map, keys, 0, keys.size());
	}

	private static int pickPoints(Map<Integer, Integer> map, List<Integer> keys, int start, int end) {
		if (end - start < 1) {
			return 0;
		}

		int key = keys.get(start);
		int count = map.get(key);

		if (end - start == 1) {
			return count * key;
		}

		int answer;

		if (key + 1 == keys.get(start + 1)) {
			// pick this element but cannot pick the next element
			int answer1 = count * key + pickPoints(map, keys, start + 2, end);

			// not pick this element
			int answer2 = pickPoints(map, keys, start + 1, end);

			answer = Math.max(answer1, answer2);
		} else {
			// pick this element and can pick the next element
			answer = count * key + pickPoints(map, keys, start + 1, end);
		}

		return answer;
	}
}
