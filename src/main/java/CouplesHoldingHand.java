import java.util.HashMap;
import java.util.Map;

public class CouplesHoldingHand {
	public int minSwapsCouples(int[] row) {
		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < row.length; i += 2) {
			int min = Math.min(row[i], row[i + 1]);
			int max = Math.max(row[i], row[i + 1]);

			if ((min % 2) == 0 && min == max - 1) {
				continue;
			}

			if (map.containsKey(findPair(min))) {
				answer++;
				int prevMinPair = findPair(min);
				min = map.get(prevMinPair);

				if (min == findPair(max)) {
					map.remove(min);
				}

				map.remove(prevMinPair);
			} else {
				map.put(min, max);
			}

			if (map.containsKey(findPair(max))) {
				answer++;
				map.put(min, map.get(findPair(max)));
				map.remove(findPair(max));
			} else {
				map.put(min, max);
				map.put(max, min);
			}
		}

		return answer;
	}

	public int findPair(int a) {
		if (a % 2 == 0) {
			return a + 1;
		} else {
			return a - 1;
		}
	}
}
