public class LowestCommonAncestor {

	public class Node {
		int value;
		Node left;
		Node right;
	}

	public static Node lowestCommonAncestor(Node root, int v1, int v2) {
		// To ensure that v1 is always less than v2
		if (v1 > v2) {
			int temp = v2;
			v2 = v1;
			v1 = temp;
		}

		if (root.value > v1 && root.value < v2) {
			return root;
		}

		if (root.value == v1) {
			return root;
		}

		if (root.value == v2) {
			return root;
		}

		if (root.value > v1 && root.value > v2) {
			return lowestCommonAncestor(root.left, v1, v2);
		} else if (root.value < v1 && root.value < v2) {
			return lowestCommonAncestor(root.right, v1, v2);
		}

		return null;
	}

	public static Node lca(Node root, int v1, int v2) {
		if (root.value > v1 && root.value > v2) {
			return lca(root.right, v1, v2);
		}

		if (root.value < v1 && root.value < v2) {
			return lca(root.left, v1, v2);
		}

		return root;
	}

}

