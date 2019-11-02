public class MinimumSwapsToMakeSequencesIncreasing {
	public int minSwap(int[] A, int[] B) {
		int count = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] <= A[i - 1]) {
				int t = A[i];
				A[i] = B[i];
				B[i] = t;
				count++;
			} else if (B[i] <= B[i - 1]) {
				int t = A[i];
				A[i] = B[i];
				B[i] = t;
				count++;
			}
		}
		return Math.min(count, A.length - count);
	}
}
