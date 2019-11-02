import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetAllKeys {
	private int[][] moves = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	public int shortestPathAllKeys(String[] grid) {
		int[] start = getStart(grid);
		int target = getTargetKey(grid);

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);

		boolean[][][] visited = new boolean[grid.length][grid[0].length()][target + 1];
		visited[start[0]][start[1]][0] = true;

		int steps = 0;

		while (!queue.isEmpty()) {
			Queue<int[]> nextQueue = new LinkedList<>();
			steps++;
			for (int[] cur: queue) {
				for (int[] move: moves) {
					int nr = cur[0] + move[0], nc = cur[1] + move[1], key = cur[2];
					if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length() || grid[nr].charAt(nc) == '#') {
						continue;
					}
					char c = grid[nr].charAt(nc);
					int acquiredKey = getKey(c);
					int lock = getLock(c);
					if (acquiredKey != 0) {
						key = key | acquiredKey;
					}
					if (key == target) return steps;
					if (visited[nr][nc][key]) continue;
					visited[nr][nc][key] = true;
					if (lock == 0 || (key & lock) != 0) {
						nextQueue.offer(new int[]{nr, nc, key});
					}
				}
			}
			queue = nextQueue;
		}
		return -1;
	}

	private int[] getStart(String[] grid) {
		int[] start = new int[] {0, 0, 0};

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length(); j++) {
				char c = grid[i].charAt(j);
				if (c == '@') {
					start = new int[] {i, j, 0};
				}

			}
		}
		return start;
	}

	private int getTargetKey(String[] grid) {
		int target = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length(); j++) {
				char c = grid[i].charAt(j);
				int key = getKey(c);
				if (key != 0) {
					target = target | key;
				}
			}
		}
		return target;
	}

	private int getKey(char c) {
		return c >= 'a' && c <= 'f' ? (1 << (c - 'a')) : 0;
	}

	private int getLock(char c) {
		return c >= 'A' && c <= 'F' ? (1 << (c - 'A')) : 0;
	}
}
