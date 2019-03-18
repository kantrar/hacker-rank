public class DisjointSet {

	public static void main(String[] args) {
		int V = 3, E = 3;
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
		Subset[] subsets = new Subset[graph.edge.length];

		for (int i = 0; i < subsets.length; i++) {
			Subset subset = new Subset();
			subset.rank = 0;
			subset.parent = i;
			subsets[i] = subset;
		}

		for (int i = 0; i < graph.edge.length; i++) {
			int s = graph.edge[i].src;
			int d = graph.edge[i].dest;

			int sRoot = findRoot(subsets, s);
			int dRoot = findRoot(subsets, d);

			if (sRoot != dRoot) {
				union(subsets, sRoot, dRoot);
			} else {
				return 1;
			}
		}

		return 0;
	}

	private void union(Subset[] subsets, int sRoot, int dRoot) {
		if (subsets[sRoot].rank > subsets[dRoot].rank) {
			subsets[dRoot].parent = sRoot;
		} else if (subsets[sRoot].rank < subsets[dRoot].rank) {
			subsets[sRoot].parent = dRoot;
		} else {
			subsets[dRoot].parent = sRoot;
			subsets[sRoot].rank++;
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

	// class to represent edge
	class Edge {
		int src, dest;
	}
}

