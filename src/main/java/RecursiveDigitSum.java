public class RecursiveDigitSum {
	static int superDigit(String n, int k) {
		long sum = 0;
		for (int i = 0; i < n.length(); i++) {
			sum += Integer.parseInt(n.substring(i, i + 1));
		}

		while (sum / 10 >= 1) {
			sum = simplifySum(sum);
		}

		sum = sum * k;

		while (sum / 10 >= 1) {
			sum = simplifySum(sum);
		}

		return (int) sum;
	}

	static long simplifySum(long sum) {
		long newSum = 0;

		while (sum / 10 >= 1) {
			newSum += sum % 10;
			sum = sum / 10;
		}

		newSum += sum % 10;

		return newSum;
	}

	public static void main(String[] args) {
		System.out.println(superDigit("3333", 12));
	}
}
