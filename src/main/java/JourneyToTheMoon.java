import java.util.HashMap;
import java.util.Map;

public class JourneyToTheMoon {
	private static class Subset {
		int parent;
		int rank;

		public Subset(int p) {
			this.parent = p;
		}

	}

	static long journeyToMoon(int n, int[][] astronaut) {
		Subset[] subsets = new Subset[n];
		for (int i = 0; i < n; i++) {
			subsets[i] = new Subset(i);
		}

		for (int i = 0; i < astronaut.length; i++) {
			int first = astronaut[i][0];
			int second = astronaut[i][1];

			int firstParent = findRoot(subsets, first);
			int secondParent = findRoot(subsets, second);

			union(subsets, firstParent, secondParent);
		}

		Map<Integer, Integer> map = new HashMap<>();
		int total = n;
		for (int i = 0; i < n; i++) {
			int root = findRoot(subsets, i);
			int current = map.getOrDefault(root, 0);
			map.put(root, current + 1);
		}

		long answer = 0;
		for (Integer key : map.keySet()) {
			int oneCountry = map.get(key);
			total -= oneCountry;
			answer += oneCountry * total;
		}

		return answer;
	}

	private static int findRoot(Subset[] subsets, int value) {
		if (subsets[value].parent != value) {
			subsets[value].parent = findRoot(subsets, subsets[value].parent);
		}
		return subsets[value].parent;
	}

	private static void union(Subset[] subsets, int x, int y) {
		if (x == y) {
			return;
		}

		if (subsets[x].rank < subsets[y].rank) {
			subsets[x].parent = y;
		} else if (subsets[x].rank > subsets[y].rank) {
			subsets[y].parent = x;
		} else {
			subsets[y].parent = x;
			subsets[x].rank++;
		}
	}
}
