import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PickingNumbers {

	public static int pickingNumbers(List<Integer> inputs) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer input : inputs) {
			map.put(input, map.getOrDefault(input, 0) + 1);
		}

		int result = 0;
		List<Integer> keys = map.keySet().stream().sorted().collect(Collectors.toList());

		if (keys.size() == 1) {
			return inputs.size();
		}

		for (int i = 0; i < keys.size() - 1; i++) {
			if (keys.get(i + 1) - keys.get(i) <= 1) {
				int current = map.get(keys.get(i)) + map.get(keys.get(i + 1));
				if (result < current) {
					result = current;
				}
			} else {
				int current = map.get(keys.get(i));
				if (result < current) {
					result = current;
				}
			}
		}
		return result;
	}
}
