public class EliminationGame {
	public int lastRemaining(int n) {
		int head = 1;
		int step = 1;
		int remaining = n;
		boolean left = true;

		while (remaining > 1) {
			if (left) {
				head = head + step;
			} else if (remaining % 2 == 1) {
				head = head + step;
			}

			remaining = remaining / 2;
			left = !left;
			step *= 2;
		}

		return head;
	}
}
