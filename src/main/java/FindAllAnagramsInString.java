import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString {

	public List<Integer> findAnagrams(String s, String target) {
		Map<Character, Integer> countMap = new HashMap<>();
		for (int i = 0; i < target.length(); i++) {
			countMap.put(target.charAt(i), countMap.getOrDefault(target.charAt(i), 0) + 1);
		}

		int left = 0;
		int right = 0;

		int required = countMap.size();
		int formed = 0;

		Map<Character, Integer> currentMap = new HashMap<>();
		List<Integer> answer = new ArrayList<>();

		while (right < s.length()) {
			char k = s.charAt(right);
			currentMap.put(k, currentMap.getOrDefault(k, 0) + 1);

			if (!countMap.containsKey(k)) {
				currentMap.clear();
				left = right + 1;
				formed = 0;
			} else if (currentMap.get(k).intValue() == countMap.get(k).intValue()) {
				formed++;

				if (formed == required) {
					answer.add(left);
					char leftKey = s.charAt(left);
					currentMap.put(leftKey, currentMap.getOrDefault(leftKey, 0) - 1);
					formed--;
					left++;
				}
			} else if (currentMap.get(k) > countMap.get(k)) {
				while (currentMap.get(k) > countMap.get(k)) {
					char leftKey = s.charAt(left);
					currentMap.put(leftKey, currentMap.getOrDefault(leftKey, 0) - 1);
					if (currentMap.get(leftKey) < countMap.get(leftKey)) {
						formed--;
					}

					left++;
				}
			}

			right++;
		}

		return answer;
	}
}
