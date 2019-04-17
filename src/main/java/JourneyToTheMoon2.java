public class JourneyToTheMoon2 {
	public static class Subset {
		int parent;
		int rank;
		long children;

		public Subset(int p) {
			this.parent = p;
			this.children = 1;
		}
	}

	static long journeyToMoon(int noNodes, int[][] astronaut) {
		Subset[] subsets = new Subset[noNodes];

		for (int i = 0; i < noNodes; i++) {
			subsets[i] = new Subset(i);
		}

		return readAstronauts(astronaut, subsets);
	}

	static long readAstronauts(int[][] astronaut, Subset[] subsets) {
		for (int i = 0; i < astronaut.length; i++) {
			int a = astronaut[i][0];
			int b = astronaut[i][1];

			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}

			int aRoot = findRoot(subsets, a);
			int bRoot = findRoot(subsets, b);

			union(subsets, aRoot, bRoot);
		}

		long answer = 0;
		for (int i = 0; i < subsets.length; i++) {
			answer += subsets[i].children * (subsets.length - subsets[i].children);
		}

		return answer / 2;
	}

	static int findRoot(Subset[] subsets, int s) {
		if (subsets[s].parent != s) {
			subsets[s].parent = findRoot(subsets, subsets[s].parent);
		}

		return subsets[s].parent;
	}

	static long union(Subset[] subsets, int a, int b) {
		if (subsets[a].rank < subsets[b].rank) {
			subsets[a].parent = b;
			subsets[b].children += subsets[a].children;
			subsets[a].children = 0;

			return subsets[b].children;
		} else if (subsets[a].rank > subsets[b].rank) {
			subsets[b].parent = a;
			subsets[a].children += subsets[b].children;
			subsets[b].children = 0;

			return subsets[a].children;
		} else {
			subsets[b].parent = a;
			subsets[a].rank++;
			subsets[a].children += subsets[b].children;
			subsets[b].children = 0;

			return subsets[a].children;
		}
	}
}
