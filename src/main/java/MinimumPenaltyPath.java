import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MinimumPenaltyPath {
	private static class Node {
		List<Edge> edgeList;
		int penalty;
		int seq;

		public Node(int s) {
			this.edgeList = new ArrayList<>();
			this.penalty = -1;
			this.seq = s;
		}
	}

	private static class Edge {
		Node fromNode;
		Node toNode;
		int cost;

		public Edge(Node f, Node t, int c) {
			this.fromNode = f;
			this.toNode = t;
			this.cost = c;
		}

		public int getPenalty() {
			return fromNode.penalty | this.cost;
		}
	}

	// Use DFS instead
	// Consider the case
	//	8 9
	//	1 2 1
	//	1 3 2
	//	2 4 1
	//	3 4 2
	//	4 5 10
	//	5 6 1
	//	5 7 2
	//	6 8 1
	//	7 8 2
	//	1 8
	// Solution is 10
	static int beautifulPath(int noNodes, int[][] edges, int src, int dest) {
		List<Node> nodes = initNodes(noNodes);
		boolean[] visitedNodes = new boolean[noNodes + 1];
		boolean[][] visitedEdges = new boolean[noNodes + 1][1024];

		for (int i = 0; i <= noNodes; i++) {
			for (int j = 0; j < 1024; j++) {
				visitedEdges[i][j] = false;
			}
		}

		addEdgesToNodes(edges, nodes);

		Node srcNode = getNodeBySeq(nodes, src);
		srcNode.penalty = 0;

		Node destNode = getNodeBySeq(nodes, dest);

		return findPathUsingDFS(visitedEdges, visitedNodes, srcNode, destNode, null);
	}

	private static int findPathUsingDFS(boolean[][] visitedEdges, boolean[] visitedNodes, Node srcNode, Node destNode,
			Node prevNode) {
		visitedNodes[srcNode.seq] = true;
		visitedEdges[srcNode.seq][srcNode.penalty] = true;

		if (srcNode == destNode) {
			visitedNodes[srcNode.seq] = false;
			return srcNode.penalty;
		}

		int minPenalty = Integer.MAX_VALUE;
		for (Edge edge : srcNode.edgeList) {
			if (edge.toNode == prevNode) {
				continue;
			}

			if (visitedNodes[edge.toNode.seq]) {
				continue;
			}

			if (visitedEdges[edge.toNode.seq][edge.getPenalty()]) {
				continue;
			}

			edge.toNode.penalty = edge.getPenalty();

			int p = findPathUsingDFS(visitedEdges, visitedNodes, edge.toNode, destNode, srcNode);

			if (p == -1) {
				continue;
			}

			p = srcNode.penalty | p;
			if (minPenalty > p) {
				minPenalty = p;
			}

		}

		visitedNodes[srcNode.seq] = false;
		return minPenalty == Integer.MAX_VALUE ? -1 : minPenalty;
	}

	// Dijkstra's algorithm gives wrong answer
	// as we cannot decide if it's really the path with minimum penalty.
	static int beautifulPath2(int noNodes, int[][] edges, int src, int dest) {
		List<Node> nodes = initNodes(noNodes);
		addEdgesToNodes(edges, nodes);

		return findPathUsingDijkstra(nodes, src, dest);
	}

	private static void addEdgesToNodes(int[][] edges, List<Node> nodes) {
		for (int i = 0; i < edges.length; i++) {
			int from = edges[i][0];
			Node fromNode = getNodeBySeq(nodes, from);

			int to = edges[i][1];
			Node toNode = getNodeBySeq(nodes, to);

			int cost = edges[i][2];

			fromNode.edgeList.add(new Edge(fromNode, toNode, cost));
			toNode.edgeList.add(new Edge(toNode, fromNode, cost));
		}
	}

	private static List<Node> initNodes(int size) {
		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			nodes.add(new Node(i + 1));
		}
		return nodes;
	}

	private static Node getNodeBySeq(List<Node> nodes, int seq) {
		return nodes.get(seq - 1);
	}

	private static int findPathUsingDijkstra(List<Node> nodes, int src, int dest) {
		Node srcNode = getNodeBySeq(nodes, src);
		srcNode.penalty = 0;

		Node destNode = getNodeBySeq(nodes, dest);

		Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getPenalty));

		queue.addAll(srcNode.edgeList);

		while (!queue.isEmpty()) {
			Edge currentEdge = queue.remove();
			if (currentEdge.toNode.penalty != -1) {
				continue;
			}

			currentEdge.toNode.penalty = currentEdge.getPenalty();
			if (currentEdge.toNode == destNode) {
				return currentEdge.toNode.penalty;
			}
			queue.addAll(currentEdge.toNode.edgeList);
		}

		return -1;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();

		int m = scanner.nextInt();

		int[][] edges = new int[m][3];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 3; j++) {
				edges[i][j] = scanner.nextInt();
			}
		}

		int A = scanner.nextInt();

		int B = scanner.nextInt();

		int result = beautifulPath(n, edges, A, B);

		System.out.println(result);

		scanner.close();
	}
}
