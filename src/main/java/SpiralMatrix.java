import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		int maxRow = matrix.length;
		if (maxRow == 0) {
			return new ArrayList<>();
		}
		int maxCol = matrix[0].length;

		boolean[][] visited = new boolean[maxRow][maxCol];

		List<Integer> answers = new ArrayList<>();

		DFSUtil(matrix, answers, visited, 0, 0, 1);

		return answers;
	}

	public void DFSUtil(int[][] matrix, List<Integer> answers, boolean[][] visited, int row, int col, int direction) {
		answers.add(matrix[row][col]);
		visited[row][col] = true;

		if (direction == 1) {
			// right
			validateAndCallDFSUtil(matrix, answers, visited, row, col + 1, 1);

			// down
			validateAndCallDFSUtil(matrix, answers, visited, row + 1, col, 2);

			// left
			validateAndCallDFSUtil(matrix, answers, visited, row, col - 1, 3);

			// up
			validateAndCallDFSUtil(matrix, answers, visited, row - 1, col, 4);
		} else if (direction == 2) {
			// down
			validateAndCallDFSUtil(matrix, answers, visited, row + 1, col, 2);

			// left
			validateAndCallDFSUtil(matrix, answers, visited, row, col - 1, 3);

			// up
			validateAndCallDFSUtil(matrix, answers, visited, row - 1, col, 4);

			// right
			validateAndCallDFSUtil(matrix, answers, visited, row, col + 1, 1);
		} else if (direction == 3) {
			// left
			validateAndCallDFSUtil(matrix, answers, visited, row, col - 1, 3);

			// up
			validateAndCallDFSUtil(matrix, answers, visited, row - 1, col, 4);

			// right
			validateAndCallDFSUtil(matrix, answers, visited, row, col + 1, 1);

			// down
			validateAndCallDFSUtil(matrix, answers, visited, row + 1, col, 2);
		} else {
			// up
			validateAndCallDFSUtil(matrix, answers, visited, row - 1, col, 4);

			// right
			validateAndCallDFSUtil(matrix, answers, visited, row, col + 1, 1);

			// down
			validateAndCallDFSUtil(matrix, answers, visited, row + 1, col, 2);

			// left
			validateAndCallDFSUtil(matrix, answers, visited, row, col - 1, 3);
		}

	}

	public void validateAndCallDFSUtil(int[][] matrix, List<Integer> answers, boolean[][] visited, int row, int col,
			int direction) {
		if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
			if (!visited[row][col]) {
				DFSUtil(matrix, answers, visited, row, col, direction);
			}
		}
	}

	public List<Integer> getSpiralMatrix(int[][] input) {
		if (input == null || input.length == 0) {
			return new ArrayList<>();
		}

		List<Integer> answers = new ArrayList<>();
		int[] dr = new int[] {0, 1, 0, -1};
		int[] dc = new int[] {1, 0, -1, 0};
		int di = 0;

		boolean[][] seen = new boolean[input.length][input[0].length];
		int i = 0;
		int j = 0;

		while (i >= 0 && i < input.length && j >= 0 && j < input[0].length && !seen[i][j]) {
			seen[i][j] = true;
			answers.add(input[i][j]);

			int nr = i + dr[di];
			int nc = j + dc[di];

			if (nr < 0 || nr >= input.length || nc < 0 || nc >= input[i].length || seen[nr][nc]) {
				di = (di + 1) % 4;
				i = i + dr[di];
				j = j + dc[di];
			} else {
				i = nr;
				j = nc;
			}
		}

		return answers;
	}

	public static void main(String[] args) {
		SpiralMatrix m = new SpiralMatrix();
		List<Integer> answers = m.getSpiralMatrix(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
		System.out.println(answers);
	}
}
