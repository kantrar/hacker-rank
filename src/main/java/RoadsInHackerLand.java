import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class RoadsInHackerLand {
		public static class Edge {
			int from;
			int to;
			int distance;

			public Edge(int f, int t, int d) {
				this.from = f;
				this.to = t;
				this.distance = d;
			}

			public int getDistance() {
				return distance;
			}

		}

		// Incorrect, as cannot handle the case that distance is too high
		static String roadsInHackerland(int noNodes, int[][] edges) {
			Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getDistance));
			List<Edge>[] edgeList = new ArrayList[noNodes + 1];
			for (int i = 1; i <= noNodes; i++) {
				edgeList[i] = new ArrayList<>();
			}
			for (int i = 0; i < edges.length; i++) {
				Edge e1 = new Edge(edges[i][0], edges[i][1], edges[i][2]);
				queue.add(e1);
			}

			findMST(queue, edgeList, noNodes);

			int[] children = new int[noNodes + 1];
			Arrays.fill(children, -1);
			boolean[] visited = new boolean[noNodes + 1];

			int[] result = findChild(noNodes, 1, edgeList, children, visited);
			return convertToBinary(result[1]);
		}

		private static String convertToBinary(int number) {
			String answer = "";
			while (number > 0) {
				int r = number % 2;
				number = number / 2;
				answer = String.valueOf(r) + answer;
			}

			return answer;
		}

		static int[] findChild(int noNodes, int source, List<Edge>[] edgeList, int[] children, boolean[] visited) {
			visited[source] = true;
			int child = 0;
			int total = 0;

			for (Edge edge : edgeList[source]) {
				if (visited[edge.to]) {
					continue;
				}

				int[] result = findChild(noNodes, edge.to, edgeList, children, visited);
				int currentChild = 1 + result[0];
				total += result[1] + (noNodes - currentChild) * (currentChild) * (int) Math.pow(2, edge.distance);
				child += currentChild;
			}

			children[source] = child;
			return new int[] {child, total};
		}

		static void findMST(Queue<Edge> queue, List<Edge>[] edgeList, int noNodes) {
			Set<Integer> nodeAdded = new HashSet<>();
			Subset[] subsets = new Subset[noNodes + 1];

			for (int i = 1; i <= noNodes; i++) {
				subsets[i] = new Subset(i);
			}

			int edgeAdded = 0;

			while (edgeAdded < noNodes - 1) {
				Edge current = queue.poll();

				int fromRoot = findRoot(subsets, current.from);
				int toRoot = findRoot(subsets, current.to);

				if (fromRoot != toRoot) {
					union(subsets, fromRoot, toRoot);

					nodeAdded.add(current.from);
					nodeAdded.add(current.to);

					edgeAdded++;
					edgeList[current.from].add(new Edge(current.from, current.to, current.distance));
					edgeList[current.to].add(new Edge(current.to, current.from, current.distance));
				}
			}
		}

		public static int findRoot(Subset[] subsets, int value) {
			if (subsets[value].parent != value) {
				subsets[value].parent = findRoot(subsets, subsets[value].parent);
			}

			return subsets[value].parent;
		}

		public static void union(Subset[] subsets, int rootX, int rootY) {
			if (subsets[rootX].rank < subsets[rootY].rank) {
				subsets[rootX].parent = rootY;
			} else if (subsets[rootX].rank > subsets[rootY].rank) {
				subsets[rootY].parent = rootX;
			} else {
				subsets[rootY].parent = rootX;
				subsets[rootX].rank++;
			}
		}

		public static class Subset {
			int parent;
			int rank;

			public Subset(int p) {
				this.parent = p;
			}
		}

}
