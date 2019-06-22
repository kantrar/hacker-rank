import java.util.Arrays;

public class OddEvenJumps {
	public int oddEvenJumps(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int[] minIdx = new int[A.length - 1];
		int min = A[A.length - 1];
		int idx = A.length - 1;
		Arrays.fill(minIdx, -1);
		for (int i = A.length - 2; i >= 0; i--) {
			if (min >= A[i]) {
				min = A[i];
				idx = i;
				minIdx[i] = -1;
			} else {
				minIdx[i] = idx;
			}
		}

		int[] maxIdx = new int[A.length - 1];
		int max = A[A.length - 1];
		idx = A.length - 1;
		Arrays.fill(maxIdx, -1);
		for (int i = A.length - 2; i >= 0; i--) {
			if (max <= A[i]) {
				max = A[i];
				idx = i;
				maxIdx[i] = -1;
			} else {
				maxIdx[i] = idx;
			}
		}


		boolean[] startIdxOdd = new boolean[A.length];
		boolean[] startIdxEven = new boolean[A.length];
		startIdxOdd[A.length - 1] = true;
		startIdxEven[A.length - 1] = true;

		int answer = 1;
		for (int i = A.length - 2; i >= 0; i--) {
			if (minIdx[i] != -1) {
				startIdxOdd[i] = startIdxEven[minIdx[i]];
			} else {
				startIdxOdd[i] = false;
			}

			if (maxIdx[i] != -1) {
				startIdxEven[i] = startIdxOdd[maxIdx[i]];
			} else {
				startIdxEven[i] = false;
			}

			if (startIdxOdd[i]) {
				answer++;
			}
		}

		return answer;
	}
}
