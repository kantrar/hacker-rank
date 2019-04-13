import java.util.ArrayList;
import java.util.List;

public class BricksFallingWhenHit {
	public int[] hitBricks(int[][] grid, int[][] hits) {
		int[] answers = new int[hits.length];
		for (int i = 0; i < hits.length; i++) {
			if (grid[hits[i][0]][hits[i][1]] == 0) {
				answers[i] = 0;
				continue;
			}
			boolean[][] visited = new boolean[grid.length][grid[0].length];
			int res = DFS(grid, hits[i], visited, true);
			answers[i] = res == -1 ? 0 : res - 1;
		}

		return answers;
	}

	public int DFS(int[][] grid, int[] hit, boolean[][] visited, boolean realHit) {
		int answer = 1;

		visited[hit[0]][hit[1]] = true;

		grid[hit[0]][hit[1]] = 0;

		for (int[] next : getNextPoint(grid, hit)) {
			if (visited[next[0]][next[1]]) {
				continue;
			}

			if (grid[next[0]][next[1]] == 0) {
				continue;
			} else if (connectToTopGrid(grid, next)) {
				if (realHit) {
					continue;
				}

				visited[hit[0]][hit[1]] = false;
				grid[hit[0]][hit[1]] = 1;

				return 0;
			} else {

				int res = DFS(grid, next, visited, false);
				if (res == 0 && !realHit && !isTopGrid(hit, next)) {
					grid[hit[0]][hit[1]] = 1;
					visited[hit[0]][hit[1]] = false;
					return 0;
				}
				answer += res;
			}
		}

		return answer;
	}

	public List<int[]> getNextPoint(int[][] grid, int[] pos) {
		List<int[]> answers = new ArrayList<>();

		for (int i = -1; i <= 1; i += 2) {
			int newCol = pos[1] + i;

			if (newCol < 0 || newCol >= grid[0].length) {
				continue;
			}

			answers.add(new int[] {pos[0], newCol});
		}

		// last row
		if (pos[0] == grid.length - 1) {
			return answers;
		}

		answers.add(new int[] {pos[0] + 1, pos[1]});
		return answers;
	}

	public boolean connectToTopGrid(int[][] grid, int[] pos) {
		if (pos[0] == 0) {
			return true;
		} else {
			return grid[pos[0] - 1][pos[1]] == 1;
		}
	}

	public boolean isTopGrid(int[] pos1, int[] pos2) {
		return pos1[0] == pos2[0] - 1;
	}

	public static void main(String[] args) {
		BricksFallingWhenHit bricksFallingWhenHit = new BricksFallingWhenHit();
		int[][] input = new int[][] {{0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 1, 0, 0, 1, 1, 1},
				{0, 0, 1, 1, 0, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1, 0}};
		int[][] hits = new int[][] {{1, 8}, {2, 1}, {1, 4}, {3, 0}, {3, 4}, {0, 7}, {1, 6}, {0, 8}, {2, 5}, {3, 2}, {2, 0},
				{0, 2}, {0, 5}, {0, 1}, {4, 8}, {3, 7}, {0, 6}, {5, 7}, {5, 3}, {2, 6}, {2, 2}, {5, 8}, {2, 8}, {4, 0}, {3, 3},
				{1, 1}, {0, 0}, {4, 7}, {0, 3}, {2, 4}, {3, 1}, {1, 0}, {5, 2}, {3, 8}, {4, 2}, {5, 0}, {1, 2}, {1, 7}, {3, 6},
				{4, 1}, {5, 6}, {0, 4}, {5, 5}, {5, 4}, {1, 5}, {4, 4}, {3, 5}, {4, 6}, {2, 3}, {2, 7}};
		int[] result = bricksFallingWhenHit.hitBricks(input, hits);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
