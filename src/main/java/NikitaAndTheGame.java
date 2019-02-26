public class NikitaAndTheGame {
	static int arraySplitting(int[] arr) {
		return cut(arr, 0, arr.length);
	}

	private static int cut(int[] arr, int start, int end) {

		if (end - start <= 1) {
			return 0;
		}

		int pos = findPositionToCut(arr, start, end);

		if (pos == -1) {
			return 0;
		}

		boolean[] leftAllZeros = new boolean[] {true};
		boolean[] rightAllZeros = new boolean[] {true};

		int leftSum = updateSum(arr, leftAllZeros, start, pos);
		int rightSum = updateSum(arr, rightAllZeros, pos, end);

		if (leftSum == rightSum) {
			if (leftAllZeros[0] && rightAllZeros[0]) {
				return end - start - 1;
			}

			int leftScore = cut(arr, start, pos);
			int rightScore = cut(arr, pos, end);

			return leftScore < rightScore ? rightScore + 1 : leftScore + 1;
		}

		return 0;
	}

	private static int findPositionToCut(int[] arr, int start, int end) {

		if (end - start <= 0) {
			return -1;
		}

		int idx = start + 1;

		while (idx < end) {

			boolean[] leftAllZeros = new boolean[] {true};
			boolean[] rightAllZeros = new boolean[] {true};

			int leftSum = updateSum(arr, leftAllZeros, start, idx);
			int rightSum = updateSum(arr, rightAllZeros, idx, end);

			if (leftSum == rightSum) {
				return idx;
			}

			idx++;
		}

		return -1;
	}

	private static int updateSum(int[] arr, boolean[] allZeros, int start, int end) {
		int sum = 0;
		for (int i = start; i < end; i++) {
			if (arr[i] != 0) {
				allZeros[0] = false;
			}
			sum += arr[i];
		}

		return sum;
	}
}
