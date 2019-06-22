import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TrappingRainWaterII {
	public class Point {
		int row;
		int col;
		int height;

		public Point(int r, int c, int h) {
			this.row = r;
			this.col = c;

			this.height = h;
		}
	}

	public class HeightComparator implements Comparator<Point> {
		@Override
		public int compare(Point a, Point b) {
			return a.height - b.height;
		}
	}

	public int trapRainWater(int[][] heightMap) {
		if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
			return 0;
		}

		int volume = 0;

		boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];

		Queue<Point> queue = new PriorityQueue<>(new HeightComparator());

		int rightIdx = heightMap[0].length - 1;
		for (int i = 0; i < heightMap.length; i++) {
			// left border
			queue.offer(new Point(i, 0, heightMap[i][0]));

			visited[i][0] = true;

			// right border
			queue.offer(new Point(i, rightIdx, heightMap[i][rightIdx]));

			visited[i][rightIdx] = true;
		}

		int bottomIdx = heightMap.length - 1;
		for (int j = 1; j < heightMap[0].length - 1; j++) {
			// top border
			queue.offer(new Point(0, j, heightMap[0][j]));

			visited[0][j] = true;

			// bottom border
			queue.offer(new Point(bottomIdx, j, heightMap[bottomIdx][j]));

			visited[bottomIdx][j] = true;
		}

		while (!queue.isEmpty()) {
			Point current = queue.poll();

			for (Point next : getNextPoints(heightMap, current)) {
				if (visited[next.row][next.col]) {
					continue;
				}

				visited[next.row][next.col] = true;
				int nextHeight = heightMap[next.row][next.col];
				int currentHeight = current.height;
				volume += Math.max(0, currentHeight - nextHeight);
				queue.offer(new Point(next.row, next.col, Math.max(currentHeight, nextHeight)));
			}
		}

		return volume;
	}

	public List<Point> getNextPoints(int[][] input, Point point) {
		List<Point> answer = new ArrayList<>();
		for (int i = -1; i <= 1; i += 2) {
			int newRow = point.row + i;
			int newCol = point.col;

			if (inBound(input, newRow, newCol)) {
				answer.add(new Point(newRow, newCol, input[newRow][newCol]));
			}

			newRow = point.row;
			newCol = point.col + i;

			if (inBound(input, newRow, newCol)) {
				answer.add(new Point(newRow, newCol, input[newRow][newCol]));
			}
		}

		return answer;
	}

	public boolean inBound(int[][] heightMap, int row, int col) {
		return row >= 0 && row < heightMap.length && col >= 0 && col < heightMap[0].length;
	}
}
