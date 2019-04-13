import java.util.Arrays;
import java.util.Comparator;

public class FindClosestPair {
	public class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}
	}

	public static double closestDistance(Point[] points) {
		Arrays.sort(points, Comparator.comparingInt(Point::getX));

		return closestUtil(points, 0, points.length);
	}

	public static double closestUtil(Point[] points, int start, int end) {
		if (end - start < 3) {
			return bruteForce(points, start, end);
		}

		int mid = (start + end) / 2;
		Point midPoint = points[mid];

		double dl = closestUtil(points, start, mid);
		double dr = closestUtil(points, mid + 1, end);

		double delta = Math.min(dl, dr);

		Point[] strips = new Point[end];
		int j = 0;
		for (int i = start; i < end; i++) {
			if (Math.abs(points[i].x - midPoint.x) < delta) {
				strips[j++] = points[i];
			}
		}

		return Math.min(delta, stripClosest(strips, j, delta));
	}

	public static double stripClosest(Point[] strips, int size, double distance) {
		double min = distance;
		Arrays.sort(strips, Comparator.comparingInt(Point::getY));

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size && (strips[i].y - strips[j].y) < min; j++) {
				min = Math.min(min, findDistance(strips[i], strips[j]));
			}
		}

		return min;
	}

	public static double bruteForce(Point[] points, int start, int end) {
		double minDistance = 0;
		for (int i = start; i < end; i++) {
			for (int j = i + 1; j < end; j++) {
				double newDistance = findDistance(points[i], points[j]);
				minDistance = Math.min(minDistance, newDistance);
			}
		}

		return minDistance;
	}

	public static double findDistance(Point p, Point q) {
		return Math.sqrt(Math.pow(p.x - q.x, 2) + Math.pow(p.y - q.y, 2));
	}
}
