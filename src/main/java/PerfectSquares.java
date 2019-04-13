import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
	public int numSquares(int n) {
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		int distance = 0;
		visited[n] = true;

		while (!queue.isEmpty()) {
			Queue<Integer> nextQueue = new LinkedList<>();

			for (Integer current : queue) {
				int max = (int) Math.sqrt(current);
				for (int i = 1; i <= max; i++) {

					int nextTarget = n - (int) Math.pow(i, 2);
					if (nextTarget == 0) {
						return distance;
					}
					if (visited[nextTarget]) {
						continue;
					}
					visited[nextTarget] = true;
					nextQueue.add(nextTarget);
				}
			}
			queue = nextQueue;
			distance++;
		}

		return -1;
	}
}
