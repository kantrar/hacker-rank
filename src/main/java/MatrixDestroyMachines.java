import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MatrixDestroyMachines {

	public static class Graph {
		int noNodes;
		List<Edge> edges[];
		Subset[] subsets;

		public Graph(int n) {
			this.noNodes = n;
			edges = new ArrayList[noNodes];
			subsets = new Subset[noNodes];
			for (int i = 0; i < n; i++) {
				edges[i] = new ArrayList<>();
				subsets[i] = new Subset(i);
			}
		}

		public void addEdge(int from, int to, int cost) {
			edges[from].add(new Edge(from, to, cost));
//			edges[to].add(new Edge(to, from, cost));
		}

		public int connect(Edge edge, Set<Integer> machineSet) {
			int fromRoot = findRoot(edge.from);
			int toRoot = findRoot(edge.to);

			if (machineSet.contains(edge.from)) {
				subsets[fromRoot].hasMachine = true;
			}

			if (machineSet.contains(edge.to)) {
				subsets[toRoot].hasMachine = true;
			}

			if (subsets[fromRoot].hasMachine && subsets[toRoot].hasMachine) {
				return edge.cost;
			}

			if (fromRoot != toRoot) {
				if (subsets[fromRoot].rank < subsets[toRoot].rank) {
					subsets[fromRoot].parent = toRoot;
					subsets[toRoot].hasMachine = subsets[toRoot].hasMachine || subsets[fromRoot].hasMachine;
				} else if (subsets[fromRoot].rank > subsets[toRoot].rank) {
					subsets[toRoot].parent = fromRoot;
					subsets[fromRoot].hasMachine = subsets[toRoot].hasMachine || subsets[fromRoot].hasMachine;
				} else {
					subsets[toRoot].parent = fromRoot;
					subsets[fromRoot].rank++;
					subsets[fromRoot].hasMachine = subsets[toRoot].hasMachine || subsets[fromRoot].hasMachine;
				}
			}

			return 0;
		}

		private int findRoot(int node) {
			if (subsets[node].parent != node) {
				subsets[node].parent = findRoot(subsets[node].parent);
			}

			return subsets[node].parent;
		}
	}

	public static class Edge {
		int from;
		int to;
		int cost;

		public Edge(int f, int t, int c) {
			this.from = f;
			this.to = t;
			this.cost = c;
		}

		public int getInverseCost() {
			return -this.cost;
		}
	}

	private static class Subset {
		int parent;
		int rank;
		boolean hasMachine;

		public Subset(int node) {
			this.parent = node;
			this.rank = 0;
		}
	}

	static int minTime(int[][] roads, int[] machines) {
		Graph graph = new Graph(roads.length + 1);
		for (int i = 0; i < roads.length; i++) {
			graph.addEdge(roads[i][0], roads[i][1], roads[i][2]);
		}

		int distance = 0;
		return MST(graph, machines, distance);
	}

	private static int MST(Graph graph, int[] machines, int distance) {
		Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getInverseCost));
		for (int i = 0; i < graph.edges.length; i++) {
			queue.addAll(graph.edges[i]);
		}

		Set<Integer> machineSet = new HashSet<>();
		for (int i = 0; i < machines.length; i++) {
			machineSet.add(machines[i]);
		}

		while (!queue.isEmpty()) {
			Edge edge = queue.remove();
			distance += graph.connect(edge, machineSet);
		}

		return distance;
	}

	// DFS doesn't work because when the cost of the edges duplicates.
	static int minTime2(int[][] roads, int[] machines) {
		Graph graph = new Graph(roads.length + 1);
		for (int i = 0; i < roads.length; i++) {
			graph.addEdge(roads[i][0], roads[i][1], roads[i][2]);
		}

		boolean[] visited = new boolean[roads.length + 1];
		int[] distances = new int[roads.length + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < machines.length; i++) {
			set.add(machines[i]);
		}

		DFS(graph, machines[0], visited, distances);

		int total = 0;
		for (int i = 0; i < machines.length; i++) {
			if (i != 0) {
				total += distances[machines[i]];
			}
		}

		return total;
	}

	public static void DFS(Graph graph, int startNode, boolean[] visited, int[] distances) {
		visited[startNode] = true;
		for (Edge edge : graph.edges[startNode]) {
			if (!visited[edge.to]) {
				distances[edge.to] = Math.min(edge.cost, distances[startNode]);
				DFS(graph, edge.to, visited, distances);
			}
		}
	}

}
