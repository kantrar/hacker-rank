import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestPathWithAlternatingColors {
	private static int answer[];

	public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
		answer = new int[n];
		Arrays.fill(answer, -1);
		List<int[]>[] edges = new List[n];
		for (int i = 0; i < n; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 0; i < redEdges.length; i++) {
			int from = redEdges[i][0];
			int to = redEdges[i][1];
			// red => 0
			edges[from].add(new int[] {to, 0});
		}

		for (int i = 0; i < blueEdges.length; i++) {
			int from = blueEdges[i][0];
			int to = blueEdges[i][1];
			// blue => 1
			edges[from].add(new int[] {to, 1});
		}

		int[][] visited = new int[n][2];
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], -1);
		}
		traverse(0, 0, 0, edges, visited);

		visited = new int[n][2];
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], -1);
		}
		traverse(0, 1, 0, edges, visited);

		return answer;
	}

	public void traverse(int node, int srcColor, int distance, List<int[]>[] edges, int[][] visited) {
		visited[node][srcColor] = distance;
		answer[node] = answer[node] == -1 ? distance : Math.min(distance, answer[node]);
		for (int[] next : edges[node]) {
			int to = next[0];
			int color = next[1];
			if (srcColor != color && (visited[to][color] == -1 || visited[to][color] > distance + 1)) {
				traverse(to, color, distance + 1, edges, visited);
			}
		}
	}
}

