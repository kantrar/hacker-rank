import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffTreesForGolfEvent {
	int ROW;
	int COL;

	public int cutOffTree(List<List<Integer>> forest) {
		if (forest == null || forest.size() == 0 || forest.get(0).size() == 0) {
			return 0;
		}

		ROW = forest.size();
		COL = forest.get(0).size();

		Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				int h = forest.get(i).get(j);
				if (h > 1) {
					queue.offer(new int[] {i, j, h});
				}
			}
		}

		int[] pos = new int[] {0, 0};
		int ans = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int value = bfs(forest, pos, cur);
			if (value == -1) {
				return -1;
			}
			ans += value;
			pos = cur;
		}
		return ans;
	}

	int[][] moves = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

	private int bfs(List<List<Integer>> forest, int[] src, int[] dest) {
		boolean[][] visited = new boolean[ROW][COL];

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(src);
		visited[src[0]][src[1]] = true;
		int dist = 0;
		while (!queue.isEmpty()) {
			Queue<int[]> nextQueue = new LinkedList<>();
			for (int[] cur : queue) {
				if (dest[0] == cur[0] && dest[1] == cur[1]) {
					return dist;
				}
				for (int[] move : moves) {
					int nr = cur[0] + move[0];
					int nc = cur[1] + move[1];
					if (nr < 0 || nr >= ROW || nc < 0 || nc >= COL || forest.get(nr).get(nc) == 0 || visited[nr][nc]) {
						continue;
					}
					visited[nr][nc] = true;
					nextQueue.offer(new int[] {nr, nc});
				}
			}
			dist++;
			queue = nextQueue;
		}
		return -1;
	}

}
