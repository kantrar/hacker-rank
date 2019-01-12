import java.util.HashMap;
import java.util.Map;

public class EqualizeArray {
	static int equalizeArray(int[] array) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int number : array) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		return array.length - map.values().stream().max(Integer::compareTo).get();
	}
}
