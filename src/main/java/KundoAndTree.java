import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


// Incorrect, Incomplete
public class KundoAndTree {
	private static int time = 1;
	private static List<Node> nodes;
	private static List<Edge> redEdges = new ArrayList<>();

	private static class Node {
		int arrivalTime;
		int leaveTime;
		int noNodesAfter; // include itself
		List<Node> nextNodes = new ArrayList<>();
	}

	private static class Edge {
		Node fromNode;
		Node toNode;

		private Edge(Node from, Node to) {
			this.fromNode = from;
			this.toNode = to;
		}

		private int getFromNodeArrivalTime() {
			return fromNode.arrivalTime;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int noNodes = scanner.nextInt();

		int[][] edgesInput = new int[noNodes - 1][2];
		char[] colours = new char[noNodes - 1];

		for (int i = 0; i < noNodes - 1; i++) {
			edgesInput[i][0] = scanner.nextInt();
			edgesInput[i][1] = scanner.nextInt();
			colours[i] = scanner.next().charAt(0);
		}

		if (noNodes <= 2) {
			System.out.println(0);
			return;
		}

		System.out.println(findNumberOfTriplets(noNodes, edgesInput, colours));
	}

	private static long findNumberOfTriplets(int noNodes, int[][] edgesInput, char[] colours) {
		long answer = 0;

		buildGraphs(noNodes, edgesInput, colours);

		Node rootNode = getNodeBySeq(1);
		calculateTime(rootNode, null);

		redEdges.sort(Comparator.comparingInt(Edge::getFromNodeArrivalTime));

		for (int i = 0; i < redEdges.size(); i++) {
			Node node1 = redEdges.get(i).fromNode;
			Node pairOfNode1 = redEdges.get(i).toNode;

			swapNode(node1, pairOfNode1);

			for (int j = i + 1; j < redEdges.size(); j++) {
				Node node2 = redEdges.get(j).fromNode;
				Node pairOfNode2 = redEdges.get(j).toNode;

				swapNode(node2, pairOfNode2);

				if (sameEdge(node1, pairOfNode1, node2, pairOfNode2)) {
					continue;
				}

				if (isOnSamePath(node1, pairOfNode1, node2, pairOfNode2)) {
					int nodesAtOneEnd = findAllNodesAfter(pairOfNode2);
					int nodesBetween = findAllNodesAfter(pairOfNode1) - findAllNodesAfter(pairOfNode2);
					int nodesAtTheOtherEnd = findAllNodesAfter(rootNode) - findAllNodesAfter(pairOfNode1);

					answer += nodesAtOneEnd * nodesBetween * nodesAtTheOtherEnd;
				} else {
					int nodesAtOneEnd = findAllNodesAfter(pairOfNode1);
					int nodesBetween =
							findAllNodesAfter(rootNode) - findAllNodesAfter(pairOfNode1) - findAllNodesAfter(pairOfNode2);
					int nodesAtTheOtherEnd = findAllNodesAfter(pairOfNode2);

					answer += nodesAtOneEnd * nodesBetween * nodesAtTheOtherEnd;
				}
			}
		}



		return answer;
	}

	private static void buildGraphs(int noNodes, int[][] edges, char[] colours) {
		nodes = new ArrayList<>();

		for (int i = 0; i < noNodes; i++) {
			nodes.add(new Node());
		}

		for (int i = 0; i < edges.length; i++) {
			Node n1 = getNodeBySeq(edges[i][0]);
			Node n2 = getNodeBySeq(edges[i][1]);

			n1.nextNodes.add(n2);
			n2.nextNodes.add(n1);

			if (colours[i] == 'r') {
				redEdges.add(new Edge(n1, n2));
			}
		}
	}

	private static Node getNodeBySeq(int seq) {
		return nodes.get(seq - 1);
	}

	private static void calculateTime(Node currentNode, Node parentNode) {
		int noNodesAfter = 1;
		currentNode.arrivalTime = time++;

		for (Node next : currentNode.nextNodes) {
			if (next != parentNode) {
				calculateTime(next, currentNode);
				noNodesAfter += next.noNodesAfter;
			}
		}

		currentNode.noNodesAfter = noNodesAfter;
		currentNode.leaveTime = time++;
	}

	private static boolean sameEdge(Node node1, Node pairOfNode1, Node node2, Node pairOfNode2) {
		if (node1 == node2 && pairOfNode1 == pairOfNode2) {
			return true;
		}

		return false;
	}

	private static boolean isOnSamePath(Node node1, Node pairOfNode1, Node node2, Node pairOfNode2) {
		if (pairOfNode1.arrivalTime <= node2.arrivalTime && pairOfNode1.leaveTime >= node2.leaveTime) {
			return true;
		}

		return false;
	}

	// To ensure that n1 is always a parent of n2
	private static void swapNode(Node n1, Node n2) {
		if (n1.arrivalTime < n2.arrivalTime) {
			return;
		}

		Node temp = n1;
		n1 = n2;
		n2 = temp;
	}

	private static int findAllNodesAfter(Node node) {
		return node.noNodesAfter;
	}

}
