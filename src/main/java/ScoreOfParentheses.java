import java.util.Stack;

public class ScoreOfParentheses {
	public int scoreOfParentheses(String S) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int i = 0;
		while (i < S.length()) {
			char c = S.charAt(i);
			if (c == '(') {
				stack.push(0);
			} else {
				int current = stack.pop();
				int parent = stack.pop();
				stack.push(parent + Math.max(2 * current, 1));
			}
			i++;
		}

		return stack.pop();
	}
}
