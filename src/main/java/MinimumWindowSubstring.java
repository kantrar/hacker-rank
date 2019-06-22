import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}

		Map<Character, Integer> countT = new HashMap<>();
		Map<Character, Integer> countS = new HashMap<>();

		int uniqueChars = 0;

		for (int i = 0; i < t.length(); i++) {
			char tChar = t.charAt(i);
			countT.put(tChar, countT.getOrDefault(tChar, 0) + 1);

			if (countT.get(tChar) == 1) {
				uniqueChars++;
			}
		}

		int start = 0;
		int end = 0;

		int formed = 0;

		String answer = new String(s);

		while (end < s.length()) {
			while (end < s.length() && formed < uniqueChars) {
				char sChar = s.charAt(end);
				if (!countT.containsKey(sChar)) {
					end++;
					continue;
				}

				countS.put(sChar, countS.getOrDefault(sChar, 0) + 1);

				if (countS.get(sChar).intValue() == countT.get(sChar).intValue()) {
					formed++;
				}

				end++;
			}

			if (end >= s.length() && formed != uniqueChars) {
				return answer.equals(s) ? "" : answer;
			}

			while (start < end) {
				if (end - start <= answer.length()) {
					answer = s.substring(start, end);
				}

				char sChar = s.charAt(start);
				countS.put(sChar, countS.getOrDefault(sChar, 0) - 1);

				if (countT.containsKey(sChar) && countS.get(sChar).intValue() == countT.get(sChar).intValue() - 1) {
					formed--;
					start++;
					break;
				}

				start++;
			}
		}

		return answer;
	}
}
