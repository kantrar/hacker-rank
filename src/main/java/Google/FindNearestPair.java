package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNearestPair {
	public static class Point {
		int row;
		int col;

		public Point(int r, int c) {
			this.row = r;
			this.col = c;
		}
	}

	public static int findNearestPair(int[][] matrix) {
		if (matrix.length == 0) {
			return -1;
		}

		int answer = 0;
		int[][] distances = new int[matrix.length][matrix[0].length];
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			Arrays.fill(distances[i], -1);
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (distances[i][j] == -1 && matrix[i][j] == 1) {
					answer = Math.min(answer, findNearestDistance(matrix, new Point(i, j), distances, visited));
				}
			}
		}

		return answer;
	}

	public static int findNearestDistance(int[][] matrix, Point point, int[][] distances, boolean[][] visited) {
		if (distances[point.row][point.col] != -1) {
			return distances[point.row][point.col];
		}

		if (matrix[point.row][point.col] == 2) {
			return 0;
		}

		visited[point.row][point.col] = true;
		distances[point.row][point.col] = 0;

		List<Point> nextPoints = getNextPoints(matrix, point);
		int answer = Integer.MAX_VALUE;

		for (Point nextPoint : nextPoints) {
			if (visited[nextPoint.row][nextPoint.col]) {
				continue;
			}
			visited[nextPoint.row][nextPoint.col] = true;
			answer = Math.min(answer, findNearestDistance(matrix, nextPoint, distances, visited) + 1);
		}

		distances[point.row][point.col] = answer;
		return answer;
	}

	public static List<Point> getNextPoints(int[][] matrix, Point point) {
		List<Point> result = new ArrayList<>();
		for (int i = -1; i <= 1; i += 2) {
			int newRow = point.row + i;
			int newCol = point.col;

			if (inBound(matrix, newRow, newCol)) {
				result.add(new Point(newRow, newCol));
			}

			newRow = point.row;
			newCol = point.col + i;

			if (inBound(matrix, newRow, newCol)) {
				result.add(new Point(newRow, newCol));
			}
		}

		return result;
	}

	public static boolean inBound(int[][] matrix, int row, int col) {
		if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
			return true;
		}

		return false;
	}

}
