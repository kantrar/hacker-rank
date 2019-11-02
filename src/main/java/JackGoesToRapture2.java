import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class JackGoesToRapture2 {
	private static class Node {
		List<Edge> edges;
		long cost;

		public Node() {
			edges = new ArrayList<>();
			cost = -1;
		}
	}

	private static class Edge {
		Node fromNode;
		Node toNode;
		int weight;

		public Edge(Node fromNode, Node toNode, int weight) {
			this.fromNode = fromNode;
			this.toNode = toNode;
			this.weight = weight;
		}

		public long getCost() {
			if (fromNode.cost > weight) {
				return fromNode.cost;
			}
			return weight;
		}
	}

	// Possible solutions
	// Dijkstra's algorithm
	// Prim's algorithm (similar place Dijkstra's)
	// BFS (May compute costs of unnecessary nodes)
	// DFS (May compute costs of unnecessary nodes)

	// Dijkstra's is the most appropriate one
	public static long getCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
		List<Node> nodes = buildGraph(gNodes, gFrom, gTo, gWeight);

		return findMinimumCost(nodes);
	}

	private static List<Node> buildGraph(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
		List<Node> nodes = new ArrayList<>();

		for (int i = 0; i < gNodes; i++) {
			nodes.add(new Node());
		}

		for (int i = 0; i < gFrom.size(); i++) {
			Node node1 = nodes.get(gFrom.get(i) - 1);
			Node node2 = nodes.get(gTo.get(i) - 1);
			int weight = gWeight.get(i);

			node1.edges.add(new Edge(node1, node2, weight));
			node2.edges.add(new Edge(node2, node1, weight));
		}

		return nodes;
	}

	private static long findMinimumCost(List<Node> nodes) {
		Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingLong(Edge::getCost));

		Node currentNode = nodes.get(0);
		Node targetNode = nodes.get(nodes.size() - 1);

		do {
			for (Edge edge : currentNode.edges) {
				Node nextNode = edge.toNode;
				if (nextNode.cost == -1) {
					queue.add(edge);
				}
			}

			Edge minimumCostEdge = queue.remove();
			Node nextNode = minimumCostEdge.toNode;

			if (nextNode.cost == -1) {
				if (currentNode.cost > minimumCostEdge.weight) {
					nextNode.cost = currentNode.cost;
				} else {
					nextNode.cost = minimumCostEdge.weight;
				}

				if (nextNode == targetNode) {
					return nextNode.cost;
				}
			}

			currentNode = nextNode;

		} while (!queue.isEmpty());

		return -1;
	}
}
