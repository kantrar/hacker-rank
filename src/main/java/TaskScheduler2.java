import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskScheduler2 {
	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> count = new HashMap<>();
		for (int i = 0; i < tasks.length; i++) {
			count.put(tasks[i], count.getOrDefault(tasks[i], 0) + 1);
		}

		List<Map.Entry<Character, Integer>> list = new ArrayList<>(count.entrySet());
		list.sort(Map.Entry.comparingByValue());

		Map<Character, Integer> orderedMap = new LinkedHashMap<>();

		for (int i = 0; i < list.size(); i++) {
			orderedMap.put(list.get(i).getKey(), list.get(i).getValue());
		}

		int answer = 0;
		int emptySlot = 0;
		int used = 0;
		int max = orderedMap.get(list.get(0).getKey());
		for (char key : orderedMap.keySet()) {
			int value = orderedMap.get(key);
			if (answer == 0) {
				emptySlot += (value - 1) * (n);
				answer += (value - 1) * (n + 1) + 1;
			} else {
				if (value == max) {
					answer++;
					used = (value - 1) * (n);
				} else {
					used = value;
				}
				if (used >= emptySlot) {
					answer += (used - emptySlot);
					emptySlot = 0;
				} else {
					emptySlot -= used;
				}
			}
		}

		return answer;
	}
}
