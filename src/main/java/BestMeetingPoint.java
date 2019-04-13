import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BestMeetingPoint {
	public class Point {
		int row;
		int col;
		int distance;

		public Point(int r, int c) {
			this.row = r;
			this.col = c;
		}
	}

	public int minTotalDistance(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		Point startPoint = new Point(0, 0);

		int distance = BFS(grid, startPoint);
		return moveStartPoint(grid, distance);

	}

	public int moveStartPoint(int[][] grid, int distance) {
		int[] sumForEachRow = new int[grid.length];
		int[] sumForEachCol = new int[grid[0].length];
		int sumAll = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				sumForEachRow[i] += grid[i][j];
				sumForEachCol[j] += grid[i][j];
				sumAll += grid[i][j];
			}
		}

		int deltaHorizontal = 0;
		int minHorizontal = 0;
		int leftSum = 0;
		for (int i = 1; i < grid[0].length; i++) {
			leftSum += sumForEachCol[i - 1]; // 2
			int rightSum = sumAll - leftSum; // 5
			deltaHorizontal += (leftSum - rightSum);
			minHorizontal = Math.min(deltaHorizontal, minHorizontal);
		}

		int deltaVertical = 0;
		int minVertical = 0;
		int topSum = 0;
		for (int j = 1; j < grid.length; j++) {
			topSum += sumForEachRow[j - 1];
			int bottomSum = sumAll - topSum;
			deltaVertical += (topSum - bottomSum);
			minVertical = Math.min(deltaVertical, minVertical);
		}

		return distance + minHorizontal + minVertical;
	}

	public int BFS(int[][] grid, Point point) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		Queue<Point> queue = new LinkedList<>();
		point.distance = 0;
		queue.add(point);
		visited[point.row][point.col] = true;
		int answer = 0;
		while (!queue.isEmpty()) {
			Queue<Point> nextQueue = new LinkedList<>();
			for (Point currentPoint : queue) {
				for (Point nextPoint : getNextPoints(grid, currentPoint)) {
					if (visited[nextPoint.row][nextPoint.col]) {
						continue;
					}

					visited[nextPoint.row][nextPoint.col] = true;
					nextPoint.distance = currentPoint.distance + 1;

					if (grid[nextPoint.row][nextPoint.col] == 1) {
						answer += nextPoint.distance;
					}

					nextQueue.add(nextPoint);
				}
			}
			queue = nextQueue;
		}

		return answer;
	}

	public List<Point> getNextPoints(int[][] grid, Point point) {
		List<Point> result = new ArrayList<>();
		for (int i = -1; i <= 1; i += 2) {
			int newRow = point.row + i;
			if (newRow >= 0 && newRow < grid.length) {
				result.add(new Point(newRow, point.col));
			}

			int newCol = point.col + i;
			if (newCol >= 0 && newCol < grid[0].length) {
				result.add(new Point(point.row, newCol));
			}
		}

		return result;
	}
}
