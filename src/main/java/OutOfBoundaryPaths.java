public class OutOfBoundaryPaths {
	private static int[][] directions = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

	public int findPaths(int maxRow, int maxCol, int moves, int row, int col) {

		int[][] dp = new int[maxRow][maxCol];
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxCol; j++) {
				for (int k = 0; k < directions.length; k++) {
					int newRow = i + directions[k][0];
					int newCol = j + directions[k][1];

					if (newRow < 0 || newRow >= maxRow || newCol < 0 || newCol >= maxCol) {
						dp[i][j]++;
					}
				}
			}
		}

		for (int m = 1; m < moves; m++) {
			int[][] newdp = new int[maxRow][maxCol];
			for (int i = 0; i < maxRow; i++) {
				for (int j = 0; j < maxCol; j++) {
					for (int k = 0; k < directions.length; k++) {
						int newRow = i + directions[k][0];
						int newCol = j + directions[k][1];

						if (newRow < 0 || newRow >= maxRow || newCol < 0 || newCol >= maxCol) {
							newdp[i][j]++;
						} else {
							newdp[i][j] += dp[newRow][newCol];
						}
					}

				}
			}
			dp = newdp;
		}

		return dp[row][col];
	}
}
