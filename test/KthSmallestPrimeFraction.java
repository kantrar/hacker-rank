import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
	public int[] kthSmallestPrimeFraction(int[] A, int K) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> A[a[0]] * A[b[1]] - A[b[0]] * A[a[1]]);
		for (int i = 0; i < A.length - 1; i++) {
			queue.offer(new int[] {i, A.length - 1});
		}

		while (K > 1 && !queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] + 1 != cur[1]) {
				queue.offer(new int[] {cur[0], cur[1] - 1});
			}
			K--;
		}

		return queue.isEmpty() ? new int[0] : new int[] {A[queue.peek()[0]], A[queue.peek()[1]]};
	}
}
