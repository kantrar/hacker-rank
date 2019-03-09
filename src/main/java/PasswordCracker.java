import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PasswordCracker {
	public static String passwordCracker(List<String> passwords, String loginAttempt) {
		Map<Character, List<String>> map = generateMapFromStrings(passwords);
		String[] memos = new String[loginAttempt.length()];
		Arrays.fill(memos, "");

		return findString(map, memos, loginAttempt, 0).trim();
	}

	// Worst case = O(MN)
	// a, aa, aaa, aaaa, aaaaa => N
	// aaa => M

	// acb, ade, aef,

	// abc, def
	// a, d is the possible character
	// from loginAttempt we store the position that is possible to be our match
	static String findString(Map<Character, List<String>> map, String[] memos, String loginAttempt, int start) {
		if (start >= loginAttempt.length()) {
			return "";
		}

		if (!memos[start].equals("")) {
			return memos[start];
		}

		char[] charArray = loginAttempt.toCharArray();
		char firstChar = charArray[start];

		String answers = "";

		List<String> currentList = map.getOrDefault(firstChar, new ArrayList<>());

		for (String w : currentList) {
			int maxLength = loginAttempt.length() - start;
			if (w.length() > maxLength) {
				continue;
			}
			String pw = loginAttempt.substring(start, start + w.length());
			if (pw.equals(w)) {
				answers = pw;
				String rest = findString(map, memos, loginAttempt, start + w.length());
				if (!rest.equals("WRONG PASSWORD")) {
					answers += " " + rest;
					memos[start] = answers;
					return answers;
				}
			}
		}

		memos[start] = "WRONG PASSWORD";
		return "WRONG PASSWORD";
	}

	static Map<Character, List<String>> generateMapFromStrings(List<String> pws) {
		Map<Character, List<String>> map = new HashMap<>();
		for (String pw : pws) {
			char firstChar = pw.charAt(0);
			List<String> currentList = map.getOrDefault(firstChar, new ArrayList<>());
			currentList.add(pw);
			map.put(firstChar, currentList);
		}
		return map;
	}

}

