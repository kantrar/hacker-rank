import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaximumNestingDepthofTwoValidParenthesesStrings {
	public int[] maxDepthAfterSplit(String seq) {
		if (seq.length() == 0) {
			return new int[] {};
		}

		List<Integer> res = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int maxDepth = 0;
		for (int i = 0; i < seq.length(); i++) {
			char c = seq.charAt(i);
			if (c == '(') {
				stack.push(i);
				maxDepth = Math.max(maxDepth, stack.size());
			} else {
				if (stack.size() <= maxDepth / 2) {
					res.addAll(Arrays.asList(i, stack.pop()));
				} else {
					stack.pop();
				}
			}

			if (stack.isEmpty()) {
				maxDepth = 0;
			}
		}

		int[] ans = new int[seq.length()];
		for (int val : res) {
			ans[val] = 1;
		}
		return ans;
	}
}
