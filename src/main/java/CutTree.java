import java.util.ArrayList;
import java.util.List;

// Editorial Solution
// Should implement it again, incomplete
public class CutTree {
	private static class Node {
		int id;
		List<Edge> edges = new ArrayList<>();
		List<Node> children = new ArrayList<>();

		public Node(int id) {
			this.id = id;
		}
	}

	private static class Edge {
		int from;
		int to;

		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}

	static long cuttree(int n, int k, int[][] edges) {
		List<Node> nodeList = new ArrayList<>();
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			nodeList.add(new Node(i));
		}
		for (int i = 0; i < edges.length; i++) {
			int from = edges[i][0];
			int to = edges[i][1];

			Edge edge1 = new Edge(from, to);
			nodeList.get(from - 1).edges.add(edge1);

			Edge edge2 = new Edge(to, from);
			nodeList.get(to - 1).edges.add(edge2);
		}

		DFS(nodeList, 0, visited);

		long answer = 0;
		for (int noCut = 0; noCut <= k; noCut++) {
			answer += findCut(nodeList.get(0), nodeList.get(0).children.size(), noCut, 0);
			answer += findCut(nodeList.get(0), nodeList.get(0).children.size(), noCut, 1);
		}

		return answer;
	}

	private static long findCut(Node node, int children, int noCut, int choose) {
		if (noCut < 0) {
			return 0;
		}
		if (children == 0) {
			if (noCut == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		long answer = 0;
		if (choose == 0) {
			for (int i = 0; i < children; i++) {
				Node v = node.children.get(i);
				answer += findCut(v, v.children.size(), noCut, 0);
				answer += findCut(v, v.children.size(), noCut - 1, 1);
			}

			//			if (noCut == 0) {
			//				answer -= children - 1;
			//			}
		} else {
			Node lastChild = node.children.get(children - 1);
			answer += findCut(node, children - 1, noCut - 1, 1);
			for (int i = 0; i <= noCut; i++) {
				answer += findCut(node, children - 1, noCut - i, 1) * findCut(lastChild, lastChild.children.size(), i, 1);
			}
		}

		return answer;

	}

	private static void DFS(List<Node> nodeList, int pos, boolean[] visited) {
		visited[pos] = true;
		Node currentNode = nodeList.get(pos);
		for (Edge edge : currentNode.edges) {
			if (!visited[edge.to - 1]) {
				currentNode.children.add(nodeList.get(edge.to - 1));
				DFS(nodeList, edge.to - 1, visited);
			}
		}
	}
}
