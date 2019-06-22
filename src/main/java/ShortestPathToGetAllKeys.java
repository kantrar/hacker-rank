import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathToGetAllKeys {
	private static int[][] moves = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

	public class Path {
		char start;
		char end;
		int distance;
	}

	public int shortestPathAllKeys(String[] grid) {
		// @.a.#
		// ###.#
		// b.A.B

		// @..aA
		// ..B#.
		// ....b
		List<int[]>[][] paths = initPaths(grid);
		int keys = 0;
		int row = 0;
		int col = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length(); j++) {
				if (grid[i].charAt(j) == '@') {
					row = i;
					col = j;
				}
				if (isKey(i, j, grid)) {
					keys++;
				}
			}
		}

		boolean[] acquired = new boolean[keys];
		findShortestPath(paths, grid, row, col, acquired, keys);

		return 0;
	}

	private void findShortestPath(List<int[]>[][] paths, String[] grid, int row, int col, boolean[] acquired, int keys) {
		int count = 0;
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
		queue.offer(new int[] {row, col, 0});
		while (!queue.isEmpty()) {
			for (int[] current : queue) {
				for (int[] next : paths[current[0]][current[1]]) {
					if (isKey(next[0], next[1], grid)) {
						acquired[convertCharToInt(grid[next[0]].charAt(next[1]))] = true;
						count++;
						queue.offer(new int[] {next[0], next[1], current[2] + next[2]});
						if (count == keys) {
							return;
						}
					}
				}
			}
		}
	}

	private int convertCharToInt(char c) {
		return c - 'a';
	}

	private boolean isKey(int row, int col, String[] grid) {
		return grid[row].charAt(col) >= 'a' && grid[row].charAt(col) <= 'f';
	}

	private List<int[]>[][] initPaths(String[] grid) {
		List<int[]>[][] paths = new ArrayList[grid.length][grid[0].length()];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length(); j++) {
				paths[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length(); j++) {
				if (grid[i].charAt(j) == '.' || grid[i].charAt(j) == '#') {
					continue;
				}
				findPath(grid, i, j, paths);
			}
		}
		return paths;
	}

	public void findPath(String[] grid, int row, int col, List<int[]>[][] paths) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {row, col});
		int distance = 0;

		while (!queue.isEmpty()) {
			Queue<int[]> nextQueue = new LinkedList<>();
			for (int[] current : queue) {
				for (int[] move : moves) {
					int nextRow = current[0] + move[0];
					int nextCol = current[1] + move[1];

					if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length()) {
						continue;
					}

					if (grid[nextRow].charAt(nextCol) == '.') {
						nextQueue.offer(new int[] {nextRow, nextCol});
						continue;
					}

					if (grid[nextRow].charAt(nextCol) != '.' && grid[nextRow].charAt(nextCol) != '#') {
						paths[row][col].add(new int[] {nextRow, nextCol, distance});
					}
				}
			}

			queue = nextQueue;
			distance++;
		}
	}
}
