import java.util.Arrays;

public class ValidSquare {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[][] points = new int[4][2];

		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
		points[3] = p4;

		Arrays.sort(points, (int[] a, int[] b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		int diffX1 = points[0][0] - points[1][0];
		int diffY1 = points[0][1] - points[1][1];

		int diffX2 = points[2][0] - points[3][0];
		int diffY2 = points[2][1] - points[3][1];

		if (!(diffX1 == diffX2 && diffY1 == diffY2)) {
			return false;
		}

		int diffX3 = points[0][0] - points[2][0];
		int diffY3 = points[0][1] - points[2][1];

		int diffX4 = points[1][0] - points[3][0];
		int diffY4 = points[1][1] - points[3][1];

		if (!(diffX3 == diffX4 && diffY3 == diffY4)) {
			return false;
		}

		return Math.abs(diffX1) == Math.abs(diffY3) && Math.abs(diffY1) == Math.abs(diffX3);
	}
}
