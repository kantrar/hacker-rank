import java.util.Arrays;

public class CherryPickup {
	public int cherryPickup(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int[][] dp = new int[grid.length][grid.length];
		for (int[] row : dp) {
			Arrays.fill(row, Integer.MIN_VALUE);
		}
		// don't forget place init the value
		dp[0][0] = 0;
		for (int t = 0; t < 2 * grid.length - 1; t++) {
			int[][] nextDp = new int[grid.length][grid.length];
			for (int[] row : nextDp) {
				Arrays.fill(row, Integer.MIN_VALUE);
			}

			// can reduce scope of r1 and r2
			for (int r1 = Math.max(0, t - grid.length + 1); r1 <= Math.min(grid.length - 1, t); r1++) {
				for (int r2 = Math.max(0, t - grid.length + 1); r2 <= Math.min(grid.length - 1, t); r2++) {
					if (grid[r1][t - r1] == -1 || grid[r2][t - r2] == -1) {
						continue;
					}
					// this is cool
					int cherry = grid[r1][t - r1];
					if (r1 != r2) {
						cherry += grid[r2][t - r2];
					}
					nextDp[r1][r2] += cherry;
					for (int p1 = r1 - 1; p1 <= r1; p1++) {
						for (int p2 = r2 - 1; p2 <= r2; p2++) {
							if (p1 >= 0 && p2 >= 0) {
								nextDp[r1][r2] = Math.max(nextDp[r1][r2], dp[p1][p2] + cherry);
							}
						}
					}
				}
			}
			dp = nextDp;
		}

		return Math.max(0, dp[grid.length - 1][grid.length - 1]);
	}
}
