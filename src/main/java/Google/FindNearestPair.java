package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindNearestPair {
	public static class Point {
		int row;
		int col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static int findNearestPair(int[][] input) {
		int minDistance = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[input.length][input[0].length];
		int[][] distances = new int[input.length][input[0].length];

		for (int i = 0; i < input.length; i++) {
			Arrays.fill(distances[i], -1);
		}

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				if (visited[i][j] || input[i][j] == 2) {
					continue;
				}

				if (input[i][j] == 1) {
					minDistance = Math.min(minDistance, findY(input, new Point(i, j), visited, distances));
				}
			}
		}

		return minDistance;
	}

	private static int findY(int[][] input, Point point, boolean[][] visited, int[][] distances) {
		if (input[point.row][point.col] == 2) {
			return 0;
		}

		if (distances[point.row][point.col] != -1) {
			return distances[point.row][point.col];
		}

		int nearestDistance = -1;
		visited[point.row][point.col] = true;

		for (Point next : getNextDirections(input, point)) {
			if (visited[next.row][next.col]) {
				continue;
			}

			int result = findY(input, next, visited, distances);

			if (result == -1) {
				continue;
			}

			if (nearestDistance == -1 || nearestDistance > result + 1) {
				nearestDistance = result + 1;
			}
		}

		distances[point.row][point.col] = nearestDistance;
		visited[point.row][point.col] = false;

		return nearestDistance;
	}

	// DFS fails in many cases
	// e.g.
	// XOOYO
	// OOOOX
	public static int findNearestPair2(int[][] input) {
		boolean foundXFirst = false;
		boolean foundYFirst = false;
		Point startingPoint = findStartingPoint(input);
		if (input[startingPoint.row][startingPoint.col] == 1) {
			foundXFirst = true;
		} else {
			foundYFirst = true;
		}

		int[][] distances = new int[input.length][input[0].length];
		boolean[][] visited = new boolean[input.length][input[0].length];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				distances[i][j] = -1;
				visited[i][j] = false;
			}
		}
		int minDistance = Integer.MAX_VALUE;
		distances[startingPoint.row][startingPoint.col] = 0;
		if (foundXFirst) {
			return DFS(input, startingPoint, startingPoint, null, visited, distances, 1, 2, minDistance);
		} else if (foundYFirst) {
			return DFS(input, startingPoint, startingPoint, null, visited, distances, 2, 1, minDistance);
		} else {
			return -1;
		}
	}

	private static int DFS(int[][] input, Point startingPoint, Point latestPoint, Point prevPoint, boolean[][] visited,
			int[][] distances, int source, int target, int minDistance) {

		System.out.println(startingPoint.row + " " + startingPoint.col);

		visited[startingPoint.row][startingPoint.col] = true;
		if (input[startingPoint.row][startingPoint.col] == target) {
			visited[startingPoint.row][startingPoint.col] = false;
			int newDistance = distances[startingPoint.row][startingPoint.col] - distances[latestPoint.row][latestPoint.col];
			minDistance = Math.min(minDistance, newDistance);

			latestPoint = startingPoint;
			int temp = source;
			source = target;
			target = temp;
		}

		for (Point nextPoint : getNextDirections(input, startingPoint)) {
			if (prevPoint != null && nextPoint.row == prevPoint.row && nextPoint.col == prevPoint.col) {
				continue;
			}
			if (!visited[nextPoint.row][nextPoint.col]) {
				int newDistance;
				distances[nextPoint.row][nextPoint.col] = distances[startingPoint.row][startingPoint.col] + 1;
				if (input[nextPoint.row][nextPoint.col] == source) {
					newDistance = DFS(input, nextPoint, nextPoint, startingPoint, visited, distances, source, target,
							minDistance);
					minDistance = Math.min(minDistance, newDistance);
				} else if (input[nextPoint.row][nextPoint.col] == target) {
					newDistance = DFS(input, nextPoint, latestPoint, startingPoint, visited, distances, source, target,
							minDistance);
					minDistance = Math.min(minDistance, newDistance);
				} else {
					newDistance = DFS(input, nextPoint, latestPoint, startingPoint, visited, distances, source, target,
							minDistance);
					minDistance = Math.min(minDistance, newDistance);
				}
			}
		}

		return minDistance;
	}

	private static Point findStartingPoint(int[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				if (input[i][j] == 1) {
					return new Point(i, j);
				} else if (input[i][j] == 2) {
					return new Point(i, j);
				}
			}
		}

		return null;
	}

	// BFS Gives incorrect result
	// e.g.
	// {1,1,0,0}
	// {2,0,0,0}
	// or
	// {1,0,0,0}
	// {0,0,0,0}
	// {0,0,2,0}
	// {1,0,0,0}
	public static int findNearestPair22(int[][] input) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[input.length][input[0].length];
		int[][] distances = new int[input.length][input[0].length];
		queue.add(new Point(0, 0));
		int currentDistance = 0;
		int minDistance = Integer.MAX_VALUE;

		boolean foundXFirst = false;
		boolean foundYFirst = false;

		Point latestRow = null;

		if (input[0][0] == 1) {
			latestRow = new Point(0, 0);
			foundXFirst = true;
		} else if (input[0][0] == 2) {
			latestRow = new Point(0, 0);
			foundYFirst = true;
		}

		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Queue<Point> nextQueue = new LinkedList<>();
			for (Point point : queue) {
				for (Point nextPoint : getNextDirections(input, point)) {
					if (visited[nextPoint.row][nextPoint.col]) {
						continue;
					}

					visited[nextPoint.row][nextPoint.col] = true;

					int value = input[nextPoint.row][nextPoint.col];
					distances[nextPoint.row][nextPoint.col] = currentDistance + 1;

					if (!foundXFirst && !foundYFirst) {
						if (value == 1) {
							foundXFirst = true;
						} else if (value == 2) {
							foundYFirst = true;
						}
					}

					if (value == 1) {
						if (foundYFirst) {
							int newDistance = distances[nextPoint.row][nextPoint.col] - distances[latestRow.row][latestRow.col];
							minDistance = Math.min(newDistance, minDistance);
						} else {
							latestRow = nextPoint;
						}
					}

					if (value == 2) {
						if (foundXFirst) {
							int newDistance = distances[nextPoint.row][nextPoint.col] - distances[latestRow.row][latestRow.col];
							minDistance = Math.min(newDistance, minDistance);
						} else {
							latestRow = nextPoint;
						}
					}

					nextQueue.add(nextPoint);
				}
			}

			queue = nextQueue;
			currentDistance++;
		}

		return minDistance;
	}

	private static List<Point> getNextDirections(int[][] input, Point point) {
		List<Point> points = new ArrayList<>();
		for (int i = -1; i <= 1; i += 2) {
			int newRow = point.row + i;
			int newCol = point.col;

			if (validate(input, newRow, newCol)) {
				points.add(new Point(newRow, newCol));
			}

			newRow = point.row;
			newCol = point.col + i;

			if (validate(input, newRow, newCol)) {
				points.add(new Point(newRow, newCol));
			}
		}

		return points;
	}

	private static boolean validate(int[][] input, int row, int col) {
		if (row >= 0 && row < input.length && col >= 0 && col < input[0].length) {
			return true;
		}

		return false;
	}
}
