import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumMovesToReachTargetWithRotations {
	private class SnakePos {
		int[] headPos;
		int[] tailPos;

		public SnakePos(int[] head, int[] tail) {
			headPos = head;
			tailPos = tail;
		}

		public boolean isBlocked(int[][] grid) {
			if (headPos[0] >= grid.length || tailPos[0] >= grid.length || headPos[1] >= grid.length
					|| tailPos[1] >= grid.length) {
				return true;
			}
			return grid[headPos[0]][headPos[1]] == 1 || grid[tailPos[0]][tailPos[1]] == 1;
		}

		public boolean isVertical() {
			return headPos[1] == tailPos[1] && (headPos[0] == tailPos[0] + 1);
		}

		public boolean isHorizontal() {
			return headPos[0] == tailPos[0] && (headPos[1] == tailPos[1] + 1);
		}

		public boolean isTarget(int[][] grid) {
			return headPos[0] == grid.length - 1 && headPos[1] == grid.length - 1 && tailPos[0] == grid.length - 1
					&& tailPos[1] == grid.length - 2;
		}

		public String getKey() {
			return headPos[0] + "-" + headPos[1] + "-" + tailPos[0] + "-" + tailPos[1];
		}
	}

	public int minimumMoves(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		Queue<SnakePos> queue = new LinkedList<>();
		SnakePos start = new SnakePos(new int[] {0, 1}, new int[] {0, 0});
		queue.offer(start);

		Set<String> visited = new HashSet<>();
		visited.add(start.getKey());

		int steps = 0;
		while (!queue.isEmpty()) {
			steps++;
			Queue<SnakePos> nextQueue = new LinkedList<>();
			for (SnakePos cur : queue) {
				int[] head = cur.headPos;
				int[] tail = cur.tailPos;
				// right
				SnakePos rightPos = new SnakePos(new int[] {head[0], head[1] + 1}, new int[] {tail[0], tail[1] + 1});
				if (!rightPos.isBlocked(grid)) {
					if (processNewPosition(grid, visited, nextQueue, rightPos)) {
						return steps;
					}
				}
				// down
				SnakePos downPos = new SnakePos(new int[] {head[0] + 1, head[1]}, new int[] {tail[0] + 1, tail[1]});
				if (!downPos.isBlocked(grid)) {
					if (processNewPosition(grid, visited, nextQueue, downPos)) {
						return steps;
					}
				}

				SnakePos clockwisePos = new SnakePos(new int[] {tail[0] + 1, tail[1]}, new int[] {tail[0], tail[1]});
				if (cur.isHorizontal() && !clockwisePos.isBlocked(grid) && !downPos.isBlocked(grid)) {
					// clockwise
					if (processNewPosition(grid, visited, nextQueue, clockwisePos)) {
						return steps;
					}
				}

				SnakePos counterClockwisepos = new SnakePos(new int[] {tail[0], tail[1] + 1}, new int[] {tail[0], tail[1]});
				if (cur.isVertical() && !counterClockwisepos.isBlocked(grid) && !rightPos.isBlocked(grid)) {
					// counterclockwise
					if (processNewPosition(grid, visited, nextQueue, counterClockwisepos)) {
						return steps;
					}
				}
			}
			queue = nextQueue;
		}
		return -1;
	}

	private boolean processNewPosition(int[][] grid, Set<String> visited, Queue<SnakePos> nextQueue, SnakePos clockwisePos) {
		if (clockwisePos.isTarget(grid)) {
			return true;
		}
		if (visited.add(clockwisePos.getKey())) {
			nextQueue.offer(clockwisePos);
		}
		return false;
	}
}
