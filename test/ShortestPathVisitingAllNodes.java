import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {
	public int shortestPathLength(int[][] graph) {
		int targetMask = (1 << graph.length) - 1;
		int[][] dp = new int[graph.length][(1 << graph.length)];

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(dp[i], -1);
			queue.offer(new int[] {i, 1 << i});
			dp[i][(1 << i)] = 0;
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int next : graph[cur[0]]) {
				int nextState = cur[1] | (1 << next);
				if (dp[next][nextState] == -1 || dp[next][nextState] > dp[cur[0]][cur[1]] + 1) {
					dp[next][nextState] = dp[cur[0]][cur[1]] + 1;
					queue.offer(new int[] {next, nextState});
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < graph.length; i++) {
			min = Math.min(min, dp[i][targetMask]);
		}
		return min;
	}
}
