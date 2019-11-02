import java.util.Stack;

public class ReverseSubstringBetweenEachPairOfParentheses {
	public String reverseParentheses(String s) {
		return find(s, new int[] {0});
	}

	private String find(String s, int[] posArray) {
		if (posArray[0] >= s.length()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack<>();
		while (posArray[0] < s.length()) {
			if (s.charAt(posArray[0]) == '(') {
				posArray[0]++;
				sb.append(reverse(find(s, posArray)));
			} else if (s.charAt(posArray[0]) == ')') {
				posArray[0]++;
				return sb.toString();
			} else {
				sb.append(s.charAt(posArray[0]++));
			}
		}
		return sb.toString();
	}

	private char[] reverse(String s) {
		char[] res = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			res[s.length() - i - 1] = s.charAt(i);
		}
		return res;
	}

}
