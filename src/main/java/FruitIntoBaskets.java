import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
	public int totalFruit(int[] tree) {
		Map<Integer, Integer> map = new HashMap<>();

		int left = 0;
		int right = 0;

		int answer = 0;

		while (right < tree.length) {
			map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);

			if (map.size() <= 2) {
				answer = Math.max(answer, right - left + 1);
			} else {
				while (left < tree.length && map.size() > 2) {
					if (map.get(tree[left]) == 1) {
						map.remove(tree[left]);
					} else {
						map.put(tree[left], map.get(tree[left]) - 1);
					}
					left++;
				}
			}
			right++;
		}

		return answer;
	}
}
