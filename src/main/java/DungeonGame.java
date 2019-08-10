import java.util.Arrays;

public class DungeonGame {
	private static int[][] moves = new int[][] {{0, 1}, {1, 0}};

	public int calculateMinimumHP2(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
			return 0;
		}

		Integer[][] memo = new Integer[dungeon.length][dungeon[0].length];
		int res = dfs(dungeon, 0, 0, memo);

		return res >= 0 ? 1 : Math.abs(res) + 1;
	}

	public int dfs(int[][] input, int row, int col, Integer[][] memo) {
		if (memo[row][col] != null) {
			return memo[row][col];
		}

		Integer prev = null;
		for (int[] move : moves) {
			int nr = row + move[0];
			int nc = col + move[1];

			if (isValid(input, nr, nc)) {
				int res = dfs(input, nr, nc, memo);

				if (prev == null || res > prev) {
					prev = res;
				}
			}
		}

		if (prev == null) {
			prev = 0;
		}

		int res = prev + input[row][col];
		res = res > 0 ? 0 : res;

		memo[row][col] = res;
		return res;
	}

	public boolean isValid(int[][] input, int r, int c) {
		return r < input.length && c < input[0].length;
	}

	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
			return 0;
		}

		int M = dungeon.length;
		int N = dungeon[0].length;
		int[] hp = new int[N + 1];

		Arrays.fill(hp, Integer.MAX_VALUE);
		hp[N] = Integer.MAX_VALUE;
		hp[N - 1] = 1;

		for (int i = M - 1; i >= 0; i--) {
			for (int j = N - 1; j >= 0; j--) {
				int requiredHp = Math.min(hp[j], hp[j + 1]);
				hp[j] = Math.max(1, requiredHp - dungeon[i][j]);
			}
		}

		return hp[0];
	}
}
