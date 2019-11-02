import java.util.HashMap;
import java.util.Map;

public class NumberOfSquarefulArrays {
	public int numSquarefulPerms(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			map.put(A[i], map.getOrDefault(A[i], 0) + 1);
		}

		int count = 0;
		for (int cur : map.keySet()) {
			count += perm(map, cur, new int[] {map.size()});
		}
		return count;
	}

	private int perm(Map<Integer, Integer> remaining, int cur, int[] unique) {
		int currentRemaining = remaining.get(cur) - 1;

		if (currentRemaining == 0) {
			unique[0]--;
		}
		if (unique[0] == 0) {
			unique[0]++;
			return 1;
		}

		int count = 0;

		remaining.put(cur, currentRemaining);

		for (int next : remaining.keySet()) {
			if (remaining.get(next) > 0 && isSquareful(cur, next)) {
				count += perm(remaining, next, unique);
			}
		}
		if (currentRemaining == 0) {
			unique[0]++;
		}
		remaining.put(cur, currentRemaining + 1);

		return count;
	}

	private boolean isSquareful(int a, int b) {
		int r = (int) Math.sqrt(a + b);
		return r * r == a + b;
	}
}
