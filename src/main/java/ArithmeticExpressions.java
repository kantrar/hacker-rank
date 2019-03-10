public class ArithmeticExpressions {
	private static final String EMPTY_STRING = "";



	// Incorrect in some cases and face timout
	public static String arithmeticExpressions3(int[] arr) {
		return calculate(arr, String.valueOf(arr[0]), arr[0], 1);
	}

	// return string that starts with $answer, appended with the answer of the rest of the numbers (starting at pos)
	private static String calculate(int[] arr, String answer, long currentValue, int pos) {
		if (pos >= arr.length) {
			if (currentValue % 101 == 0) {
				return String.valueOf(arr[pos - 1]);
			} else {
				return EMPTY_STRING;
			}
		}

		if (currentValue < 0) {
			return EMPTY_STRING;
		}

		if (currentValue % 101 == 0) {
			String appendedAnswer = calculate(arr, String.valueOf(arr[pos]), currentValue, pos + 1);
			return String.format("%s*%s", answer, appendedAnswer);
		}

		String appendedAnswer = calculate(arr, String.valueOf(arr[pos]), currentValue + arr[pos], pos + 1);
		if (!appendedAnswer.equals(EMPTY_STRING)) {
			return String.format("%s+%d", answer, appendedAnswer);
		}

		appendedAnswer = calculate(arr, String.valueOf(arr[pos]), currentValue - arr[pos], pos + 1);
		if (!appendedAnswer.equals(EMPTY_STRING)) {
			return String.format("%s-%d", answer, appendedAnswer);
		}

		appendedAnswer = calculate(arr, String.valueOf(arr[pos]), currentValue * arr[pos], pos + 1);
		if (!appendedAnswer.equals(EMPTY_STRING)) {
			return String.format("%s*%d", answer, appendedAnswer);
		}

		return EMPTY_STRING;
	}


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
