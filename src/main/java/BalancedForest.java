import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BalancedForest {

	private static class Node {
		private int seq;
		private int value;
		private List<Edge> edges;

		public Node(int s, int v) {
			this.seq = s;
			this.value = v;
			this.edges = new ArrayList<>();
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Node)) {
				return false;
			}
			return this.seq == ((Node) obj).seq;
		}

		public int getSeq() {
			return seq;
		}
	}

	private static class Edge {
		private int seq;
		private Integer weight;

		public Edge(int seq, int w) {
			this.seq = seq;
			this.weight = w;
		}
	}

	static int balancedForest(int[] c, int[][] edges) {
		List<Node> nodeList = createNodes(c, edges);

		DFS(nodeList, 1, 0);

		sortEdges(nodeList);

		computeCombinations(nodeList, 1);

		return 0;
	}

	private static void computeCombinations(List<Node> nodeList, int seq) {
		Node node = nodeList.stream().filter(x -> x.getSeq() == seq).collect(Collectors.toList()).get(0);

		for (int i = 0; i < node.edges.size(); i++) {

		}
	}

	// Sort by its weight
	private static void sortEdges(List<Node> nodeList) {
		for (Node node : nodeList) {
			Collections.sort(node.edges, Comparator.comparing(o -> o.weight));
		}
	}

	private static int DFS(List<Node> nodeList, int seq, Integer parent) {
		int sumWeight = 0;

		Node node = nodeList.stream().filter(x -> x.getSeq() == seq).collect(Collectors.toList()).get(0);

		List<Edge> destinations = node.edges;

		if (destinations.size() == 1) {
			return node.value;
		}

		for (int i = 0; i < destinations.size(); i++) {

			Edge nextEdge = destinations.get(i);

			// destination seq
			int to = nextEdge.seq;

			if (to == parent) {
				continue;
			}

			// the value we get if we traverse along this path
			int w = DFS(nodeList, to, seq);
			nextEdge.weight = w;

			//			destinations.set(i, distance);

			sumWeight += w;
		}

		// the value we get if we traverse along this node and along the path
		return node.value + sumWeight;
	}

	private static List<Node> createNodes(int[] c, int[][] edges) {
		List<Node> nodeList = new ArrayList<>();

		for (int[] edge : edges) {

			Node from = new Node(edge[0], c[edge[0] - 1]);
			Node to = new Node(edge[1], c[edge[1] - 1]);

			from = updateNodeList(nodeList, from, to);
			to = updateNodeList(nodeList, to, from);
		}

		return nodeList;
	}

	private static Node updateNodeList(List<Node> nodeList, Node from, Node to) {
		int fromPos = nodeList.indexOf(from);

		if (fromPos == -1) {
			nodeList.add(from);
			from = nodeList.get(nodeList.size() - 1);
		} else {
			from = nodeList.get(fromPos);
		}

		from.edges.add(new Edge(to.seq, 0));

		return from;
	}
}
