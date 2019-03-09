public class ArithmeticExpressions {
	private static final String EMPTY_STRING = "";



	// Incorrect, since not taking into account the case that (a * b - m) is divisible by 101, thus failing some time cases
	// Also face timeout issues
	public static String arithmeticExpressions2(int[] arr) {
		String appendedResult = EMPTY_STRING;
		for (int i = arr.length - 1; i >= 0; i--) {
			String result = calculate(arr, i, 101);
			if (!result.equals(EMPTY_STRING)) {
				return String.format("%s%s", result, appendedResult);
			}
			appendedResult = String.format("*%d", arr[i]);
		}

		return EMPTY_STRING;
	}

	private static String calculate(int[] arr, int pos, int value) {
		if (pos < 0) {
			return EMPTY_STRING;
		}

		if (pos == 0) {
			if (arr[pos] == value) {
				return String.valueOf(value);
			} else {
				return EMPTY_STRING;
			}
		}

		int nextTarget = value - arr[pos];
		if (nextTarget < 0) {
			return EMPTY_STRING;
		}

		String result = calculate(arr, pos - 1, nextTarget);
		if (!result.equals(EMPTY_STRING)) {
			return String.format("%s+%d", result, arr[pos]);
		}

		int nextTarget2 = value + arr[pos];
		if (nextTarget2 < 0) {
			return EMPTY_STRING;
		}

		result = calculate(arr, pos - 1, nextTarget2);
		if (!result.equals(EMPTY_STRING)) {
			return String.format("%s-%d", result, arr[pos]);
		}
		return EMPTY_STRING;
	}
}
