import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
	private int[][] moves = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

	public int maxDistance(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					visited[i][j] = true;
					queue.offer(new int[] {i, j, 0});
				}
			}
		}

		int distance = -1;
		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			for (int[] move : moves) {
				int nr = cell[0] + move[0];
				int nc = cell[1] + move[1];

				if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) {
					continue;
				}
				if (visited[nr][nc]) {
					continue;
				}

				if (grid[nr][nc] == 1) {
					continue;
				}

				visited[nr][nc] = true;

				queue.offer(new int[] {nr, nc, cell[2] + 1});
				distance = Math.max(distance, cell[2] + 1);
			}
		}

		return distance;
	}
}
