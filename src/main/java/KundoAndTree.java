import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KundoAndTree {
	private static final long MOD = 1000000007;

	private static class DisjointSet {
		DisjointSet parent = this;
		int size = 1;

		public void union(DisjointSet other) {
			if (this == other) {
				return;
			}

			DisjointSet root = findRoot();
			DisjointSet otherRoot = other.findRoot();

			if (root == otherRoot) {
				return;
			}

			if (root.size >= otherRoot.size) {
				otherRoot.parent = root;
				root.size += otherRoot.size;
			} else {
				root.parent = otherRoot;
				otherRoot.size += root.size;
			}
		}

		private DisjointSet findRoot() {
			if (parent != this) {
				parent = parent.findRoot();
			}

			return parent;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// nodes
		int n = scanner.nextInt();
		// each distinct nodes
		DisjointSet[] components = new DisjointSet[n + 1];

		// edge == nodes - 1
		for (int i = 0; i < n - 1; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			char color = scanner.next().charAt(0);

			if (color == 'r') {
				continue;
			}

			DisjointSet aComponent = createComponentIfNeeded(components, a);
			DisjointSet bComponent = createComponentIfNeeded(components, b);

			aComponent.union(bComponent);
		}

		Set<DisjointSet> uniqueComponents = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			DisjointSet component = components[i];

			if (component != null) {
				uniqueComponents.add(component.findRoot());
			}
		}

		long allPossibleTriplets = chooseThreeFrom(n);

		for (DisjointSet component : uniqueComponents) {
			allPossibleTriplets -= chooseThreeFrom(component.size);
			allPossibleTriplets -= chooseTwoFrom(component.size) * chooseOneFrom(n - component.size);
		}

		System.out.println(allPossibleTriplets % MOD);
	}

	private static long chooseNFromK(int n, int k) {
		if (n < k) {
			return 0;
		}

		long res = 1;
		for (int i = n; i > (n - k); i--) {
			res *= i;
		}

		for (int i = 1; i <= k; i++) {
			res /= i;
		}
		return res;
	}

	private static long chooseOneFrom(int size) {
		return chooseNFromK(size, 1);
	}

	private static long chooseTwoFrom(int size) {
		return chooseNFromK(size, 2);
	}

	private static long chooseThreeFrom(int size) {
		return chooseNFromK(size, 3);
	}

	private static DisjointSet createComponentIfNeeded(DisjointSet[] components, int c) {
		if (components[c] == null) {
			components[c] = new DisjointSet();
		}

		return components[c];
	}

}
