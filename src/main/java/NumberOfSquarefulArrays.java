import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfSquarefulArrays {
	int count;

	public int numSquarefulPerms(int[] A) {
		if (A == null || A.length < 2) {
			return 0;
		}
		count = 0;
		Arrays.sort(A);
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				int sqrt = (int) Math.sqrt(A[i] + A[j]);
				if (sqrt * sqrt == A[i] + A[j]) {
					if (!map.containsKey(i)) {
						map.put(i, new ArrayList<>());
					}
					map.get(i).add(j);
					if (!map.containsKey(j)) {
						map.put(j, new ArrayList<>());
					}
					map.get(j).add(i);
				}
			}
		}

		for (int i = 0; i < A.length; i++) {
			boolean[] visited = new boolean[A.length];
			dfs(map, i, -1, A.length - 1, visited);
		}

		return count;
	}

	private void dfs(Map<Integer, List<Integer>> map, int current, int parent, int todo, boolean[] visited) {
		if (todo == 0) {
			count++;
			return;
		}

		visited[current] = true;

		for (int next : map.get(current)) {
			if (visited[next]) {
				continue;
			}
			dfs(map, next, current, todo - 1, visited);
		}

		visited[current] = false;
	}
}
