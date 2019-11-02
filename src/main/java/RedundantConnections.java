import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedundantConnections {
	public int[] findRedundantDirectedConnection(int[][] edges) {
		int N = edges.length;
		List<int[]> candidates = new ArrayList<>();
		int[] parent = new int[N + 1];
		Arrays.fill(parent, -1);
		for (int[] edge : edges) {
			if (parent[edge[1]] == -1) {
				parent[edge[1]] = edge[0];
			} else {
				candidates.add(new int[] {edge[0], edge[1]});
				candidates.add(new int[] {parent[edge[1]], edge[1]});
				edge[1] = -1;
				break;
			}
		}
		int[] rank = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int[] edge : edges) {
			if (edge[1] == -1) {
				continue;
			}
			int xRoot = findParent(parent, edge[0]);
			int yRoot = findParent(parent, edge[1]);

			if (xRoot == yRoot) {
				if (candidates.isEmpty()) {
					return edge;
				} else {
					return candidates.get(1);
				}
			} else {
				union(parent, rank, xRoot, yRoot);
			}
		}
		return candidates.get(0);
	}

	private int findParent(int[] parent, int cur) {
		if (parent[cur] != cur) {
			parent[cur] = findParent(parent, parent[cur]);
		}
		return parent[cur];
	}

	private void union(int[] parent, int[] rank, int xRoot, int yRoot) {
		if (rank[xRoot] > rank[yRoot]) {
			parent[yRoot] = xRoot;
		} else if (rank[xRoot] < rank[yRoot]) {
			parent[xRoot] = yRoot;
		} else {
			parent[xRoot] = yRoot;
			rank[yRoot]++;
		}
	}
}
