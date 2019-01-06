import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightL {
	private static class Point {
		int row;
		int col;
		int d;

		Point(int row, int y) {
			this.row = row;
			this.col = y;
			this.d = -1;
		}

		@Override
		public boolean equals(Object obj) {
			Point other = (Point) obj;
			return (this.row == other.row && this.col == other.col);
		}
	}

	// Complete the knightlOnAChessboard function below.
	static int[][] knightlOnAChessboard(int n) {
		System.out.println("init result");
		int[][] results = new int[n - 1][n - 1];
		for(int i=0; i<n-1; i++) {
			results[i] = new int[n-1];
		}
		// return results;

		Point[][] points = new Point[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				points[i][j] = new Point(i, j);
			}
		}
		// Breadth First Search
		// If reach visited path -> return null
		// use queue

		for (int i = 0; i < n-1; i++) {
			for (int j = i; j < n-1; j++) {
				Queue<Point> queue = new LinkedList<>();
				resetPoints(points);
				results[i][j] = calculateDistance(queue, points, i + 1, j + 1);
				results[j][i] = results[i][j];
			}

		}

		return results;
	}

	private static void resetPoints(Point[][] points) {
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				points[i][j].d = -1;
			}
		}
	}

	private static int calculateDistance(Queue<Point> queue, Point[][] points, int x, int y) {
		Point origin = points[0][0];
		Point destination = points[points.length - 1][points.length - 1];

		queue.add(origin);
		origin.d = 0;

		while (!queue.isEmpty()) {
			Point current = queue.remove();
			if (current.equals(destination)) {
				return current.d;
			}

			addQueueIfApplicable(queue, points, current, current.row - x, current.col - y);
			addQueueIfApplicable(queue, points, current, current.row - x, current.col + y);
			addQueueIfApplicable(queue, points, current, current.row + x, current.col - y);
			addQueueIfApplicable(queue, points, current, current.row + x, current.col + y);

			addQueueIfApplicable(queue, points, current, current.row - y, current.col - x);
			addQueueIfApplicable(queue, points, current, current.row - y, current.col + x);
			addQueueIfApplicable(queue, points, current, current.row + y, current.col - x);
			addQueueIfApplicable(queue, points, current, current.row + y, current.col + x);
		}

		return -1;
	}

	private static void addQueueIfApplicable(Queue<Point> queue, Point[][] points, Point pointBefore, int row, int col) {
		if (inBoard(row, points.length) && inBoard(col, points.length)) {
			if (points[row][col].d != -1) {
				return;
			}
			points[row][col].d = pointBefore.d + 1;
			queue.add(points[row][col]);
		}
	}

	private static boolean inBoard(int v, int n) {
		return v >= 0 && v < n;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = 15;
		System.out.println("call method");
		int[][] result = knightlOnAChessboard(n);

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(String.valueOf(result[i][j]));

				if (j != result[i].length - 1) {
					System.out.print(" ");
				}
			}

			if (i != result.length - 1) {
				System.out.println();
			}
		}

	}
}
