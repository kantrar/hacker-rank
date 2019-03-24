public class FindSumPairs {
	static int findSumPairs(int[] input, int divisor) {
		if (input.length < 2) {
			return 0;
		}

		int count = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1;  j < input.length; j++) {
				int first = input[i];
				int second = input[j];
				if ((first + second) % divisor == 0) {
					count++;
				}
			}
		}
		return count;
	}

}
