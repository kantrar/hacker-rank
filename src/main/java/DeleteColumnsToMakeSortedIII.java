public class DeleteColumnsToMakeSortedIII {
	public int minDeletionSize(String[] A) {
		int[] notDelete = new int[A[0].length()];
		int[] delete = new int[A[0].length()];
		for (int i = 0; i < A[0].length(); i++) {
			notDelete[i] = i;
			delete[i] = i;
			for (int j = 0; j < i; j++) {
				if (possible(A, i, j)) {
					notDelete[i] = Math.min(notDelete[i], notDelete[j] + i - j - 1);
				}
				delete[i] = Math.min(delete[i], 1 + Math.min(delete[j], notDelete[j]) + i - j - 1);
			}
		}

		return Math.min(delete[A[0].length() - 1], notDelete[A[0].length() - 1]);
	}

	private boolean possible(String[] A, int i, int j) {
		for (int k = 0; k < A.length; k++) {
			if (A[k].charAt(i) < A[k].charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
