package Google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponent {
	public int findMaxColor(int[][] input) {
		int max = 0;
		boolean[][] visited = new boolean[input.length][input[0].length];

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				if (visited[i][j]) {
					continue;
				}

				max = Math.max(max, findNumberColor(input, new Point(i, j), visited));
			}
		}

		return max;
	}

	private int findNumberColor(int[][] input, Point point, boolean[][] visited) {
		int numberOfColor = 1;
		int currentColor = input[point.row][point.col];

		Queue<Point> queue = new LinkedList<>();
		queue.offer(point);
		visited[point.row][point.col] = true;
		while (!queue.isEmpty()) {
			Point currentPoint = queue.poll();

			for (Point next : getNextPoints(input, currentPoint)) {
				if (!visited[next.row][next.col] && input[next.row][next.col] == currentColor) {
					numberOfColor++;
					visited[next.row][next.col] = true;
					queue.offer(next);
				}
			}
		}

		return numberOfColor;
	}

	private List<Point> getNextPoints(int[][] input, Point point) {
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

	private boolean validate(int[][] input, int row, int col) {
		if (row >= 0 && row < input.length && col >= 0 && col < input[0].length) {
			return true;
		}

		return false;
	}

	private class Point {
		int row;
		int col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
