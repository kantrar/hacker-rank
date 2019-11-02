import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class EscapeALargeMaze {
	private static final long MAX = 1000000;
	private static int[][] moves = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

	public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
		Set<Long> set = new HashSet<>();
		for (int[] b : blocked) {
			set.add(hash(b));
		}

		if (set.contains(source) || set.contains(target)) {
			return false;
		}

		return isPossible(set, source, hash(target)) && isPossible(set, target, hash(source));
	}

	private Long hash(int[] value) {
		return (long) value[0] * MAX + (long) value[1];
	}

	private boolean isPossible(Set<Long> set, int[] source, Long targetHash) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(source);

		Set<Long> visited = new HashSet<>();
		int k = 0;
		while (!queue.isEmpty() && k < 200) {
			Queue<int[]> nextQueue = new LinkedList<>();
			for (int[] cur : queue) {
				for (int[] move : moves) {
					int nr = cur[0] + move[0];
					int nc = cur[1] + move[1];
					if (nr < 0 || nr >= 1000000 || nc < 0 || nc >= 1000000) {
						continue;
					}
					int[] next = new int[] {nr, nc};
					Long hash = hash(next);
					if (hash == targetHash) {
						return true;
					}
					if (set.contains(hash)) {
						continue;
					}
					if (visited.contains(hash)) {
						continue;
					}
					visited.add(hash);
					nextQueue.offer(next);
				}
			}
			k++;
			queue = nextQueue;
		}

		return k >= 200;
	}
}
