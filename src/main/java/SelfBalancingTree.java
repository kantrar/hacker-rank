/**
 * AVL Tree
 */
public class SelfBalancingTree {
	private static class Node {
		private Node left;
		private Node right;
		private int val;
		private int ht;

		public Node() {
		}
	}

	static Node insert(Node root, int val) {
		if (root == null) {
			Node node = new Node();
			node.val = val;
			node.ht = 0;
			return node;
		}

		if (root.val > val) {
			Node newNode = insert(root.left, val);
			root.left = newNode;
		} else if (root.val < val) {
			Node newNode = insert(root.right, val);
			root.right = newNode;
		}

		setHeight(root);
		return balanceTree(root);
	}

	private static void setHeight(Node root) {
		if (root == null) {
			return;
		}

		root.ht = 1 + Math.max(height(root.left), height(root.right));
	}

	private static int height(Node root) {
		return root == null ? -1 : root.ht;
	}

	private static int balanceFactor(Node root) {
		if (root == null) {
			return 0;
		}

		return height(root.left) - height(root.right);
	}

	private static Node balanceTree(Node root) {
		int bf = balanceFactor(root);

		if (bf > 1) {
			int leftHeight = height(root.left.left);
			int rightHeight = height(root.left.right);

			if (leftHeight > rightHeight) {
				// left-left
				return rightRotate(root);
			} else if (leftHeight < rightHeight) {
				// left-right
				Node newChild = leftRotate(root.left);
				root.left = newChild;

				// setHeight(root); // not necessary as root's height is the same
				return rightRotate(root);
			}
		} else if (bf < -1) {
			int leftHeight = height(root.right.left);
			int rightHeight = height(root.right.right);

			if (leftHeight > rightHeight) {
				// right-left
				Node newChild = rightRotate(root.right);
				root.right = newChild;

				// setHeight(root); // not necessary as root's height is the same
				return leftRotate(root);
			} else if (leftHeight < rightHeight) {
				// right-right
				return leftRotate(root);
			}
		}

		return root;
	}

	private static Node rightRotate(Node root) {
		Node newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;

		setHeight(root);
		setHeight(newRoot);

		return newRoot;
	}

	private static Node leftRotate(Node root) {
		Node newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;

		setHeight(root);
		setHeight(newRoot);

		return newRoot;
	}
}
