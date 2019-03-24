import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindTheNearestClone {
	public static class Graph {
		int noNodes;
		List<Integer> edges[];
		int[] colors;
		int[] distances;
		int[] distancesFromSameColor;

		public Graph(int n) {
			this.noNodes = n;
			edges = new ArrayList[noNodes + 1];
			for (int i = 0; i <= noNodes; i++) {
				edges[i] = new ArrayList<>();
			}
			colors = new int[noNodes + 1];
			distances = new int[noNodes + 1];
			distancesFromSameColor = new int[noNodes + 1];
		}

		public void addEdge(int from, int to) {
			edges[from].add(to);
			edges[to].add(from);
		}


		// Timeout, incorrect, incomplete
		public int DFS(int color, int startNode, List<Integer> nodesOfSameColor) {
			boolean[] visited = new boolean[noNodes + 1];

			distances[startNode] = 0;
			distancesFromSameColor[startNode] = 0;

			DFS(color, startNode, startNode, visited);

			int min = Integer.MAX_VALUE;
			for (Integer node : nodesOfSameColor) {
				if (distancesFromSameColor[node] != 0) {
					min = Math.min(min, distancesFromSameColor[node]);
				}
			}

			return min == Integer.MAX_VALUE ? -1 : min;
		}

		// color = 1
		// startNode = 1
		// parentNode = 1
		// visited = {1,1,1,1}
		// distances = {0,1,1,2}
		// distancesFromSameColor = {0,-1,1,2}
		// edges[1] = {2x,3x}

		public void DFS(int color, int startNode, int parentNode, boolean[] visited) {
			visited[startNode] = true;

			for (int edge : edges[startNode]) {
				if (!visited[edge]) {
					if (colors[edge] == color) {
						distances[edge] = distances[startNode] + 1;

						int newDistance = distances[edge] - distances[parentNode];
						if (distancesFromSameColor[edge] == 0 || distancesFromSameColor[edge] > newDistance) {
							distancesFromSameColor[edge] = newDistance;
						}

						DFS(color, edge, edge, visited);

					} else {
						distances[edge] = distances[startNode] + 1;
						distancesFromSameColor[edge] = -1;

						DFS(color, edge, parentNode, visited);
					}
				}
			}
		}
	}

	static int findTheNearestClone(int noNodes, int[] gFrom, int[] gTo, int[] gColor, int colorToMatch) {
		List<Integer> nodesOfSameColor = new LinkedList<>();
		int startNode = 0;
		Graph graph = new Graph(noNodes);
		for (int i = 0; i < gFrom.length; i++) {
			graph.addEdge(gFrom[i], gTo[i]);
		}

		for (int i = 0; i < gColor.length; i++) {
			graph.colors[i + 1] = gColor[i];
			if (gColor[i] == colorToMatch) {
				startNode = i + 1;
				nodesOfSameColor.add(i + 1);
			}
		}

		return graph.DFS(colorToMatch, startNode, nodesOfSameColor);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] graphNodesEdges = scanner.nextLine().split(" ");
		int graph_nodes = Integer.parseInt(graphNodesEdges[0].trim());
		int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

		int[] graphFrom = new int[graphEdges];
		int[] graphTo = new int[graphEdges];

		for (int i = 0; i < graphEdges; i++) {
			String[] graphFromTo = scanner.nextLine().split(" ");
			graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
			graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
		}

		int[] ids = new int[graph_nodes];

		String[] idsItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < graph_nodes; i++) {
			int idsItem = Integer.parseInt(idsItems[i]);
			ids[i] = idsItem;
		}

		int val = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int ans = findTheNearestClone(graph_nodes, graphFrom, graphTo, ids, val);

		System.out.println(ans);

		scanner.close();
	}
}
