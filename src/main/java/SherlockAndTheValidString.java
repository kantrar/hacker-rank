import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SherlockAndTheValidString {
	static String isValid(String s) {
		int[] alphabets = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alphabets[s.charAt(i) - 'a']++;
		}

		boolean allEquals = true;
		Map<Integer, Integer> set = new HashMap<>();

		for (int i = 0; i < 26; i++) {
			if (alphabets[i] != 0) {
				int count = set.getOrDefault(alphabets[i], 0);
				count++;
				set.put(alphabets[i], count);
			}
		}

		if (set.size() <= 1) {
			return "YES";
		} else if (set.size() >= 3) {
			return "NO";
		}

		List<Integer> keyList = set.keySet().stream().collect(Collectors.toList());
		int firstKey = keyList.get(0);
		int secondKey = keyList.get(1);

		if (firstKey == 1 && set.get(firstKey) == 1) {
			return "YES";
		}

		if (secondKey == 1 && set.get(secondKey) == 1) {
			return "YES";
		}

		if (secondKey - firstKey == 1 && set.get(secondKey) == 1) {
			return "YES";
		}

		if (firstKey - secondKey == 1 && set.get(firstKey) == 1) {
			return "YES";
		}

		return "NO";
	}
}
