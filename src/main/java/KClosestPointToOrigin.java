public class KClosestPointToOrigin {
	public int[][] kClosest(int[][] points, int k) {
		if (k >= points.length) {
			return points;
		}

		int left = 0;
		int right = points.length - 1;

		find(points, left, right, k);

		int[][] answers = new int[k][2];
		for (int i = 0; i < k; i++) {
			answers[i] = points[i];
		}

		return answers;
	}

	public void find(int[][] points, int left, int right, int k) {
		int idx = partition(points, left, right);

		if (idx < k) {
			find(points, idx + 1, right, k);
		} else if (idx > k) {
			find(points, left, idx - 1, k);
		}
	}

	public int partition(int[][] points, int left, int right) {
		int[] pivot = points[right];
		int pivotIdx = left;
		for (int i = left; i < right; i++) {
			if (lessThan(points[i], pivot)) {
				swap(points, i, pivotIdx);
				pivotIdx++;
			}
		}

		swap(points, right, pivotIdx);

		return pivotIdx;
	}

	public boolean lessThan(int[] pointA, int[] pointB) {
		return distance(pointA) < distance(pointB);
	}

	public int distance(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}

	public void swap(int[][] points, int a, int b) {
		int[] temp = points[a];
		points[a] = points[b];
		points[b] = temp;
	}
}
