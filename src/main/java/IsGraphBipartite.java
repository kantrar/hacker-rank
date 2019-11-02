import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
	int BLACK = 0;
	int RED = 1;

	public boolean isBipartite(int[][] graph) {
		if (graph == null || graph.length == 0) {
			return true;
		}
		int noNodes = graph.length;
		int[] color = new int[noNodes];
		boolean[][] visited = new boolean[noNodes][noNodes];
		Arrays.fill(color, -1);
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < noNodes; i++) {
			queue.offer(new int[] {i, -1});
			while (!queue.isEmpty()) {
				Queue<int[]> nextQueue = new LinkedList<>();
				for (int[] current : queue) {
					if (current[1] == -1 || color[current[0]] == -1) {
						color[current[0]] = BLACK;
					}
					for (int next : graph[current[0]]) {
						if (visited[current[0]][next]) {
							continue;
						}
						visited[current[0]][next] = true;
						nextQueue.offer(new int[] {next, current[0]});
						if (color[next] == color[current[0]]) {
							return false;
						}
						color[next] = (color[current[0]] + 1) % 2;
					}
				}
				queue = nextQueue;
			}
		}

		return true;
	}
}
