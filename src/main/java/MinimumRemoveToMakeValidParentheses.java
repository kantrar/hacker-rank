import java.util.Deque;
import java.util.LinkedList;

public class MinimumRemoveToMakeValidParentheses {
	char OPEN = '(';
	char CLOSE = ')';
	public String minRemoveToMakeValid(String s) {
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == OPEN) {
				stack.addLast(i);
			} else if (s.charAt(i) == CLOSE) {
				if (!stack.isEmpty() && s.charAt(stack.peekLast()) == OPEN) {
					stack.pollLast();
					continue;
				}
				stack.addLast(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (!stack.isEmpty()) {
			int idx = stack.pollFirst();
			while (i < idx) {
				sb.append(s.charAt(i++));
			}
			i++;
		}
		while (i < s.length()) {
			sb.append(s.charAt(i++));
		}
		return sb.toString();
	}
}
