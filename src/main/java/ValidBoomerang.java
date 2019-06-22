public class ValidBoomerang {
	public boolean isBoomerang(int[][] points) {
		return !sameSlope(points[0], points[1], points[2]) && distinct(points[0], points[1]) && distinct(points[1], points[2])
				&& distinct(points[0], points[2]);
	}

	public boolean sameSlope(int[] a, int[] b, int c[]) {
		String v1 = null;
		String v2 = null;
		if (b[0] == a[0]) {
			v1 = "horizontal";
		}
		if (c[0] == a[0]) {
			v2 = "horizontal";
		}

		if (v1 != null && v2 != null) {
			return true;
		}

		double value1 = (b[1] - a[1]) / (double) (b[0] - a[0]);
		double value2 = (c[1] - a[1]) / (double) (c[0] - a[0]);

		return Math.abs(value1 - value2) < 0.0000000001;
	}

	public boolean distinct(int[] a, int[] b) {
		return !(a[0] == b[0] && a[1] == b[1]);
	}
}
