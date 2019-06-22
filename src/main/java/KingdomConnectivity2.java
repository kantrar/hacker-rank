import java.util.List;

public class KingdomConnectivity2 {
	public static int countPaths(int noNodes, int[][] edges) {
		List<KingdomConnectivity.Edge>[] edgeList = KingdomConnectivity.readEdges(noNodes, edges);

		boolean[] visited = new boolean[noNodes + 1];
		return count(edgeList, visited, 1, noNodes);
	}

	private static int count(List<KingdomConnectivity.Edge>[] edgeList, boolean[] visited, int source, int destination) {
		if (source == destination) {
			return 1;
		}

		visited[source] = true;

		int total = 0;
		for (KingdomConnectivity.Edge next : edgeList[source]) {
			if (visited[next.to]) {
				return -1;
			}

			int result = count(edgeList, visited, next.to, destination);
			if (result != -1) {
				total += result;
			}
		}

		visited[source] = false;
		return total;
	}
}
