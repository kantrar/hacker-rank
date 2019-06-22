import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		// count how many tasks each
		// AAABBBC n = 3
		// AAABBBCCDDE n = 2
		// ABCABCABD-DE
		// ABCDEABCDAB
		// AAABBBCCDDE n = 3
		// ABCDABCDABE
		// ABCDEABCDAB
		// AAABBBCCDDE n = 4
		// ABCDEABCD-AB
		// AAABBBCCDDEF n = 4
		// ABCDEFABCD-AB
		// ABCDEABCDFAB
		// AAABBCC n = 3
		// ABC-ABC-A
		// do different tasks then if it takes more than n intervals -> repeat process
		// O(M)

		if (n == 0) {
			return tasks.length;
		}

		Map<Character, Integer> map = new HashMap<>();
		for (char c : tasks) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

		Map<Character, Integer> orderedMap = new LinkedHashMap<>();
		for (Map.Entry<Character, Integer> entry : list) {
			orderedMap.put(entry.getKey(), entry.getValue());
		}

		int answer = 0;
		int unique = 0;
		int emptySlots = 0;
		int max = Integer.MIN_VALUE;
		List<Character> keys = new ArrayList<>(orderedMap.keySet());
		for (char key : keys) {
			int currentValue = orderedMap.get(key);
			unique++;
			if (currentValue >= max) {
				answer = Math.max(answer, (currentValue - 1) * n + unique + currentValue - 1);
				max = currentValue;
				if (unique == 1) {
					emptySlots += n * (currentValue - 1);
				} else {
					emptySlots -= currentValue - 1;
				}
			} else {
				if (emptySlots - currentValue < 0) {
					currentValue -= emptySlots;
					emptySlots = 0;
					answer = Math.max(answer, answer + currentValue);
				} else {
					emptySlots -= currentValue;
				}
			}
		}

		return answer;
	}
}
