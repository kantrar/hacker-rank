import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KnightDialer {
	public int knightDialer(int size) {
		if (size == 0) {
			return 0;
		}

		return bfs(size);
	}

	public int bfs(int size) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			queue.offer(i);
		}

		while (!queue.isEmpty() && size > 1) {
			Queue<Integer> nextQueue = new LinkedList<>();
			for (int current : queue) {
				for (int next : getNext(current)) {
					nextQueue.offer(next);
				}
			}
			queue = nextQueue;
			size--;
		}

		return queue.size();
	}

	public List<Integer> getNext(int value) {
		switch (value) {
		case 0:
			return Arrays.asList(4, 6);
		case 1:
			return Arrays.asList(6, 8);
		case 2:
			return Arrays.asList(7, 9);
		case 3:
			return Arrays.asList(4, 8);
		case 4:
			return Arrays.asList(3, 9, 0);
		case 5:
			return Arrays.asList();
		case 6:
			return Arrays.asList(1, 7, 0);
		case 7:
			return Arrays.asList(2, 6);
		case 8:
			return Arrays.asList(1, 3);
		case 9:
			return Arrays.asList(2, 4);
		default:
			return Arrays.asList();
		}
	}
}
