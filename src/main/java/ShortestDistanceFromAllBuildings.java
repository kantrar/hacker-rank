import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestDistanceFromAllBuildings {
	public class Point {
		int row;
		int col;

		public Point(int r, int c) {
			this.row = r;
			this.col = c;
		}
	}

	public int shortestDistance(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		boolean canBuild = false;
		int[][][][] distances = new int[grid.length][grid[0].length][grid.length][grid[0].length];
		int[][] totalDistance = new int[grid.length][grid[0].length];

		Set<Point> buildingSet = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					buildingSet.add(new Point(i, j));
				}
			}
		}

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0 && !visited[i][j]) {
					canBuild = true;
					updateDistance(distances, totalDistance, grid, new Point(i, j), visited, buildingSet);
				}
			}
		}

		if (buildingSet.isEmpty() && canBuild) {
			return 0;
		}

		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (totalDistance[i][j] > 0) {
					minDistance = Math.min(minDistance, totalDistance[i][j]);
				}
			}
		}

		return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
	}

	private void updateDistance(int[][][][] distances, int[][] totalDistance, int[][] grid, Point point, boolean[][] visited,
			Set<Point> buildingSet) {
		visited[point.row][point.col] = true;
		Queue<Point> queue = new LinkedList<>();
		for (Point next : getNextPoints(grid, point)) {
			if (visited[next.row][next.col]) {
				copyDistance(distances, point, next, buildingSet);
				continue;
			}
			if (grid[next.row][next.col] == 1) {
				distances[point.row][point.col][next.row][next.col] = 1;
			} else {
				queue.offer(next);
			}
		}

		for (Point p : queue) {
			updateDistance(distances, totalDistance, grid, p, visited, buildingSet);
			copyDistance(distances, point, p, buildingSet);
		}

		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1 && distances[point.row][point.col][i][j] != 0) {
					count++;
					totalDistance[point.row][point.col] += distances[point.row][point.col][i][j];
				}
			}
		}

		if (count != buildingSet.size()) {
			totalDistance[point.row][point.col] = -1;
		}
	}

	private void copyDistance(int[][][][] distances, Point current, Point next, Set<Point> buildingSet) {
		for (Point building : buildingSet) {
			int row = building.row;
			int col = building.col;
			if (current.row == row && current.col == col) {
				distances[row][col][row][col] = 0;
			} else if (distances[next.row][next.col][row][col] > 0 && (distances[current.row][current.col][row][col] == 0
					|| distances[current.row][current.col][row][col] > distances[next.row][next.col][row][col] + 1)) {
				distances[current.row][current.col][row][col] = distances[next.row][next.col][row][col] + 1;
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
