public class ArrayManipulation {

	static long arrayManipulation(int n, int[][] queries) {
		long[] answers = new long[n + 1];
		long max = 0;

		for (int[] query : queries) {
			int start = query[0];
			int end = query[1];
			int value = query[2];
			for (int j = start; j <= end; j++) {
				answers[j] += value;
				if (max < answers[j]) {
					max = answers[j];
				}
			}
		}
		return max;
	}
}
