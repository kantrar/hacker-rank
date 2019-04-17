import java.util.ArrayList;
import java.util.List;

public class MinimumPenaltyPath2 {
	static int beautifulPath(int noNodes, int[][] edges, int source, int destination) {
		List<Edge>[] edgeList = readEdges(noNodes, edges);
		int[] currentDistances = new int[noNodes + 1];
		int[][] visitedWithCost = new int[noNodes + 1][1024];
		boolean[] visited = new boolean[noNodes + 1];

		return search(edgeList, currentDistances, visitedWithCost, visited, source, destination);
	}

	private static int search(List<Edge>[] edgeList, int[] currentDistances, int[][] visitedWithCost, boolean[] visited,
			int source, int destination) {
		if (visitedWithCost[source][currentDistances[source]] != 0) {
			return visitedWithCost[source][currentDistances[source]];
		}

		int minDistance = Integer.MAX_VALUE;

		visited[source] = true;

		for (Edge next : edgeList[source]) {
			if (visited[next.to]) {
				continue;
			}

			currentDistances[next.to] = currentDistances[source] | next.distance;

			if (next.to == destination) {
				minDistance = Math.min(minDistance, currentDistances[next.to]);
				continue;
			}

			int res = search(edgeList, currentDistances, visitedWithCost, visited, next.to, destination);
			if (res != -1) {
				minDistance = Math.min(minDistance, res);
			}
		}

		visited[source] = false;

		minDistance = minDistance == Integer.MAX_VALUE ? -1 : minDistance;
		visitedWithCost[source][currentDistances[source]] = minDistance;

		return minDistance;
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
