import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MigratoryBirds {
	static int migratoryBirds(List<Integer> arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		int answer = 0;
		for (int i = 0; i < arr.size(); i++) {
			int value = arr.get(i);
			int count = map.getOrDefault(value, 0);
			int newCount = count + 1;
			map.put(value, newCount);
		}

		for (Integer key : map.keySet()) {
			if (max < map.get(key)) {
				max = map.get(key);
				answer = key;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int result = MigratoryBirds.migratoryBirds(Arrays.asList(1, 4, 4, 4, 5, 3));
		System.out.println(result);
	}
}
