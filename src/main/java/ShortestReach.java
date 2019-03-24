import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class ShortestReach {
	private static class Graph {
		int noNodes;
		Set<Integer> edges[];

		public Graph(int n) {
			this.noNodes = n;
			edges = new HashSet[n + 1];
			for (int i = 0; i <= n; i++) {
				edges[i] = new HashSet<>();
			}
		}

		public void addEdge(int from, int to) {
			edges[from].add(to);
			edges[to].add(from);
		}

		// Shortest Path using Topological Sorting
		public int[] findShortestPathsByTopologicalSorting(int source) {
			Stack<Integer> stack = new Stack<>();
			boolean[] visited = new boolean[noNodes + 1];
			topologicalSort(source, visited, stack);

			int[] distance = new int[noNodes + 1];
			for (int i = 0; i <= noNodes; i++) {
				distance[i] = -1;
			}

			distance[source] = 0;

			while (!stack.isEmpty()) {
				int node = stack.pop();

				// 2, 48, 102, 117, 330, 438
				// 247, 36, 63, 96, 120, 315, 336, 462
				// 36, 390, 331, 247, 174, 111, 71, 421, 399, 327, 97, 113, 398, 273, 351, 399, 156, 423, 456
				// 63,
				for (Integer to : edges[node]) {
					if (distance[to] == -1 || distance[to] > distance[node] + 6) {
						distance[to] = distance[node] + 6;
					}
				}
			}

			int[] answers = new int[noNodes - 1];
			int idx = 0;
			for (int i = 1; i <= noNodes; i++) {
				if (i == source) {
					continue;
				}
				answers[idx++] = distance[i];
			}

			return answers;
		}

		private void topologicalSort(int node, boolean[] visited, Stack<Integer> stack) {
			visited[node] = true;

			for (Integer to : edges[node]) {
				if (!visited[to]) {
					topologicalSort(to, visited, stack);
				}
			}

			stack.push(node);
		}

		// BFS
		public int[] findShortestPaths(int source) {
			boolean[] visited = new boolean[noNodes + 1];
			int[] distance = new int[noNodes + 1];

			for (int i = 0; i <= noNodes; i++) {
				distance[i] = -1;
			}

			distance[source] = 0;
			Queue<Integer> queue = new LinkedList<>();
			queue.add(source);
			while (!queue.isEmpty()) {
				int currentNode = queue.remove();
				visited[currentNode] = true;

				for (int edge : edges[currentNode]) {
					if (!visited[edge]) {
						if (distance[edge] == -1 || distance[edge] > distance[currentNode] + 6) {
							distance[edge] = distance[currentNode] + 6;
						}
						queue.add(edge);
					}
				}
			}

			int[] answer = new int[noNodes - 1];
			int idx = 0;
			for (int i = 1; i <= noNodes; i++) {
				if (i == source) {
					continue;
				}

				answer[idx++] = distance[i];
			}

			return answer;
		}

	}

	// Complete the bfs function below.
	static int[] bfs(int noNodes, int noEdges, int[][] edges, int source) {
		Graph g = new Graph(noNodes);
		for (int i = 0; i < edges.length; i++) {
			int from = edges[i][0];
			int to = edges[i][1];

			g.addEdge(from, to);
		}

		return g.findShortestPathsByTopologicalSorting(source);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] nm = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nm[0]);

			int m = Integer.parseInt(nm[1]);

			int[][] edges = new int[m][2];

			for (int i = 0; i < m; i++) {
				String[] edgesRowItems = scanner.nextLine().split(" ");
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				for (int j = 0; j < 2; j++) {
					int edgesItem = Integer.parseInt(edgesRowItems[j]);
					edges[i][j] = edgesItem;
				}
			}

			int s = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] result = bfs(n, m, edges, s);

			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}

		}

		scanner.close();
	}
}
