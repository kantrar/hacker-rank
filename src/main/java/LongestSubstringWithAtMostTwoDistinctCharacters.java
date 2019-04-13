import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> existingMap = new HashMap<>();
		int left = 0;
		int right = 0;

		int unique = 0;
		int answer = 0;

		while (right < s.length()) {
			if (!existingMap.containsKey(s.charAt(right)) || existingMap.get(s.charAt(right)) == 0) {
				existingMap.put(s.charAt(right), 0);
				unique++;
			}
			existingMap.put(s.charAt(right), existingMap.get(s.charAt(right)) + 1);

			if (unique <= 2) {
				answer = Math.max(answer, right - left + 1);
			}

			while (unique >= 3 && left < s.length()) {
				System.out.println(existingMap.keySet());
				System.out.println(left);
				System.out.println(s.charAt(left));
				System.out.println(existingMap.get(s.charAt(left)));
				if (existingMap.get(s.charAt(left)) == 1) {
					existingMap.put(s.charAt(left), existingMap.get(s.charAt(left)) - 1);
					unique--;
					left++;
					break;
				}
				existingMap.put(s.charAt(left), existingMap.get(s.charAt(left)) - 1);
				left++;
			}

			if (unique <= 2) {
				answer = Math.max(answer, right - left + 1);
			}

			right++;
		}

		return answer;
	}

	public static void main(String[] args) {
		LongestSubstringWithAtMostTwoDistinctCharacters c = new LongestSubstringWithAtMostTwoDistinctCharacters();
		int result = c.lengthOfLongestSubstringTwoDistinct("eceba");
		System.out.println(result);
	}
}
