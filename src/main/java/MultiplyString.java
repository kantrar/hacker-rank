import java.util.Arrays;

public class MultiplyString {
	public static String multiply(String num1, String num2) {
		int m = num1.length();
		int n = num2.length();

		int[] result = new int[m + n - 1];

		Arrays.fill(result, 0);

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				result[i + j] += mul;
			}
		}

		String answer = "";
		int carry = 0;
		for (int i = m + n - 2; i >= 0; i--) {
			result[i] = result[i] + carry;

			if (result[i] >= 10) {
				carry = result[i] / 10;
				result[i] = result[i] % 10;
			} else {
				carry = 0;
			}

			answer = String.valueOf(result[i]) + answer;
		}

		if (carry != 0) {
			answer = String.valueOf(carry) + answer;
		}

		return answer;
	}
}
