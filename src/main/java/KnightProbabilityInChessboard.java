public class KnightProbabilityInChessboard {
	int[][] moves = new int[][] {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};

	public double knightProbability(int N, int K, int r, int c) {
		double ans = 0;
		double[][] prob = new double[N][N];
		prob[r][c] = 1;
		for (int k = 1; k <= K; k++) {
			double[][] newProb = new double[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (prob[i][j] == 0) {
						continue;
					}
					for (int[] move : moves) {
						int nr = i + move[0], nc = j + move[1];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							newProb[nr][nc] += (prob[i][j] * 0.125);
						}
					}
				}
			}
			prob = newProb;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += prob[i][j];
			}
		}

		return ans;
	}
}
