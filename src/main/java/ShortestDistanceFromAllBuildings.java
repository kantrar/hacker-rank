import java.util.LinkedList;
import java.util.List;

public class ShortestDistanceFromAllBuildings {
	public class Point {
		int row;
		int col;
		int distance;

		public Point(int r, int c) {
			this.row = r;
			this.col = c;
		}
	}

	public int shortestDistance(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int buildings = 0;
		boolean canBuild = false;
		int[][][][] distances = new int[grid.length][grid[0].length][grid.length][grid[0].length];
		int[][] totalDistance = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					buildings++;
				} else if (grid[i][j] == 0 && totalDistance[i][j] == 0) {
					canBuild = true;
					boolean[][] visited = new boolean[grid.length][grid[0].length];
					updateDistance(distances, totalDistance, grid, new Point(i, j), visited);
				}
			}
		}

		if (buildings == 0 && canBuild) {
			return 0;
		}

		int rowIdx = -1;
		int colIdx = -1;
		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (totalDistance[i][j] > 0) {
					rowIdx = i;
					colIdx = j;
					minDistance = Math.min(minDistance, totalDistance[i][j]);
				}
			}
		}

		System.out.println(rowIdx + "-" + colIdx);
		return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
	}

	private void updateDistance(int[][][][] distances, int[][] totalDistance, int[][] grid, Point point, boolean[][] visited) {
		visited[point.row][point.col] = true;
		for (Point next : getNextPoints(grid, point)) {
			if (visited[next.row][next.col]) {
				copyDistance(distances, grid, point, next);
				continue;
			}
			if (grid[next.row][next.col] == 1) {
				distances[point.row][point.col][next.row][next.col] = 1;
			} else {
				updateDistance(distances, totalDistance, grid, next, visited);
				copyDistance(distances, grid, point, next);
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1 && distances[point.row][point.col][i][j] == 0) {
					totalDistance[point.row][point.col] = -1;
					return;
				}
				if (grid[i][j] == 1) {
					totalDistance[point.row][point.col] += distances[point.row][point.col][i][j];
				}
			}
		}

	}

	private void copyDistance(int[][][][] distances, int[][] grid, Point current, Point next) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (current.row == i && current.col == j) {
					distances[i][j][i][j] = 0;
				} else if (distances[next.row][next.col][i][j] > 0 && (distances[current.row][current.col][i][j] == 0
						|| distances[current.row][current.col][i][j] > distances[next.row][next.col][i][j] + 1)) {
					distances[current.row][current.col][i][j] = distances[next.row][next.col][i][j] + 1;
				}
			}
		}
	}

	private List<Point> getNextPoints(int[][] grid, Point point) {
		List<Point> result = new LinkedList<>();
		for (int i = -1; i <= 1; i += 2) {
			int newRow = point.row + i;
			int newCol = point.col;
			if (canPass(grid, newRow, newCol)) {
				result.add(new Point(newRow, newCol));
			}

			newRow = point.row;
			newCol = point.col + i;
			if (canPass(grid, newRow, newCol)) {
				result.add(new Point(newRow, newCol));
			}
		}

		return result;
	}

	private boolean canPass(int[][] grid, int row, int col) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 2) {
			return false;
		}

		return true;
	}
}
