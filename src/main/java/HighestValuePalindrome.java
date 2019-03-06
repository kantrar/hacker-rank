public class HighestValuePalindrome {

	// correct
	static String highestValuePalindrome(String s, int length, int change) {
		StringBuilder sb = new StringBuilder(s);
		int[] requiredChange = new int[length];

		for (int i = 0; i < s.length() / 2; i++) {
			char firstChar = s.charAt(i);
			char lastChar = s.charAt(length - i - 1);
			if (firstChar != lastChar) {
				requiredChange[i]++;

				char maxChar = firstChar > lastChar ? firstChar : lastChar;
				sb.setCharAt(i, maxChar);
				sb.setCharAt(length - i - 1, maxChar);

				change--;
			}
		}

		if (change < 0) {
			return "-";
		}

		if (change == 0) {
			return sb.toString();
		}

		int i = 0;

		while (i < length / 2) {
			int changeNeeded = 0;
			char firstChar = s.charAt(i);
			char lastChar = s.charAt(length - i - 1);

			if (firstChar == '9' && lastChar == '9') {
				// do nothing as change is not needed
			} else if (firstChar == '9' || lastChar == '9') {
				// do nothing as change is already included in the first for loop
			} else {
				if (requiredChange[i] != 0) {
					changeNeeded = 1;
					change--;
				} else {
					changeNeeded = 2;
					change -= 2;
				}
			}
			if (change < 0) {
				change += changeNeeded;
				i++;
				continue;
			}
			sb.setCharAt(i, '9');
			sb.setCharAt(length - i - 1, '9');
			i++;
		}

		if (change >= 1 && length % 2 == 1) {
			sb.setCharAt(length / 2, '9');

		}

		return sb.toString();
	}

	// Incorrect and timeout
	static String highestValuePalindrome3(String s, int length, int change) {

		if (change < 0) {
			return "-";
		}

		if (length == 1) {
			if (change >= 1) {
				return "9";
			} else {
				return s;
			}
		}

		char firstChar = s.charAt(0);
		char lastChar = s.charAt(length - 1);
		char maxChar = firstChar > lastChar ? firstChar : lastChar;
		char minChar = firstChar < lastChar ? firstChar : lastChar;
		if (length == 2) {
			if (change >= 2 || (change == 1 && maxChar == '9')) {
				return "99";
			} else {
				if (firstChar == lastChar) {
					return s;
				} else if (change >= 1) {
					return new String(new char[] {maxChar, maxChar});
				} else {
					return "-";
				}
			}

		}

		String newSubstr = s.substring(1, length - 1);
		if (firstChar == lastChar) {
			String answer;
			if (firstChar == '9') {
				answer = highestValuePalindrome(newSubstr, length - 2, change);
				if (answer == "-") {
					return "-";
				} else {
					return "9" + answer + "9";
				}
			}

			answer = highestValuePalindrome(newSubstr, length - 2, change - 2);

			if (answer != "-") {
				return "9" + answer + "9";
			}

			answer = highestValuePalindrome(newSubstr, length - 2, change);

			if (answer != "-") {
				return firstChar + answer + firstChar;
			}
		} else {
			String answer;
			if (maxChar == '9') {
				answer = highestValuePalindrome(newSubstr, length - 2, change - 1);
				if (answer == "-") {
					return "-";
				} else {
					return "9" + answer + "9";
				}
			}

			answer = highestValuePalindrome(newSubstr, length - 2, change - 2);

			if (answer != "-") {
				return "9" + answer + "9";
			}

			answer = highestValuePalindrome(newSubstr, length - 2, change - 1);

			if (answer != "-") {
				return maxChar + answer + maxChar;
			}
		}

		return "-";
	}

	// Incorrect, too complicated and timeout
	static String highestValuePalindrome2(String s, int length, int change) {
		// 1998 -> 8998 (change = 1), 9999 (change = 2)
		// 1271 -> 9779 (change = 3), 1771 (change = 1)
		// 6243 -> 6446 (change = 2)
		// 6243 -> 9449 (change = 3) not 6996
		// 6223 -> 9229 (change = 3) not 6996

		if (change < 0) {
			return "";
		}

		if (length <= 2) {
			String str = checkPalindrome(s);
			if (!str.equals("")) {
				if (change > 0) {
					if (length == 1 && change >= 1) {
						return "9";
					} else if (length == 2 && change >= 2) {
						return "99";
					} else if (length == 2 && change == 1) {
						return s;
					} else {
						return "";
					}
				}
				return str;
			} else if (str.equals("") && change > 0) {
				if (s.length() == 2 && change >= 2) {
					return "99";
				}

				if (s.charAt(0) > s.charAt(1)) {
					return s.substring(0, 1) + s.substring(0, 1);
				} else {
					return s.substring(1, 2) + s.substring(1, 2);
				}
			} else {
				return "";
			}
		}

		String newString = s.substring(1, length - 1);
		String answer1;
		String answer2;

		if (s.charAt(0) != s.charAt(length - 1)) {
			answer1 = highestValuePalindrome(newString, length - 2, change - 2);
			answer2 = highestValuePalindrome(newString, length - 2, change - 1);

			String maxSubstr = s.charAt(0) > s.charAt(length - 1) ? s.substring(0, 1) : s.substring(length - 1, length);

			if (answer1.equals("") && answer2.equals("")) {
				return "";
			}

			if (answer1.equals("")) {
				answer2 = maxSubstr + answer2 + maxSubstr;
				return answer2;
			}

			answer2 = "9" + answer1 + "9";
			return answer2;

		} else {
			answer1 = highestValuePalindrome(newString, length - 2, change - 2);
			answer2 = highestValuePalindrome(newString, length - 2, change);

			if (answer1.equals("") && answer2.equals("")) {
				return "";
			}

			if (answer1.equals("")) {
				answer2 = s.substring(0, 1) + answer2 + s.substring(0, 1);
				return answer2;
			}

			answer2 = "9" + answer1 + "9";
			return answer2;
		}
	}

	private static String checkPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}

		if (s.length() == 2 && s.charAt(0) == s.charAt(s.length() - 1)) {
			return s;
		}

		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			String newStr = checkPalindrome(s.substring(1, s.length() - 1));
			if (newStr.equals("")) {
				return "";
			}

			return s.substring(0, 1) + newStr + s.substring(0, 1);
		}

		return "";
	}
}
