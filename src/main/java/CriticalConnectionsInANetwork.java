import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork {
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<Integer>[] edges = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			edges[i] = new ArrayList<>();
		}

		for (List<Integer> c : connections) {
			edges[c.get(0)].add(c.get(1));
			edges[c.get(1)].add(c.get(0));
		}

		List<List<Integer>> res = new ArrayList<>();
		int[] parent = new int[n];
		int[] discovery = new int[n];
		int[] earliest = new int[n];
		Arrays.fill(parent, -1);
		Arrays.fill(discovery, -1);
		Arrays.fill(earliest, Integer.MAX_VALUE);

		findBridge(edges, 0, 0, discovery, earliest, parent, res);

		return res;
	}

	private void findBridge(List<Integer>[] edges, int cur, int time, int[] discovery, int[] earliest, int[] parent,
			List<List<Integer>> res) {
		if (discovery[cur] != -1) {
			return;
		}
		discovery[cur] = time++;
		for (int next : edges[cur]) {
			if (discovery[next] == -1) {
				parent[next] = cur;
				findBridge(edges, next, time++, discovery, earliest, parent, res);
				earliest[cur] = Math.min(earliest[cur], earliest[next]);
				if (earliest[cur] < earliest[next]) {
					res.add(Arrays.asList(cur, next));
				}
			} else if (next != parent[cur]) {
				earliest[cur] = Math.min(earliest[cur], discovery[next]);
			}
		}
	}
}
