package AlgoExpert;

import java.util.LinkedList;
import java.util.Queue;

public class NumbersInPi {
	public static class Trie {
		Trie[] next = new Trie[10];
		boolean end;

	}

	public static int numbersInPi(String pi, String[] numbers) {
		if (pi.length() == 0) {
			return 0;
		}
		Trie root = new Trie();
		for (String n : numbers) {
			Trie current = root;
			for (int i = 0; i < n.length(); i++) {
				if (current.next[n.charAt(i) - '0'] == null) {
					current.next[n.charAt(i) - '0'] = new Trie();
				}
				current = current.next[n.charAt(i) - '0'];
			}
			current.end = true;
		}

		boolean[] visited = new boolean[pi.length() + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		visited[0] = true;
		int steps = 0;
		while (!queue.isEmpty()) {
			Queue<Integer> nextQueue = new LinkedList<>();

			for (int cur : queue) {
				Trie current = root;
				int shift = 0;
				while (current != null && cur + shift < pi.length()) {
					int idx = pi.charAt(cur + shift) - '0';
					current = current.next[idx];
					if (current != null && current.end && cur + shift + 1 <= pi.length() && !visited[cur + shift + 1]) {
						if (cur + shift + 1 == pi.length()) {
							return steps;
						}
						visited[cur + shift + 1] = true;
						nextQueue.offer(cur + shift + 1);
					}
					shift++;
				}
			}
			queue = nextQueue;
			steps++;
		}
		return -1;
	}
}
