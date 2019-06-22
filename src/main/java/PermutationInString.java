public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		int[] letters = new int[26];
		int uniqueChars = 0;
		for (int i = 0; i < s1.length(); i++) {
			letters[key(s1, i)]++;
			if (letters[key(s1, i)] == 1) {
				uniqueChars++;
			}
		}

		int start = 0;
		int end = 0;

		int formed = 0;

		int[] currentLetters = new int[26];

		while (start < s2.length()) {
			while (start < s2.length() && letters[key(s2, start)] == 0) {
				start++;
			}

			if (end < start) {
				end = start;
			}

			while (end < s2.length() && currentLetters[key(s2, end)] < letters[key(s2, end)] && letters[key(s2, end)] != 0) {
				currentLetters[key(s2, end)]++;
				if (currentLetters[key(s2, end)] == letters[key(s2, end)]) {
					formed++;
				}

				end++;
			}

			if (formed == uniqueChars) {
				return true;
			}

			if (end >= s2.length()) {
				break;
			}

			if (letters[key(s2, end)] == 0) {
				start = end + 1;
				formed = 0;
				currentLetters = new int[26];
			} else {
				if (currentLetters[key(s2, start)] == letters[key(s2, start)]) {
					formed--;
				}
				currentLetters[key(s2, start)]--;

				start = start + 1;
			}
		}

		return false;
	}

	public int key(String s, int pos) {
		return s.charAt(pos) - 'a';
	}
}
