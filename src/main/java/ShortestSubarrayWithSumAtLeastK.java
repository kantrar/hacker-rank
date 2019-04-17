import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarrayWithSumAtLeastK {
	public int shortestSubarray(int[] A, int K) {
		if (A.length == 0) {
			return -1;
		}

		int[] sum = new int[A.length + 1];
		for (int i = 0; i < A.length; i++) {
			sum[i + 1] = sum[i] + A[i];
		}

		int answer = Integer.MAX_VALUE;
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < sum.length; i++) {
			while (!stack.isEmpty() && sum[i] <= sum[stack.peekLast()]) {
				stack.removeLast();
			}

			while (!stack.isEmpty() && sum[i] - sum[stack.peekFirst()] >= K) {
				answer = Math.min(answer, i - stack.removeFirst());
			}

			stack.addLast(i);
		}

		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

}
