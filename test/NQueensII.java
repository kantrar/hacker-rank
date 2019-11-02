import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueensII {
	public int totalNQueens(int n) {
		Set<Integer> rowSet = new HashSet<>();
		Set<Integer> sumDiagonal = new HashSet<>();
		Set<Integer> deltaDiagonal = new HashSet<>();
		return backtrack(0, n, rowSet, sumDiagonal, deltaDiagonal);
	}

	private int backtrack(int currentCol, int N, Set<Integer> rowSet, Set<Integer> sumDiagonal, Set<Integer> deltaDiagonal) {
		if (currentCol >= N) {
			return 1;
		}

		int res = 0;
		for (int currentRow = 0; currentRow < N; currentRow++) {
			if (rowSet.contains(currentRow) || sumDiagonal.contains(currentRow + currentCol) || deltaDiagonal
					.contains(currentRow - currentCol)) {
				continue;
			}

			rowSet.add(currentRow);
			sumDiagonal.add(currentRow + currentCol);
			deltaDiagonal.add(currentRow - currentCol);
			res += backtrack(currentCol + 1, N, rowSet, sumDiagonal, deltaDiagonal);
			rowSet.remove(currentRow);
			sumDiagonal.remove(currentRow + currentCol);
			deltaDiagonal.remove(currentRow - currentCol);
		}

		return res;
	}

	private boolean isDiagonal(int currentCol, List<int[]> pos, int r) {
		for (int[] p : pos) {
			if (Math.abs(p[0] - r) == Math.abs(p[1] - currentCol)) {
				return true;
			}
		}
		return false;
	}
}
