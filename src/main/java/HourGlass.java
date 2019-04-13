public class HourGlass {
	static int hourglassSum(int[][] arr) {

		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sum += arr[i][j];
			}
		}

		sum -= (arr[1][0] + arr[1][2]);

		int initalSumForEachRow = sum;
		int maxSum = sum;

		for (int i = 2; i < arr.length; i++) {
			if (i - 2 > 0) {
				for (int j = 0; j < 3; j++) {
					initalSumForEachRow += arr[i][j];
					initalSumForEachRow -= arr[i - 3][j];
				}

				initalSumForEachRow -= (arr[i - 1][0] + arr[i - 1][2]);
				initalSumForEachRow += (arr[i - 2][0] + arr[i - 2][2]);
			}

			sum = initalSumForEachRow;

			for (int j = 2; j < arr[i].length; j++) {
				if (j == 2) {
					maxSum = Math.max(maxSum, sum);
					continue;
				}
				sum += (arr[i][j] + arr[i - 2][j] + arr[i - 1][j - 1]);

				if (j - 1 > 0) {
					sum -= arr[i - 1][j - 2];
				}
				if (j - 2 > 0) {
					sum -= (arr[i - 2][j - 3] + arr[i][j - 3]);
				}

				maxSum = Math.max(maxSum, sum);
			}
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int result = HourGlass.hourglassSum(
				new int[][] {
						{1, 1, 1, 0, 0, 0},
						{0, 1, 0, 0, 0, 0},
						{1, 1, 1, 0, 0, 0},
						{0, 9, 2, -4, -4, 0},
						{0, 0, 0, -2, 0, 0},
						{0, 0, -1, -2, -4, 0}});
		System.out.println(result);
	}
}
