import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalReallySpecialSubtree {
	public static class Edge {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		public int getWeight() {
			return weight;
		}

		public int getSum() {
			return from + to + weight;
		}
	}

	public static class Subset {
		int parent;
		int rank;

		public Subset(int parent, int rank) {
			this.parent = parent;
			this.rank = rank;
		}
	}

	public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
		Queue<Edge> edgeQueue = createQueue(gFrom, gTo, gWeight);
		Subset[] subsets = createSubsets(gNodes);
		int noEdges = 0;
		int answer = 0;

		while (noEdges < gNodes - 1) {
			Edge currentEdge = edgeQueue.remove();

			int fromRoot = findRoot(subsets, currentEdge.from);
			int toRoot = findRoot(subsets, currentEdge.to);

			if (fromRoot == toRoot) {
				continue;
			}

			answer += currentEdge.weight;
			noEdges++;
			union(subsets, fromRoot, toRoot);
		}

		return answer;
	}

	private static Subset[] createSubsets(int length) {
		Subset[] subsets = new Subset[length + 1];

		for (int i = 0; i < subsets.length; i++) {
			subsets[i] = new Subset(i, 0);
		}

		return subsets;
	}

	private static void union(Subset[] subsets, int u, int v) {
		if (subsets[u].rank > subsets[v].rank) {
			subsets[v].parent = u;
		} else if (subsets[u].rank < subsets[v].rank) {
			subsets[u].parent = v;
		} else {
			subsets[u].parent = v;
			subsets[v].rank++;
		}
	}

	private static int findRoot(Subset[] subsets, int node) {
		if (subsets[node].parent == node) {
			return node;
		}

		subsets[node].parent = findRoot(subsets, subsets[node].parent);
		return subsets[node].parent;
	}

	private static Queue<Edge> createQueue(List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
		Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight).thenComparingInt(Edge::getSum));

		for (int i = 0; i < gFrom.size(); i++) {
			queue.add(new Edge(gFrom.get(i), gTo.get(i), gWeight.get(i)));
		}

		return queue;
	}
}
