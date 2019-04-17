import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
	public class Point {
		int row;
		int col;

		public Point(int r, int c) {
			this.row = r;
			this.col = c;
		}
	}

	public List<int[]> pacificAtlantic(int[][] matrix) {
		if (matrix.length == 0) {
			return new ArrayList<>();
		}

		List<int[]> answer = new ArrayList<>();
		int[][] reachPacific = new int[matrix.length][matrix[0].length];
		int[][] reachAtlantic = new int[matrix.length][matrix[0].length];
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				canReach(matrix, new Point(i, j), reachPacific, reachAtlantic, visited);
				if (reachPacific[i][j] == 1 && reachAtlantic[i][j] == 1) {
					answer.add(new int[] {i, j});
				}
			}
		}

		return answer;
	}

	public void canReach(int[][] matrix, Point current, int[][] reachPacific, int[][] reachAtlantic, boolean[][] visited) {
		visited[current.row][current.col] = true;

		int[] drow = new int[] {0, 0, -1, 1};
		int[] dcol = new int[] {-1, 1, 0, 0};

		for (int i = 0; i < 4; i++) {
			int newRow = current.row + drow[i];
			int newCol = current.col + dcol[i];

			if (newRow < 0 || newCol < 0) {
				reachPacific[current.row][current.col] = 1;
			} else if (newRow >= matrix.length || newCol >= matrix[0].length) {
				reachAtlantic[current.row][current.col] = 1;
			} else if (matrix[current.row][current.col] >= matrix[newRow][newCol]) {
				if (!visited[newRow][newCol]) {
					canReach(matrix, new Point(newRow, newCol), reachPacific, reachAtlantic, visited);
				}

				if (reachPacific[newRow][newCol] == 1) {
					reachPacific[current.row][current.col] = 1;
				}

				if (reachAtlantic[newRow][newCol] == 1) {
					reachAtlantic[current.row][current.col] = 1;
				}
			}
		}
	}
}
