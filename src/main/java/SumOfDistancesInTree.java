import java.util.ArrayList;
import java.util.List;

public class SumOfDistancesInTree {
	public int[] sumOfDistancesInTree(int N, int[][] input) {
		if (input == null || input.length == 0) {
			return new int[N];
		}
		List<Integer>[] edges = new List[N];
		for (int i = 0; i < N; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int[] e : input) {
			edges[e[0]].add(e[1]);
			edges[e[1]].add(e[0]);
		}

		int[][] dp = new int[N][2];
		boolean[] visited = new boolean[N];
		calculateDistance(edges, 0, dp, visited);

		int[] ans = new int[N];
		ans[0] = dp[0][0]; // root

		calculateSumDistance(edges, 0, -1, dp, ans);

		return ans;
	}

	private void calculateSumDistance(List<Integer>[] edges, int current, int parent, int[][] dp, int[] ans) {
		for (int next : edges[current]) {
			if (next == parent) {
				continue;
			}
			ans[next] = ans[current] + dp.length - 2 * dp[next][1];
			calculateSumDistance(edges, next, current, dp, ans);
		}
	}

	private int[] calculateDistance(List<Integer>[] edges, int current, int[][] dp, boolean[] visited) {
		if (visited[current]) {
			return new int[] {0, 0};
		}
		visited[current] = true;
		int distance = 0;
		int nodes = 1; // itself
		for (int next : edges[current]) {
			int[] result = calculateDistance(edges, next, dp, visited);
			distance += result[0] + result[1];
			nodes += result[1];
		}
		dp[current] = new int[] {distance, nodes};
		return dp[current];
	}
}
