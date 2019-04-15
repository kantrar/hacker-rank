import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
	public int numSquares(int n) {
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		int distance = 0;

		while (!queue.isEmpty()) {
			Queue<Integer> nextQueue = new LinkedList<>();
			distance++;

			for (Integer current : queue) {
				int max = (int) Math.sqrt(current);
				for (int i = 1; i <= max; i++) {

					int nextTarget = current - (int) Math.pow(i, 2);
					if (nextTarget == 0) {
						return distance;
					}
					if (nextTarget > 0) {
						nextQueue.add(nextTarget);
					}
				}
			}
			queue = nextQueue;

		}

		return -1;
	}
}
