public class SherlockAndAnagram {
	public static int sherlockAndAnagrams(String s) {
		int answer = 0;
		for (int len = 1; len <= s.length(); len++) {
			for (int i = 0; i < s.length(); i++) {
				for (int j = i + 1; j < s.length(); j++) {
					if (i + len > s.length() || j + len > s.length()) {
						continue;
					}
					String first = s.substring(i, i + len);
					String second = s.substring(j, j + len);

					if (anagram(first, second)) {
						answer++;
					}
				}
			}
		}

		return answer;
	}

	private static boolean anagram(String first, String second) {
		int[] firstArray = new int[26];
		int[] secondArray = new int[26];
		for (int i = 0; i < first.length(); i++) {
			firstArray[first.charAt(i) - 'a']++;
			secondArray[second.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (firstArray[i] != secondArray[i]) {
				return false;
			}
		}

		return true;
	}
}
