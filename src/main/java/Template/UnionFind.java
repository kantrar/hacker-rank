package Template;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionFind {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int M = grid.length;
		int N = grid[0].length;

		int[] parent = new int[M * N];
		Arrays.fill(parent, -1);

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == '0') {
					continue;
				}
				parent[i * N + j] = i * N + j;
				if (i > 0 && grid[i - 1][j] == '1') {
					union(parent, (i - 1) * N + j, i * N + j);
				}
				if (j > 0 && grid[i][j - 1] == '1') {
					union(parent, i * N + j - 1, i * N + j);
				}
			}
		}

		Set<Integer> parentSet = new HashSet<>();
		for (int p : parent) {
			if (p != -1) {
				parentSet.add(find(parent, p));
			}
		}
		return parentSet.size();
	}


	private void union(int[] parent, int prev, int cur) {
		int p1 = find(parent, prev);
		int p2 = find(parent, cur);
		parent[p1] = p2;
	}

	// can be optimized using rank
	//	Do Union(0, 1)
	//   		1   2   3
	//		   /
	//		  0
	//
	//	Do Union(1, 2)
	//   		1    3
	//		   / \
	//		  0   2
	//
	//	Do Union(2, 3)
	//    	   1
	//		/  |  \
	//	   0   2  3
	private void union(int[] parent, int[] rank, int a, int b) {
		int p1 = find(parent, a);
		int p2 = find(parent, b);
		if (rank[p1] > rank[p2]) {
			parent[p2] = parent[p1];
		} else if (rank[p1] < rank[p2]){
			parent[p1] = parent[p2];
		} else {
			parent[p2] = parent[p1];
			rank[p1]++;
		}
	}

	// path compression is done in this case
	//	Let the subset {0, 1, .. 9} be represented as below and find() is called
	//for element 3.
	//			   9
	//			/   |    \
	//		   4     5    6
	//		 /  \       /  \
	//		0    3     7    8
	//	       /  \
	//	      1    2
	//
	//	When find() is called for 3, we traverse up and find 9 as representative
	//	of this subset. With path compression, we also make 3 as the child of 9 so
	//	that when find() is called next time for 1, 2 or 3, the path to root is reduced.
	//			     9
	//			/  |   \    \
	//		   4   5   6     3
	//		 /        / \   /  \
	//		0        7  8   1  2

	private int find(int[] parent, int cur) {
		if (parent[cur] != cur) {
			parent[cur] = find(parent, parent[cur]);
		}
		return parent[cur];
	}
}
