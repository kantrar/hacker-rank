import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrimMST {

	static class Node {
		int node;
		int weight;

		public Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}

	static int prims(int n, int[][] edges, int start) {
		Map<Integer, List<Node>> adjNodes = new HashMap<>();
		ArrayList<Integer> visitedNodes = new ArrayList<>();

		for (int i = 0; i < edges.length; i++) {
			int fromNode = edges[i][0];
			int toNode = edges[i][1];
			int weight = edges[i][2];

			updateMap(adjNodes, fromNode, toNode, weight);
		}

		visitedNodes.add(start);
		ArrayList<Node> potentialNodes = new ArrayList<>(adjNodes.get(start));
		return findMinWeightNode(n, visitedNodes, potentialNodes, adjNodes);

	}

	private static int findMinWeightNode(int noNodes, List<Integer> visitedNodes, List<Node> potentialNodes,
			Map<Integer, List<Node>> adjNodes) {

		int answer = 0;

		while (visitedNodes.size() < noNodes) {
			potentialNodes.sort(Comparator.comparingInt(o -> o.weight));

			Node removedNode;
			do {
				removedNode = potentialNodes.remove(0);
			} while(visitedNodes.contains(removedNode.node));

			answer += removedNode.weight;
			visitedNodes.add(removedNode.node);

			potentialNodes.addAll(adjNodes.get(removedNode.node).stream().filter(node -> !visitedNodes.contains(node.node))
					.collect(Collectors.toList()));
		}

		return answer;
	}

	static void updateMap(Map<Integer, List<Node>> adjNodes, int fromNode, int toNode, int weight) {
		List<Node> nodes;

		nodes = adjNodes.getOrDefault(fromNode, new ArrayList<>());
		nodes.add(new Node(toNode, weight));
		adjNodes.put(fromNode, nodes);

		nodes = adjNodes.getOrDefault(toNode, new ArrayList<>());
		nodes.add(new Node(fromNode, weight));
		adjNodes.put(toNode, nodes);
	}
}
