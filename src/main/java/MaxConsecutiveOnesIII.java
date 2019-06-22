public class MaxConsecutiveOnesIII {
	public int longestOnes(int[] A, int K) {
		int countZero = 0;
		for (int i = 0; i < A.length; i++) {
			countZero += A[i] == 0 ? 1 : 0;
		}

		if (countZero <= K) {
			return A.length;
		}

		int start = 0;
		int end = 0;
		int max = 0;

		countZero = 0;
		while (end < A.length) {
			while (start < A.length && countZero > K) {
				if (A[start] == 0) {
					countZero--;
				}
				start++;
			}
			while (end < A.length && countZero <= K) {
				if (A[end] == 1) {
					end++;
				} else if (A[end] == 0) {
					countZero++;
					end++;
				}
			}

			if (end >= A.length && A[end - 1] == 1) {
				max = Math.max(max, end - start);
			} else {
				max = Math.max(max, end - start - 1);
			}
		}

		return max;
	}
}
