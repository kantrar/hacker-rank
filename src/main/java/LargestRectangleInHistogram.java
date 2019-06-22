import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LargestRectangleInHistogram {

	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		for (int i = 0; i < heights.length; i++) {
			while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
				int height = heights[stack.pop()];
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;

				maxArea = Math.max(maxArea, height * width);
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int height = heights[stack.pop()];
			int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;

			maxArea = Math.max(maxArea, height * width);
		}

		return maxArea;
	}

	public int largestRectangleArea2(int[] heights) {

		if (heights.length == 0) {
			return 0;
		}

		Deque<Integer> deque = new LinkedList<>();
		int maxArea = 0;

		for (int i = 0; i < heights.length; i++) {
			while (!deque.isEmpty() && heights[i] <= heights[deque.peekLast()]) {
				int right = i;
				int height = heights[deque.removeLast()];
				int left = deque.isEmpty() ? -1 : deque.peekLast();

				maxArea = Math.max(maxArea, height * (right - left - 1));
			}

			deque.addLast(i);
		}

		while (!deque.isEmpty()) {
			int right = heights.length;
			int height = heights[deque.removeLast()];
			int left = deque.isEmpty() ? -1 : deque.peekLast();

			maxArea = Math.max(maxArea, height * (right - left - 1));
		}

		return maxArea;
	}
}
