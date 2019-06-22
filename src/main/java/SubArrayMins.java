import java.util.Stack;

public class SubArrayMins {
	public int sumSubarrayMins(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();
		int[] prev = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
				stack.pop();
			}

			prev[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}

		stack = new Stack<>();
		int[] next = new int[A.length];
		for (int i = A.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && A[i] < A[stack.peek()]) {
				stack.pop();
			}

			next[i] = stack.isEmpty() ? A.length : stack.peek();
			stack.push(i);
		}

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += (i - prev[i]) * (next[i] - i) * A[i];
		}

		return sum;

	}
}
