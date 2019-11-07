public class TilingARectangleWithTheFewestSquares {
	public int tilingRectangle(int m, int n) {
		if (m < n) {
			int t = m;
			m = n;
			n = t;
		}

		int[] min = new int[] { m * n };
		helper(m, n, new int[n], 0, min);

		return min[0];
	}

	public void helper(int m, int n, int[] height, int current, int[] min) {
		if (current > min[0]) {
			return;
		}
		boolean done = true;
		int startPos = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] != m) {
				done = false;
			}
			if (height[i] < height[startPos]) {
				startPos = i;
			}
		}

		if (done) {
			min[0] = Math.min(current, min[0]);
			return;
		}

		int cur = startPos;
		while (cur < n && height[cur] == height[startPos] && cur - startPos + 1 <= m - height[startPos]) cur++;

		for (int i = cur - 1; i >= startPos; i--) {
			int[] newHeight = new int[height.length];
			for (int j = 0; j < height.length; j++) {
				newHeight[j] = height[j];
			}
			for (int j = startPos; j <= i; j++) {
				newHeight[j] += i - startPos + 1;
			}

			helper(m, n, newHeight, current + 1, min);
		}
	}
}
