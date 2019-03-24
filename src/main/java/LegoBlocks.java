public class LegoBlocks {
	private static final int MOD = 1000000000;

	static long legoBlocks(int height, int width) {
		boolean[][] grids = new boolean[height][width];
		int[] breaks = new int[width];

		int possibilities = placeBlocks(grids, 0, 0, breaks);
		long answer = 1L;
		int row = height;
		while (row > 0) {
			answer *= possibilities;
			answer = answer % MOD;
			row--;
		}

		for (int i = 1; i < width; i++) {
			answer -= Math.pow(breaks[i], height);
			for (int j = 1; j < width; j++) {
				if (i != j) {
					answer += Math.pow(breaks[i] + breaks[j], height);
				}
			}
		}

		answer += 1;
		return answer;
	}

	private static int placeBlocks(boolean[][] grids, int currentRow, int currentCol, int[] breaks) {
		if (currentCol == grids[0].length) {
			return 1;
		} else if (currentCol > grids[0].length) {
			return 0;
		}

		int possibilities = 0;

		possibilities += placeBlocks(grids, currentRow, currentCol + 1, breaks);
		possibilities += placeBlocks(grids, currentRow, currentCol + 2, breaks);
		possibilities += placeBlocks(grids, currentRow, currentCol + 3, breaks);
		possibilities += placeBlocks(grids, currentRow, currentCol + 4, breaks);

		if (currentCol > 0) {
			breaks[currentCol] += possibilities;
		}

		return possibilities;
	}

}
