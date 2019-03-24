import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueensAttackII {
	static int queensAttack(int boardLength, int noObstacles, int queenRow, int queenCol, int[][] obstacles) {
		int answer = 0;
		Map<Integer, List<Integer>> obstaclesByRow = new HashMap<>();
		Map<Integer, List<Integer>> obstaclesByCol = new HashMap<>();
		Map<Integer, List<Integer>> diagonalObstaclesByRow = new HashMap<>();
		for (int i = 0; i < obstacles.length; i++) {
			updateMap(obstaclesByRow, obstacles[i][0], obstacles[i][1]);
			updateMap(obstaclesByCol, obstacles[i][1], obstacles[i][0]);
			if (queenRow != obstacles[i][0] || queenCol != obstacles[i][1]) {
				if (Math.abs(obstacles[i][0] - queenRow) == Math.abs(obstacles[i][1] - queenCol)) {
					updateMap(diagonalObstaclesByRow, obstacles[i][0], obstacles[i][1]);
				}
			}
		}

		answer += getAvailablePathInRow(obstaclesByRow, queenRow, queenCol, boardLength);
		answer += getAvailablePathInCol(obstaclesByCol, queenRow, queenCol, boardLength);

		answer += getAvailablePathInDiagonal(diagonalObstaclesByRow, queenRow, queenCol, boardLength);

		return answer;
	}

	private static void updateMap(Map<Integer, List<Integer>> map, int key, int value) {
		List<Integer> current = map.getOrDefault(key, new ArrayList<>());
		current.add(value);
		map.put(key, current);
	}

	private static int binarySearchForQueen(List<Integer> input, int key) {
		int left = 0;
		int right = input.size();
		int mid = (left + right) / 2;
		while (left < right) {
			if (input.get(mid) > key) {
				right = mid;
			} else {
				left = mid + 1;
			}
			mid = (left + right) / 2;
		}

		if (mid == input.size()) {
			mid = mid - 1;
		}

		if (input.get(mid) > key) {
			return mid;
		} else {
			return mid - 1;
		}
	}

	private static int getAvailablePathInRow(Map<Integer, List<Integer>> obstaclesByRow, int queenRow, int queenCol,
			int boardLength) {
		int result = 0;
		// check row
		List<Integer> obsInQueenCol = obstaclesByRow.getOrDefault(queenRow, new ArrayList<>());
		if (obsInQueenCol.size() == 0) {
			return boardLength - 1;
		}

		Collections.sort(obsInQueenCol);
		// find the position idx such that obsInQueenCol.get(idx) < queenRow (if applicable) and
		// obsInQueenCol.get(idx + 1) > queenRow (if applicable)

		if (obsInQueenCol.get(0) > queenCol) {
			result += (obsInQueenCol.get(0) - 2);
			return result;
		}

		if (obsInQueenCol.get(obsInQueenCol.size() - 1) < queenCol) {
			result += (boardLength - obsInQueenCol.get(obsInQueenCol.size() - 1) - 1);
			return result;
		}

		int idx = binarySearchForQueen(obsInQueenCol, queenCol);
		result += (queenCol - obsInQueenCol.get(idx - 1) - 1);
		result += (obsInQueenCol.get(idx) - queenCol - 1);

		return result;
	}

	private static int getAvailablePathInCol(Map<Integer, List<Integer>> obstaclesByCol, int queenRow, int queenCol,
			int boardLength) {
		int result = 0;
		// check row
		List<Integer> obsInQueenRow = obstaclesByCol.getOrDefault(queenCol, new ArrayList<>());
		if (obsInQueenRow.size() == 0) {
			return boardLength - 1;
		}

		Collections.sort(obsInQueenRow);

		if (obsInQueenRow.get(0) > queenRow) {
			result += (obsInQueenRow.get(0) - 2);
			return result;
		}

		if (obsInQueenRow.get(obsInQueenRow.size() - 1) < queenRow) {
			result += (boardLength - obsInQueenRow.get(obsInQueenRow.size() - 1) - 1);
			return result;
		}

		int idx = binarySearchForQueen(obsInQueenRow, queenRow);
		result += (queenRow - obsInQueenRow.get(idx - 1) - 1);
		result += (obsInQueenRow.get(idx) - queenRow - 1);

		return result;
	}

	private static int getAvailablePathInDiagonal(Map<Integer, List<Integer>> diagonalObstacles, int queenRow, int queenCol,
			int boardLength) {
		int result = 0;

		result += updateDiagonal(diagonalObstacles, queenRow, queenCol, boardLength, 1);
		result += updateDiagonal(diagonalObstacles, queenRow, queenCol, boardLength, -1);

		return result;
	}

	private static int updateDiagonal(Map<Integer, List<Integer>> diagonalObstacles, int queenRow, int queenCol, int boardLength,
			int direction) {
		int result = 0;

		boolean leftObstacles = false;
		boolean rightObstacles = false;

		int size = 1;
		while (true) {
			int currentRow = queenRow + size * direction;

			if (currentRow <= 0 || currentRow > boardLength || (leftObstacles && rightObstacles)) {
				break;
			}

			List<Integer> diagonals = diagonalObstacles.getOrDefault(currentRow, new ArrayList<>());
			int leftCurrentCol = queenCol - size;
			int rightCurrentCol = queenCol + size;

			int leftIdx = diagonals.indexOf(leftCurrentCol);
			int rightIdx = diagonals.indexOf(rightCurrentCol);

			if (leftIdx != -1) {
				leftObstacles = true;
			}

			if (rightIdx != -1) {
				rightObstacles = true;
			}

			if (!leftObstacles && leftCurrentCol > 0) {
				result++;
			}

			if (!rightObstacles && rightCurrentCol <= boardLength) {
				result++;
			}

			size++;
		}

		return result;
	}

}
