import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int M = grid.length;
		int N = grid[0].length;

		int[] parent = new int[M * N];
		Arrays.fill(parent, -1);

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == '0') {
					continue;
				}
				parent[i * N + j] = i * N + j;
				if (i > 0 && grid[i - 1][j] == '1') {
					union(parent, (i - 1) * N + j, i * N + j);
				}
				if (j > 0 && grid[i][j - 1] == '1') {
					union(parent, i * N + j - 1, i * N + j);
				}
			}
		}

		Set<Integer> parentSet = new HashSet<>();
		for (int p : parent) {
			if (p != -1) {
				parentSet.add(find(parent, p));
			}
		}
		return parentSet.size();
	}

	private void union(int[] parent, int prev, int cur) {
		int p1 = find(parent, prev);
		int p2 = find(parent, cur);
		parent[p1] = p2;
	}

	private int find(int[] parent, int cur) {
		if (parent[cur] != cur) {
			parent[cur] = find(parent, parent[cur]);
		}
		return parent[cur];
	}
}
