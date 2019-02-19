import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BracketBalanced {

	public static boolean isBalanced(String s) {
		List<PairOfBracket> pairs = new ArrayList<>();
		pairs.add(new PairOfBracket('(', ')' ));
		pairs.add(new PairOfBracket('[', ']' ));
		pairs.add(new PairOfBracket('{', '}' ));

		List<Character> openingBrackets = pairs.stream().map(PairOfBracket::getOpening).collect(Collectors.toList());
		List<Character> closingBrackets = pairs.stream().map(PairOfBracket::getClosing).collect(Collectors.toList());

		return calculate(openingBrackets, closingBrackets, s);
	}

	public static boolean calculate(List<Character> openingBrackets, List<Character> closingBrackets, String s) {
		LinkedList<Character> queue = new LinkedList<>();

		for (int i = 0; i < s.length(); i++) {
			int openIdx = openingBrackets.indexOf(s.charAt(i));
			if (openIdx == -1) {
				int closeIdx = closingBrackets.indexOf(s.charAt(i));
				if (queue.isEmpty()) {
					return false;
				}

				Character bracket = queue.removeLast();

				if (openingBrackets.get(closeIdx) != bracket) {
					return false;
				}
				continue;
			}
			queue.add(s.charAt(i));
		}

		return queue.isEmpty();
	}

	private static class PairOfBracket {
		char opening;
		char closing;

		public PairOfBracket(char opening, char closing) {
			this.opening = opening;
			this.closing = closing;
		}

		public char getOpening() {
			return opening;
		}

		public char getClosing() {
			return closing;
		}
	}
}
