import java.util.Stack;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int asteroid : asteroids) {
			while (asteroid < 0 && !stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
				stack.pop();
			}

			if (asteroid > 0) {
				stack.push(asteroid);
			} else if (!stack.isEmpty() && stack.peek() > 0) {
				if (stack.peek() > Math.abs(asteroid)) {
					continue;
				} else if (stack.peek() == Math.abs(asteroid)) {
					stack.pop();
				}
			} else {
				stack.push(asteroid);
			}
		}

		int[] res = new int[stack.size()];
		for (int i = stack.size() - 1; i >= 0; i--) {
			res[i] = stack.pop();
		}

		return res;
	}
}
