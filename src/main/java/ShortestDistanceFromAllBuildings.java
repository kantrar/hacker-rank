import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Point startPoint = null;
		int distance = -2;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (canPassThrough(grid[i][j])) {
					startPoint = new Point(i, j);
					distance = findDistanceFromStart(grid, startPoint, visited);
					break;
				}
			}

			if (startPoint == null) {
				continue;
			} else if (distance == -1) {
				return -1;
			} else {
				break;
			}
		}

		if (startPoint == null) {
			return -1;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					return -1;
				}
			}
		}

		int[] left = new int[grid[0].length];
		int[] top = new int[grid.length];
		int sum = 0;

		for (int i = 0; i < grid.length; i++) {
			if (i > 0) {
				top[i] = top[i - 1];
			}
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2) {
					continue;
				}
				if (i == 0) {
					top[i] += grid[i][j];
				} else {
					top[i] += grid[i][j];
				}
				sum += grid[i][j];
			}
		}

		for (int j = 0; j < grid[0].length; j++) {
			if (j > 0) {
				left[j] = left[j - 1];
			}
			for (int i = 0; i < grid.length; i++) {
				if (grid[i][j] == 2) {
					continue;
				}
				if (j == 0) {
					left[j] += grid[i][j];
				} else {
					left[j] += grid[i][j];
				}
			}
		}

		visited = new boolean[grid.length][grid[0].length];

		startPoint.distance = distance;
		return movePoint(grid, startPoint, top, left, sum, visited, distance);
	}

	public int movePoint(int[][] grid, Point point, int[] top, int[] left, int sum, boolean[][] visited, int currentDistance) {
		int minDistance = currentDistance;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(point);
		visited[point.row][point.col] = true;

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			for (Point next : getNextPoint(grid, current)) {
				if (visited[next.row][next.col] || !canPassThrough(grid[next.row][next.col])) {
					continue;
				}

				visited[next.row][next.col] = true;

				int delta;
				if (moveLeft(current, next)) {
					delta = left[next.col] - (sum - left[next.col]);
				} else if (moveRight(current, next)) {
					delta = (sum - left[current.col]) - left[current.col];
				} else if (moveUp(current, next)) {
					delta = top[next.row] - (sum - top[next.row]);
				} else {
					delta = (sum - top[current.row]) - top[current.row];
				}

				next.distance = current.distance + delta;
				minDistance = Math.min(minDistance, next.distance);

				queue.offer(next);
			}
		}

		return minDistance;
	}

	public boolean moveLeft(Point p1, Point p2) {
		if (p1.row == p2.row && p1.col - 1 == p2.col) {
			return true;
		}

		return false;
	}

	public boolean moveRight(Point p1, Point p2) {
		if (p1.row == p2.row && p1.col + 1 == p2.col) {
			return true;
		}

		return false;
	}

	public boolean moveUp(Point p1, Point p2) {
		if (p1.row - 1 == p2.row && p1.col == p2.col) {
			return true;
		}

		return false;
	}

	public boolean moveDown(Point p1, Point p2) {
		if (p1.row + 1 == p2.row && p1.col == p2.col) {
			return true;
		}

		return false;
	}

	public int findDistanceFromStart(int[][] grid, Point point, boolean[][] visited) {
		int distance = 0;
		int totalDistance = 0;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(point);
		visited[point.row][point.col] = true;

		while (!queue.isEmpty()) {
			Queue<Point> nextQueue = new LinkedList<>();
			distance++;
			for (Point current : queue) {
				for (Point next : getNextPoint(grid, current)) {
					if (visited[next.row][next.col]) {
						continue;
					}

					visited[next.row][next.col] = true;

					if (grid[next.row][next.col] == 1) {
						totalDistance += distance;
					} else {
						nextQueue.offer(next);
					}
				}
			}
			queue = nextQueue;
		}

		return totalDistance;
	}

	public List<Point> getNextPoint(int[][] grid, Point point) {
		List<Point> answers = new ArrayList<>();
		for (int i = -1; i <= 1; i += 2) {
			int newRow = point.row + i;
			int newCol = point.col;

			if (validate(grid, newRow, newCol) && grid[newRow][newCol] != 2) {
				answers.add(new Point(newRow, newCol));
			}

			newRow = point.row;
			newCol = point.col + i;

			if (validate(grid, newRow, newCol) && grid[newRow][newCol] != 2) {
				answers.add(new Point(newRow, newCol));
			}
		}

		return answers;
	}

	private boolean canPassThrough(int value) {
		return value == 0;
	}

	public boolean validate(int[][] grid, int row, int col) {
		if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
			return true;
		}

		return false;
	}
}
