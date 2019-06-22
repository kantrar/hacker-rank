import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int maxDistinct) {
		if (s.length() == 0) {
			return 0;
		}

		int left = 0;
		int right = 0;
		int distinct = 0;
		Map<Character, Integer> map = new HashMap<>();
		int answer = 0;
		while (right < s.length()) {
			char key = s.charAt(right);
			map.put(key, map.getOrDefault(key, 0) + 1);

			if (map.get(key) == 1) {
				distinct++;
			}

			if (distinct <= maxDistinct) {
				answer = Math.max(answer, right - left + 1);
			}

			while (left < right && distinct > maxDistinct) {
				char k = s.charAt(left);
				map.put(k, map.get(k) - 1);

				if (map.get(k) == 0) {
					distinct--;
				}

				left++;
			}

			right++;
		}

		return answer;
	}
}
