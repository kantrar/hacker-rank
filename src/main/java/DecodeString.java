public class DecodeString {
	public String decodeString(String input) {
		String answer = "";
		int pos = 0;
		do {
			pos = decodeStringAtPosition(input, pos, answer);
		} while (pos < input.length());

		return answer;
	}

	// abc => abc
	// 3[a]2[bc] = > aaabcbc
	// 3[a2[c]] => accaccacc
	// 2[abc]3[cd]ef =>
	// 3[a2[c]e] = >
	public int decodeStringAtPosition(String input, int pos, String answer) {
		if (pos >= input.length()) {
			return pos;
		}

		String countNumStr = "";
		while (pos < input.length() && isNumber(input.charAt(pos))) {
			countNumStr += input.charAt(pos);
			pos++;
		}

		int countNum = countNumStr == "" ? 1 : Integer.parseInt(countNumStr);

		pos = decodeCharacter(input, pos, countNum, answer);

		return pos;
	}

	public boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	public int decodeCharacter(String input, int pos, int multiplier, String answer) {
		if (pos >= input.length()) {
			return pos;
		}

		String charStr = "";
		if (input.charAt(pos) == '[') {
			pos++;
		}

		while (pos < input.length() && input.charAt(pos) != '[' && input.charAt(pos) != ']') {
			if (isNumber(input.charAt(pos))) {
				pos = decodeStringAtPosition(input, pos, answer);
			} else {
				charStr += input.charAt(pos);
				pos++;
			}
		}

		while (multiplier >= 0) {
			answer += charStr;
			multiplier--;
		}

		if (pos < input.length() && input.charAt(pos) == ']') {
			return pos + 1;
		} else {
			return pos;
		}
	}
}
