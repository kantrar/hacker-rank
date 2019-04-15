public class ShortestSubarrayWithSumAtLeastK {
	public int shortestSubarray(int[] A, int K) {
		if (A.length == 0) {
			return -1;
		}

		int right = 0;
		int left = 0;
		int answer = Integer.MAX_VALUE;
		int sum = 0;

		while (right < A.length) {
			sum += A[right];

			if (sum >= K) {
				answer = Math.min(answer, right - left + 1);
			}

			while (left < right && (sum >= K || A[left] <= 0)) {
				sum -= A[left];
				left++;
				if (sum >= K) {
					answer = Math.min(answer, right - left + 1);
				}
			}

			right++;
		}

		return answer == Integer.MAX_VALUE ? -1 : answer;
	}
}
