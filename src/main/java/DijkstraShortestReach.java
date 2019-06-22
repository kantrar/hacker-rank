import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraShortestReach {
	public static int[] shortestReach(int noNodes, int[][] edges, int source) {
		List<Edge>[] edgeList = readEdges(noNodes, edges);

		boolean[] visited = new boolean[noNodes + 1];
		visited[source] = true;

		int[] distances = new int[noNodes + 1];
		Arrays.fill(distances, -1);
		distances[source] = 0;

		find(edgeList, source, visited, distances);

		int idx = 0;
		int[] answers = new int[noNodes - 1];
		for (int i = 1; i <= noNodes; i++) {
			if (i != source) {
				answers[idx++] = distances[i];
			}
		}

		return answers;
	}

	private static void find(List<Edge>[] edgeList, int source, boolean[] visited, int[] distances) {
		Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

		for (Edge edge : edgeList[source]) {
			queue.offer(edge);
		}

		while (!queue.isEmpty()) {
			Edge current = queue.poll();
			visited[current.to] = true;

			if (distances[current.to] == -1 || distances[current.to] > distances[current.from] + current.weight) {
				distances[current.to] = distances[current.from] + current.weight;
			}

			for (Edge next : edgeList[current.to]) {
				if (visited[next.to]) {
					continue;
				}
				queue.offer(next);
			}
		}
	}

	public static class Edge {
		int from;
		int to;
		int weight;

		public Edge(int f, int t, int w) {
			this.from = f;
			this.to = t;
			this.weight = w;
		}

		public int getWeight() {
			return weight;
		}
	}

	private static List<Edge>[] readEdges(int noNodes, int[][] edges) {
		List<Edge>[] edgeList = new ArrayList[noNodes + 1];
		for (int i = 1; i <= noNodes; i++) {
			edgeList[i] = new ArrayList<>();
		}
		for (int i = 0; i < edges.length; i++) {
			Edge e1 = new Edge(edges[i][0], edges[i][1], edges[i][2]);
			Edge e2 = new Edge(edges[i][1], edges[i][0], edges[i][2]);

			edgeList[e1.from].add(e1);
			edgeList[e2.from].add(e2);
		}

		return edgeList;
	}
}
