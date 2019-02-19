import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class XorAndSum {

	static int MAX = (int) (Math.pow(10, 9) + 7);
	private static int TIMES = 314159;

	static int xorAndSum(String a, String b) {
		return binarySum(a, b, TIMES);
	}

	static int binarySum(String a, String b, int times) {
		int inputA = convertStringToBin(a);
		int inputB = convertStringToBin(b);

		BigInteger sum = BigInteger.valueOf(inputA * times);
		sum = sum.mod(BigInteger.valueOf(MAX));

		BigInteger base = BigInteger.valueOf(2);
		BigInteger pow = base.pow(times).subtract(BigInteger.valueOf(1));
		sum = sum.add(pow.multiply(BigInteger.valueOf(inputB)));
		sum = sum.mod(BigInteger.valueOf(MAX));

		// Might be a problem if sum is too low because of modulo operation
		long errorTerm = getErrorTerm(a, b);
		sum = sum.add(BigInteger.valueOf(MAX));
		sum = sum.subtract(BigInteger.valueOf(errorTerm));
		sum = sum.mod(BigInteger.valueOf(MAX));

		return sum.intValue();
	}

	private static long getErrorTerm(String a, String b) {
		int result = 0;
		List<Integer> numberOfOnesInBAtPosition = new ArrayList<>(10);
		for (int length = a.length(); length > 0; length--) {
			numberOfOnesInBAtPosition.add(0);
		}
		if (b.charAt(b.length() - 1) == '1') {
			numberOfOnesInBAtPosition.set(a.length() - 1, 1);
			if (a.charAt(a.length() - 1) == '1') {
				result += numberOfOnesInBAtPosition.get(a.length() - 1) * 2;
			}
		}

		for (int i = a.length() - 2; i >= 0; i--) {
			if (a.charAt(i) == '0') {
				numberOfOnesInBAtPosition.set(i, numberOfOnesInBAtPosition.get(i + 1));
			} else {
				int bPos = i + b.length() - a.length();
				if (bPos < b.length() && bPos >= 0 && b.charAt(bPos) == '1') {
					numberOfOnesInBAtPosition.set(i, numberOfOnesInBAtPosition.get(i + 1) + 1);
				} else {
					numberOfOnesInBAtPosition.set(i, numberOfOnesInBAtPosition.get(i + 1));
				}
				result += numberOfOnesInBAtPosition.get(i) * (int) Math.pow(2, a.length() - i);
			}

		}
		return result;
	}

	private static int convertStringToBin(String a) {
		int result = 0;
		char[] chars = a.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (a.charAt(i) == '1') {
				result += Math.pow(2, chars.length - i - 1);
			}
		}
		return result;
	}
}
