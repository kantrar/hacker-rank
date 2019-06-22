import java.util.Arrays;

public class NonNegativeIntegersWithoutConsecutiveOnes {
	public int findIntegers(int num) {
		int len = 0;
		int MSB = -1;
		int secondMSB = -1;
		int countOnes = 0;
		int current = num;
		while (current > 0) {
			if ((current & 1) == 1) {
				secondMSB = MSB;
				MSB = len;
				countOnes++;
			}
			current = current >> 1;
			len++;
		}

		secondMSB = secondMSB == -1 ? 0 : len - secondMSB - 1;

		int[] ones = new int[len];
		int[] zeros = new int[len];
		Arrays.fill(ones, -1);
		Arrays.fill(zeros, -1);
		find(ones, zeros, 0);

		if (countOnes == len) {
			return zeros[0] + ones[0];
		}

		if (secondMSB != 0) {
			return zeros[0] + 1 + findIntegers(1 << secondMSB) - findIntegers((1 << secondMSB) - 1) - 1;
		} else {
			return zeros[1] + ones[1] + 1;
		}

	}

	public void find(int[] ones, int[] zeros, int pos) {
		if (ones[pos] != -1 && zeros[pos] != -1) {
			return;
		}

		if (pos + 1 >= ones.length) {
			zeros[pos] = 1;
			ones[pos] = 1;
		} else {
			find(ones, zeros, pos + 1);
			zeros[pos] = (zeros[pos + 1] + ones[pos + 1]);
			ones[pos] = zeros[pos + 1];
		}
	}
}
