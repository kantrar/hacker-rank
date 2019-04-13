import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KingdomConnectivity {
	public static class Edge {
		int from;
		int to;

		public Edge(int f, int t) {
			this.from = f;
			this.to = t;
		}
	}


	/*
	 * Complete the 'countPaths' function below.
	 *
	 * The function accepts following parameters:
	 *  1. INTEGER n
	 *  2. 2D_INTEGER_ARRAY edges
	 */

	public static int countPaths(int noNodes, int[][] edges) {
		List<Edge>[] edgeList = readEdges(noNodes, edges);

		boolean[] visited = new boolean[noNodes + 1];
		int[] paths = new int[noNodes + 1];
		Arrays.fill(paths, -1);

		return DFS(noNodes, edgeList, 1, noNodes, paths, visited);
	}

	public static int DFS(int noNodes, List<Edge>[] edgeList, int source, int destination, int[] paths, boolean[] visited) {
		if (source == destination) {
			return 1;
		}

		if (paths[source] != -1) {
			return paths[source];
		}

		int total = 0;
		visited[source] = true;

		for (Edge next : edgeList[source]) {
			if (visited[next.to]) {
				return -1;
			}

			int result = DFS(noNodes, edgeList, next.to, destination, paths, visited);
			if (result == -1) {
				continue;
			}
			result = result % 1000000000;
			total += result;
			total = total % 1000000000;
		}

		visited[source] = false;
		paths[source] = total;
		return total;
	}

	public static List<Edge>[] readEdges(int noNodes, int[][] edges) {
		List<Edge>[] edgeList = new ArrayList[noNodes + 1];
		for (int i = 1; i <= noNodes; i++) {
			edgeList[i] = new ArrayList<>();
		}
		for (int i = 0; i < edges.length; i++) {
			edgeList[edges[i][0]].add(new Edge(edges[i][0], edges[i][1]));
		}

		return edgeList;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int nodes = scanner.nextInt();

		int m = scanner.nextInt();

		int[][] edges = new int[m][2];

		for (int i = 0; i < m; i++) {
			edges[i][0] = scanner.nextInt();
			edges[i][1] = scanner.nextInt();
		}

		int result = countPaths(nodes, edges);
		if (result != -1) {
			System.out.println(result);
		} else {
			System.out.println("INFINITE PATHS");
		}
	}
}
