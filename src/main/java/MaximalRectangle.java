import java.util.Arrays;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int maxArea = 0;

		int[] height = new int[matrix[0].length];

		int[] left = new int[matrix[0].length];

		int[] right = new int[matrix[0].length];
		Arrays.fill(right, matrix[0].length);


		// 1 1
		// height 1 1
		// left 0 0
		// right 2 2
		for (int i = 0; i < matrix.length; i++) {
		int currentLeft = 0;
			int currentRight = matrix[0].length;
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == '1') {
					height[j] = height[j] + 1;
				} else {
					height[j] = matrix[i][j] - '0';
				}

				if (matrix[i][j] == '1') {
					left[j] = Math.max(left[j], currentLeft);
				} else {
					left[j] = 0;
					currentLeft = j + 1;
				}
			}

			for (int j = matrix[i].length - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(right[j], currentRight);
				} else {
					right[j] = matrix[0].length;
					currentRight = j;
				}
			}

			for (int j = 0; j < matrix[i].length; j++) {
				maxArea = Math.max(maxArea, height[j] * (right[j] - left[j]));
			}
		}

		return maxArea;
	}
}