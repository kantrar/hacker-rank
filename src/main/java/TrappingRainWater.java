import java.util.Stack;

public class TrappingRainWater {
	public int trap(int[] height) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
				int prev = height[stack.pop()];

				if (stack.isEmpty()) {
					break;
				}

				int h = Math.min(height[stack.peek()], height[i]) - prev;
				int w = i - stack.peek() - 1;
				answer += h * w;
			}
			stack.push(i);
		}

		return answer;
	}
}
