import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
	private static int EMPTY = Integer.MAX_VALUE;
	private static int GATE = 0;
	private static int WALL = -1;


	// Incorrect
	public void wallsAndGates(int[][] rooms) {

		if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
			return;
		}

		int[][] distances = new int[rooms.length][rooms[0].length];
		boolean[][] visited = new boolean[rooms.length][rooms[0].length];
		for (int i = 0; i < distances.length; i++) {
			Arrays.fill(distances[i], -1);
		}

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j] == EMPTY && !visited[i][j]) {
					findPaths(rooms, i, j, distances, visited);
				}
			}
		}

		rooms = distances;
	}

	// I I I
	// 0 0 I
	// I I I
	//
	// 1 1 2
	// 0 0 1
	// 1 1 2
	public void findPaths(int[][] rooms, int row, int col, int[][] distances, boolean[][] visited) {
		visited[row][col] = true;
		int[] dr = new int[] {0, 0, -1, 1};
		int[] dc = new int[] {-1, 1, 0, 0};

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < dr.length; i++) {
			int newRow = row + dr[i];
			int newCol = col + dc[i];

			if (newRow >= 0 && newRow < rooms.length && newCol >= 0 && newCol < rooms[0].length
					&& rooms[newRow][newCol] != WALL) {
				if (!visited[newRow][newCol]) {
					visited[newRow][newCol] = true;
					if (rooms[newRow][newCol] == GATE) {
						distances[row][col] = 1;
						distances[newRow][newCol] = 0;
						return;
					} else if (rooms[newRow][newCol] == EMPTY) {
						queue.offer(new int[] {newRow, newCol});

					}
				} else {
					if (distances[newRow][newCol] != -1) {
						if (distances[row][col] == -1 || distances[row][col] > distances[newRow][newCol] + 1) {
							distances[row][col] = distances[newRow][newCol] + 1;
						}
					}
				}
			}
		}

		for (int[] point : queue) {
			int newRow = point[0];
			int newCol = point[1];

			findPaths(rooms, newRow, newCol, distances, visited);
			if (distances[newRow][newCol] != -1) {
				if (distances[row][col] == -1 || distances[row][col] > distances[newRow][newCol] + 1) {
					distances[row][col] = distances[newRow][newCol] + 1;
				}
			}
		}
	}
}
