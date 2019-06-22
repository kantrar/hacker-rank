public class SpiralMatrixIII {
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int[][] moves = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

		int[][] answers = new int[R * C][2];

		int d = 0;
		int change = 1;
		int count = 0;

		int pos = 0;

		int i = 0;

		while (i < R * C) {
			if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
				answers[i][0] = r0;
				answers[i++][1] = c0;
			}

			r0 += moves[pos][0];
			c0 += moves[pos][1];

			d++;
			if (d == change) {
				count++;
				d = 0;
				pos = (pos + 1) % moves.length;
				if (count % 2 == 0) {
					change++;
				}

			}
		}

		return answers;
	}
}
