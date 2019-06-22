public class MaximalRectangle2 {

	// Accepted but too slow
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int[][] sum = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				sum[i][j] += matrix[i][j] - '0';
				if (i > 0) {
					sum[i][j] += sum[i - 1][j];
				}

				if (j > 0) {
					sum[i][j] += sum[i][j - 1];
				}

				if (i > 0 && j > 0) {
					sum[i][j] -= sum[i - 1][j - 1];
				}
			}
		}

		int maxArea = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				for (int m = i; m < matrix.length; m++) {
					for (int n = j; n < matrix[m].length; n++) {
						int totalSum = sum[m][n];
						if (i > 0) {
							totalSum -= sum[i - 1][n];
						}
						if (j > 0) {
							totalSum -= sum[m][j - 1];
						}

						if (i > 0 && j > 0) {
							totalSum += sum[i - 1][j - 1];
						}

						if (totalSum == (m - i + 1) * (n - j + 1)) {
							maxArea = Math.max(maxArea, totalSum);
						}
					}
				}
			}
		}

		return maxArea;
	}
}
