package AlgoExpert;

public class BSTConstruction {
	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}

		public BST insert(int value) {
			BST parent = findInsertion(this, value);
			BST bst = new BST(value);
			if (value < parent.value) {
				parent.left = bst;
			} else {
				parent.right = bst;
			}
			return this;
		}

		private BST findInsertion(BST root, int value) {
			BST current = root;
			BST prev = null;
			while (current != null) {
				prev = current;
				if (current.value <= value) {
					current = current.right;
				} else {
					current = current.left;
				}
			}
			return prev;
		}

		private BST[] findWithParent(BST root, int value) {
			BST current = root;
			BST prev = null;
			while (current != null) {
				if (current.value == value) {
					return new BST[] {current, prev};
				} else if (current.value > value) {
					prev = current;
					current = current.left;
				} else {
					prev = current;
					current = current.right;
				}
			}
			return new BST[] {null, prev};
		}

		public boolean contains(int value) {
			BST[] res = findWithParent(this, value);
			return res[0] != null;
		}

		public BST remove(int value) {
			BST[] res = findWithParent(this, value);
			BST target = res[0];
			if (target != null) {
				if (target.left != null && target.right != null) {
					BST smallest = findSmallest(target.right);
					int temp = target.value;
					target.value = smallest.value;
					smallest.value = temp;
					remove(temp);
				} else if (target.left != null) {
					if (res[1] == null)
					if (res[1].value >= value) {
						res[1].left = target.left;
					} else {
						res[1].right = target.left;
					}
				} else if (target.right != null) {
					if (res[1].value >= value) {
						res[1].left = target.right;
					} else {
						res[1].right = target.right;
					}
				} else {
					if (res[1].value >= value) {
						res[1].left = null;
					} else {
						res[1].right = null;
					}
				}
			}

			return this;
		}

		private BST findSmallest(BST tree) {
			if (tree.left != null) {
				return findSmallest(tree.left);
			}
			return tree;
		}
	}
}
