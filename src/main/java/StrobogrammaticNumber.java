public class StrobogrammaticNumber {
	public int strobogrammaticInRange(String low, String high) {
		int answer = 0;
		int highLen = high.length();
		int lowLen = low.length();

		String newLow = low;
		while (lowLen < highLen) {
			String newHigh = "";
			int i = 0;

			while (i < lowLen) {
				newHigh += "9";
				i++;
			}

			answer += find(newLow, newHigh, 0, lowLen - 1);

			newLow = "1";
			i = 0;
			while (i < lowLen) {
				newLow += "0";
				i++;
			}
			lowLen++;
		}

		answer += find(newLow, high, 0, highLen - 1);

		return answer;
	}

	public int find(String low, String high, int start, int end) {
		if (end - start == 0) {
			String s1 = low.substring(start, end + 1);
			String s2 = high.substring(start, end + 1);

			if (s1.compareTo("8") <= 0 && s2.compareTo("8") >= 0) {
				return 1;
			} else {
				return 0;
			}
		}

		if (end - start == 1) {
			String s1 = low.substring(start, end + 1);
			String s2 = high.substring(start, end + 1);

			return getAnswer(s1, s2);
		}

		String s1 = String.format("%s%s", low.charAt(start), low.charAt(end));
		String s2 = String.format("%s%s", high.charAt(start), high.charAt(end));

		int result = getAnswer(s1, s2);

		result = result * find(low, high, start + 1, end - 1);

		return result;
	}

	public int getAnswer(String s1, String s2) {
		if ("69".compareTo(s1) >= 0) {
			if (s2.compareTo("88") < 0) {
				return 1;
			} else if (s2.compareTo("96") < 0) {
				return 2;
			} else {
				return 3;
			}
		}

		if ("88".compareTo(s1) >= 0) {
			if (s2.compareTo("96") < 0) {
				return 1;
			} else {
				return 2;
			}
		}

		if ("96".compareTo(s1) >= 0) {
			return 1;
		}

		return 0;
	}

	public static void main(String[] args) {
		StrobogrammaticNumber s = new StrobogrammaticNumber();
		int result = s.strobogrammaticInRange("50", "1000");
		System.out.println(result);
	}
}
