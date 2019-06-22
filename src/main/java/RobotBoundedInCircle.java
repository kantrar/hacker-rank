import java.util.HashSet;
import java.util.Set;

public class RobotBoundedInCircle {
	int[][] moves = new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

	public boolean isRobotBounded(String instructions) {
		if (instructions.length() == 0) {
			return true;
		}

		Set<String> set = new HashSet<>();

		int row = 0;
		int col = 0;

		set.add(String.format("%d-%d", row, col));

		int idx = moves.length - 1;
		for (int i = 0; i < 4; i++) {
			for (char inst : instructions.toCharArray()) {
				if (inst == 'G') {
					int[] move = moves[idx];
					row += move[0];
					col += move[1];
				} else if (inst == 'L') {
					idx = (idx + 1) % moves.length;
				} else if (inst == 'R') {
					idx = idx - 1 < 0 ? moves.length - 1 : idx - 1;
				}
			}
			String key = String.format("%d-%d", row, col);
			if (set.contains(key)) {
				return true;
			}
			set.add(key);
		}

		return false;
	}
}
