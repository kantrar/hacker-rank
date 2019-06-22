public class MaximalRectangle3 {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int[][] left = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == '0') {
					left[i][j] = 0;
				} else {
					if (j > 0) {
						left[i][j] = left[i][j - 1] + 1;
					} else {
						left[i][j] = matrix[i][j] - '0';
					}
				}
			}
		}

		int[][] dp = new int[matrix.length][matrix[0].length];
		int maxArea = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == '0') {
					dp[i][j] = 0;
				} else {
					int width = left[i][j];
					int height = 1;
					maxArea = Math.max(maxArea, width * height);
					for (int k = i - 1; k >= 0; k--) {
						width = Math.min(width, left[k][j]);
						height = i - k + 1;
						dp[i][j] = Math.max(dp[i][j], width * height);
					}
				}

				maxArea = Math.max(maxArea, dp[i][j]);
			}
		}

		return maxArea;
	}
}
