public class DisjointSet {

	public static void main(String[] args) {
		int V = 4, E = 3;
		Graph graph = new Graph(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		// add edge 1-2
		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;

		// add edge 0-2
		graph.edge[2].src = 0;
		graph.edge[2].dest = 2;

		if (graph.isCycle(graph) == 1) {
			System.out.println("Graph contains cycle");
		} else {
			System.out.println("Graph doesn't contain cycle");
		}
	}

}

class Graph {
	int V, E;
	Edge[] edge;

	Graph(int nV, int nE) {
		V = nV;
		E = nE;
		edge = new Edge[E];
		for (int i = 0; i < E; i++) {
			edge[i] = new Edge();
		}
	}

	public int isCycle(Graph graph) {
		Subset[] subsets = new Subset[graph.V];

		for (int i = 0; i < subsets.length; i++) {
			subsets[i] = new Subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}

		for (int i = 0; i < graph.edge.length; i++) {
			Edge edge = graph.edge[i];
			int src = edge.src;
			int dest = edge.dest;

			int srcRoot = findRoot(subsets, src);
			int destRoot = findRoot(subsets, dest);

			if (srcRoot == destRoot) {
				return 1;
			}
			union(subsets, srcRoot, destRoot);
		}

		return 0;
	}

	private void union(Subset[] subsets, int a, int b) {
		int rootA = findRoot(subsets, a);
		int rootB = findRoot(subsets, b);

		if (rootA == rootB) {
			return;
		}

		if (subsets[rootA].rank < subsets[rootB].rank) {
			subsets[rootA].parent = rootB;
		} else if (subsets[rootA].rank > subsets[rootB].rank) {
			subsets[rootB].parent = rootA;
		} else {
			subsets[rootA].parent = rootB;
			subsets[rootB].rank++;
		}
	}

	private int findRoot(Subset[] subsets, int s) {
		if (subsets[s].parent != s) {
			subsets[s].parent = findRoot(subsets, subsets[s].parent);
		}
		return subsets[s].parent;
	}

	class Subset {
		int rank;
		int parent;
	}

	// class place represent edge
	class Edge {
		int src, dest;
	}
}

