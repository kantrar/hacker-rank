import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SwapNode {

	private static class Node {
		int seq;

		int level;

		Node left;

		Node right;

		public Node(int s) {
			this.seq = s;
		}
	}

	static int[][] swapNodes(int[][] indexes, int[] queries) {
		int[][] answers = new int[queries.length][indexes.length + 1];

		Node root = getRootNode(indexes);

		executeQueriesAndOrder(root, queries, answers);

		return answers;
	}

	private static Node getRootNode(int[][] indexes) {
		List<Node> nodes = new ArrayList<>();

		for (int i = 0; i < indexes.length; i++) {
			Node node = new Node(i + 1);
			nodes.add(node);
		}

		nodes.get(0).level = 1;

		for (int i = 0; i < indexes.length; i++) {
			Node currentNode = nodes.get(i);

			if (indexes[i][0] != -1) {
				currentNode.left = nodes.get(indexes[i][0] - 1);
				currentNode.left.level = currentNode.level + 1;
			} else {
				currentNode.left = null;
			}

			if (indexes[i][1] != -1) {
				currentNode.right = nodes.get(indexes[i][1] - 1);
				currentNode.right.level = currentNode.level + 1;
			} else {
				currentNode.right = null;
			}
		}

		return nodes.get(0);
	}

	private static void executeQueriesAndOrder(Node root, int[] queries, int[][] answers) {
		for (int i = 0; i < queries.length; i++) {
			executeSwap(root, queries[i]);

			traverse(root, answers[i], 0);
		}
	}

	private static void executeSwap(Node root, int query) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node currentNode = queue.remove();

			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}

			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}

			if (currentNode.level % query == 0) {
				Node temp = currentNode.left;
				currentNode.left = currentNode.right;
				currentNode.right = temp;
			}

		}
	}

	private static int traverse(Node root, int[] answer, int position) {
		if (root == null) {
			return position;
		}

		position = traverse(root.left, answer, position);
		answer[position++] = root.seq;
		return traverse(root.right, answer, position);


	}
}