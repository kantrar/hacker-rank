import java.util.ArrayList;
import java.util.List;

public class MinimumPenaltyPath3 {
	static int beautifulPath(int noNodes, int[][] edges, int source, int destination) {
		List<Edge>[] edgeList = readEdges(noNodes, edges);

		boolean[] visited = new boolean[noNodes + 1];
		return search(edgeList, visited, source, destination);

	}

	private static int search(List<Edge>[] edgeList, boolean[] visited, int source, int destination) {

		if (source == destination) {
			return 0;
		}

		visited[source] = true;

		int total = Integer.MAX_VALUE;
		for (Edge next : edgeList[source]) {
			if (visited[next.to]) {
				continue;
			}

			int result = search(edgeList, visited, next.to, destination);
			if (result == -1) {
				continue;
			}

			total = Math.min(total, result | next.distance);
		}

		visited[source] = false;

		return total == Integer.MAX_VALUE ? -1 : total;
	}

	static List<Edge>[] readEdges(int noNodes, int[][] edges) {
		List<Edge>[] edgeList = new ArrayList[noNodes + 1];
		for (int i = 1; i <= noNodes; i++) {
			edgeList[i] = new ArrayList<>();
		}

		for (int i = 0; i < edges.length; i++) {
			int f = edges[i][0];
			int t = edges[i][1];
			int d = edges[i][2];

			edgeList[f].add(new Edge(f, t, d));
			edgeList[t].add(new Edge(t, f, d));
		}

		return edgeList;
	}

	public static class Edge {
		int from;
		int to;
		int distance;

		public Edge(int f, int t, int d) {
			this.from = f;
			this.to = t;
			this.distance = d;
		}
	}
}
