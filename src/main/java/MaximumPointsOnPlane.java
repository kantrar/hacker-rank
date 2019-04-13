import java.util.HashMap;
import java.util.Map;

public class MaximumPointsOnPlane {
	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public boolean sameVerticalLine(Point anotherPoint) {
			return this.x == anotherPoint.x;
		}
	}

	public static class Line {
		Point p;
		Point q;

		public Line(Point p, Point q) {
			this.p = p;
			this.q = q;
		}

		public double slope() {
			return (double) (q.y - p.y) / (q.x - p.x);
		}
	}

	public static int findMaximumPoints(int[][] points) {
		Map<String, Integer> slopeMap = new HashMap<>();
		int maxPoints = 0;

		for (int i = 0; i < points.length; i++) {
			Point firstPoint = new Point(points[i][0], points[i][1]);
			int curMax = 0;
			int overlappingPoints = 0;
			int verticalPoints = 0;

			for (int j = i + 1; j < points.length; j++) {
				Point secondPoint = new Point(points[j][0], points[j][1]);

				if (firstPoint == secondPoint) {
					overlappingPoints++;
				} else if (firstPoint.sameVerticalLine(secondPoint)) {
					verticalPoints++;
				} else {
					Line line = new Line(firstPoint, secondPoint);
					double slope = line.slope();

					String key = String.valueOf(slope);
					int count = slopeMap.getOrDefault(key, 0);
					int newCount = count + 1;
					slopeMap.put(key, newCount);

					curMax = Math.max(curMax, newCount);
				}
			}

			curMax = Math.max(curMax, verticalPoints);

			maxPoints = Math.max(maxPoints, curMax + overlappingPoints + 1);
			slopeMap.clear();
		}

		return maxPoints;
	}
}
