public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		char[] reversed = new char[s.length()];
		int idx = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			reversed[idx++] = s.charAt(i);
		}

		char[] origin = s.toCharArray();
		int len = 0;

		for (int j = 0; j < reversed.length; j++) {
			len = Math.max(len, isPalindrome(reversed, origin, j));
		}

		String answer = "";
		for (int i = s.length() - 1; i >= len; i--) {
			answer += s.charAt(i);
		}

		answer += s;

		return answer;
	}

	public int isPalindrome(char[] reversed, char[] origin, int pos) {
		int len = reversed.length - pos;
		int left = pos;
		int right = reversed.length - 1;

		int originLeft = 0;
		int originRight = len - 1;

		while (left < right) {
			if (reversed[left] == origin[originLeft] && reversed[right] == origin[originRight]
					&& reversed[left] == reversed[right]) {
				left++;
				right--;
				originLeft++;
				originRight--;
			} else {
				return 0;
			}
		}

		return len;
	}
}
