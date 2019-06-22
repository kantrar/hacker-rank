import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesIISubsequence {
	public class Pair {
		int completed;
		int incompleted;

		public Pair(int a, int b) {
			this.completed = a;
			this.incompleted = b;
		}

	}

	public int numberOfArithmeticSlices(int[] A) {
		Map<Integer, Pair>[] map = new HashMap[A.length];
		for (int i = 0; i < A.length; i++) {
			map[i] = new HashMap<>();
		}

		int total = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				int diff = A[i] - A[j];
				Pair pair = map[j].getOrDefault(diff, new Pair(0, 0));
				Pair currentPair = map[i].getOrDefault(diff, new Pair(0, 0));

				if (pair.completed > 0) {
					currentPair.completed++;
				} else if (pair.incompleted > 0) {
					currentPair.completed += pair.incompleted;
				} else {
					currentPair.incompleted++;
				}

				map[i].put(diff, currentPair);
			}
			for (int diff : map[i].keySet()) {
				total += map[i].get(diff).completed;
			}
		}

		return total;
	}
}
