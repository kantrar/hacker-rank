import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	private static class Node {
		private List<Edge> edges;

		public Node() {
			edges = new ArrayList<>();
		}
	}

	private static class Edge {
		private int from;
		private int to;

		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}

	}

	public static long BFS(int gNodes, List<Integer> gFrom, List<Integer> gTo, int start) {
		List<Node> nodes = buildNodes(gNodes);
		buildGraph(nodes, gFrom, gTo);

		BFS(nodes, start);

		return 0L;
	}

	private static int[] BFS(List<Node> nodes, int start) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(nodes.get(start));

		boolean[] visited = new boolean[nodes.size()];
		visited[start] = true;

		int distance = 1;
		int[] distances = new int[nodes.size()];
		Arrays.fill(distances, -1);
		distances[start] = 0;

		while (!queue.isEmpty()) {
			Queue<Node> nextQueue = new LinkedList<>();

			for (Node currentNode : queue) {
				for (Edge edge : currentNode.edges) {
					if (!visited[edge.to]) {
						visited[edge.to] = true;
						distances[edge.to] = distance;
						nextQueue.add(nodes.get(edge.to));
					}
				}
			}

			distance++;
			queue = nextQueue;
		}

		return distances;
	}

	private static List<Node> buildNodes(int gNodes) {
		List<Node> nodes = new ArrayList<>();
		nodes.add(new Node());

		for (int i = 0; i < gNodes; i++) {
			nodes.add(new Node());
		}

		return nodes;
	}

	private static void buildGraph(List<Node> nodes, List<Integer> gFrom, List<Integer> gTo) {
		for (int i = 0; i < gFrom.size(); i++) {
			int from = gFrom.get(i);
			int to = gTo.get(i);

			nodes.get(from).edges.add(new Edge(from, to));
			nodes.get(to).edges.add(new Edge(to, from));
		}
	}

}
