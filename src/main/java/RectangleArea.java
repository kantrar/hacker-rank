public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int totalArea = area(A, B, C, D) + area(E, F, G, H);
		if (!horizontalOverlap(A, C, E, G)) {
			return totalArea;
		}
		if (!verticalOverlap(B, D, F, H)) {
			return totalArea;
		}

		return totalArea - area(Math.max(A, E),Math.max(B, F), Math.min(C, G), Math.min(D, H));
	}

	private int area(int a, int b, int c, int d) {
		return (d - b) * (c - a);
	}

	private boolean horizontalOverlap(int left1, int right1, int left2, int right2) {
		return left1 < right2 && left2 < right1;
	}

	private boolean verticalOverlap(int bottom1, int top1, int bottom2, int top2) {
		return top1 > bottom2 && top2 > bottom1;
	}
}
