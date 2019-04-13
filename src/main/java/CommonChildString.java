import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommonChildString {
	static int commonChild(String s1, String s2) {
		Map<String, Integer> map = new HashMap<>();
		int[][] answers = new int[s1.length()][s2.length()];
		for (int i = 0; i < answers.length; i++) {
			Arrays.fill(answers[i], -1);
		}
		return findAnswer(s1, s2, 0, 0, answers);
	}

	private static int findAnswer(String s1, String s2, int p1, int p2, int[][] answers) {
		if (p1 >= s1.length() || p2 >= s2.length()) {
			return 0;
		}
		if (answers[p1][p2] != -1) {
			return answers[p1][p2];
		}

		if (s1.substring(p1).equals(s2.substring(p2))) {
			int result = s1.substring(p1).length();
			answers[p1][p2] = result;
			return result;
		}

		if (s1.substring(p1).length() == 0 || s2.substring(p2).length() == 0) {
			answers[p1][p2] = 0;
			return 0;
		}

		if (s1.charAt(p1) == s2.charAt(p2)) {
			if (s1.length() > 1 && s1.length() > 1) {
				int result = 1 + findAnswer(s1, s2, p1 + 1, p2 + 1, answers);
				answers[p1][p2] = result;
				return result;
			} else {
				return 1;
			}
		}

		int res1 = findAnswer(s1, s2, p1 + 1, p2, answers);
		int res2 = findAnswer(s1, s2, p1, p2 + 1, answers);
		int result = Math.max(res1, res2);
		answers[p1][p2] = result;

		return result;
	}

	static int commonChild2(String s1, String s2) {
		Map<String, Integer> map = new HashMap<>();
		return findAnswer2(s1, s2, map);
	}

	private static int findAnswer2(String s1, String s2, Map<String, Integer> answerMap) {
		String key = getKey(s1, s2);
		if (s1.equals(s2)) {
			answerMap.put(key, s1.length());
			return s1.length();
		}

		if (answerMap.get(key) != null) {
			return answerMap.get(key);
		}

		Map<Character, String> map1 = new HashMap<>();
		for (int i = s1.length() - 1; i >= 0; i--) {
			map1.put(s1.charAt(i), i + 1 < s1.length() ? s1.substring(i + 1) : "");
		}

		int maxChild = 0;
		for (int i = 0; i < s2.length(); i++) {
			char k = s2.charAt(i);
			if (!map1.keySet().contains(k)) {
				continue;
			}

			maxChild = Math.max(maxChild, 1 + findAnswer2(map1.get(k), s2.substring(i + 1), answerMap));
		}

		answerMap.put(key, maxChild);
		return maxChild;
	}

	private static String getKey(String s1, String s2) {
		return s1 + "#" + s2;
	}

}
