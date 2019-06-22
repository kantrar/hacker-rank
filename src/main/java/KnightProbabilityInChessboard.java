import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KnightProbabilityInChessboard {
	int[] dr = {1, 1, 2, 2, -1, -1, -2, -2};
	int[] dc = {-2, 2, -1, 1, -2, 2, -1, 1};

	public double knightProbability(int size, int moves, int row, int col) {
		double[][][] dp = new double[size][size][moves + 1];

		int off;

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row, col});

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				off = 0;
				for (int k = 0; k < dr.length; k++) {
					int newRow = i + dr[k];
					int newCol = j + dc[k];

					if (newRow < 0 || newRow >= size || newCol < 0 || newCol >= size) {
						off++;
					}
				}

				Arrays.fill(dp[i][j], -1);
				dp[i][j][0] = 0.0;
				dp[i][j][1] = (8.0 - off) / 8.0;
			}
		}

		return dfs(size, row, col, dp, moves);
	}

	public double dfs(int size, int row, int col, double[][][] dp, int moves) {
		if (dp[row][col][moves] != -1) {
			return dp[row][col][moves];
		}

		double prob = 0.0;
		for (int k = 0; k < dr.length; k++) {
			int newRow = row + dr[k];
			int newCol = col + dc[k];

			if (newRow < 0 || newRow >= size || newCol < 0 || newCol >= size) {
				continue;
			}

			prob += dfs(size, newRow, newCol, dp, moves - 1) / 8.0;
		}

		dp[row][col][moves] = prob;

		return prob;
	}
}
