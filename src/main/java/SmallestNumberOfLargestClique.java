// Incomplete
public class SmallestNumberOfLargestClique {
	public static int clique(int n, int m) {
		// Write your code here
		if (n <= 1) {
			return 1;
		}
		if (n == 2 && m >= 1) {
			return 2;
		}

		if (m <= n - 1) {
			return 2;
		}

		int maxClique = 3;

		int left = 3;
		int right = n;

		while (left  <= right) {
			int clique = (left + right) / 2;
			int edge = turanFunction(n, clique);

			if (edge < m) {
				if (maxClique < clique) {
					maxClique = clique;
				}
				left = clique + 1;
			} else if (edge > m) {
				right = clique - 1;
			} else {
				return clique;
			}
		}

		return maxClique;
	}

	private static int turanFunction(int n, int clique) {
		return ((clique - 2) * n * n) / (2 * (clique - 1));
	}
}

