import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestSubsequenceInMatrix {
	List<Integer> answers = new ArrayList<>();

	public List<Integer> longestSubsequence(int[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				Stack<Integer> ans = new Stack<>();
				ans.push(input[i][j]);
				boolean[][] visited = new boolean[input.length][input[0].length];
				getLongestSubsequence(input, new Position(i, j), visited, ans);
				if (ans.size() > answers.size()) {
					answers = ans;
				}
			}
		}

		return answers;
	}

	private void getLongestSubsequence(int[][] input, Position pos, boolean[][] visited, Stack<Integer> answers) {
		visited[pos.row][pos.col] = true;
		for (Position next : getNextPosition(input, pos)) {
			if (visited[next.row][next.col]) {
				continue;
			}

			if (input[pos.row][pos.col] < input[next.row][next.col]) {
				answers.push(input[next.row][next.col]);
				getLongestSubsequence(input, next, visited, answers);
				if (this.answers.size() < answers.size()) {
					this.answers = new ArrayList<>(answers);
				}
				answers.pop();
			}
		}

		visited[pos.row][pos.col] = false;
	}

	private List<Position> getNextPosition(int[][] input, Position position) {
		List<Position> answers = new ArrayList<>();
		for (int i = -1; i <= 1; i += 2) {
			int newRow = position.row + i;
			int newCol = position.col;
			if (validate(input, newRow, newCol)) {
				answers.add(new Position(newRow, newCol));
			}

			newRow = position.row;
			newCol = position.col + i;

			if (validate(input, newRow, newCol)) {
				answers.add(new Position(newRow, newCol));
			}
		}

		return answers;
	}

	private boolean validate(int[][] input, int row, int col) {
		return row >= 0 && row < input.length && col >= 0 && col < input[0].length;
	}

	private class Position {
		int row;
		int col;

		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
