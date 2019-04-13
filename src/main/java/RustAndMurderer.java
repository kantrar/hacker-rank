import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class RustAndMurderer {
	public static class Edge {
		int from;
		int to;

		public Edge(int f, int t) {
			this.from = f;
			this.to = t;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Edge)) {
				return false;
			}

			Edge other = (Edge) obj;
			return this.from == other.from && this.to == other.to;
		}

		@Override
		public int hashCode() {
			return Objects.hash(from, to);
		}
	}

	static int[] rustMurderer(int noNodes, int[][] roads, int source) {
		Set<Edge> mainRoads = new HashSet<>();
		int[] distance = new int[noNodes + 1];
		Arrays.fill(distance, -1);
		List<Edge>[] edges = new ArrayList[noNodes + 1];

		for (int i = 0; i < roads.length; i++) {
			int from = roads[i][0];
			int to = roads[i][1];

			if (edges[from] == null) {
				edges[from] = new ArrayList<>();
			}
			Edge first = new Edge(from, to);
			edges[from].add(first);

			if (edges[to] == null) {
				edges[to] = new ArrayList<>();
			}
			Edge second = new Edge(to, from);
			edges[to].add(second);

			mainRoads.add(first);
			mainRoads.add(second);
		}

		return findShortestDistance(noNodes, edges, source, mainRoads);

	}

	private static int[] findShortestDistance(int noNodes, List<Edge>[] adj, int source, Set<Edge> mainRoads) {
		boolean[] visited = new boolean[noNodes + 1];
		int[] distances = new int[noNodes - 1];
		int idx = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(source);
		visited[source] = true;
		int distance = 0;

		while (!queue.isEmpty()) {
			Queue<Integer> nextQueue = new LinkedList<>();
			distance++;

			for (int current : queue) {
				for (int i = 1; i <= noNodes; i++) {
					if (visited[i]) {
						continue;
					}

					if (mainRoads.contains(new Edge(current, i))) {
						continue;
					}

					visited[i] = true;

					if (i < source) {
						distances[i - 1] = distance;
						idx++;
					} else if (i > source) {
						distances[i - 2] = distance;
						idx++;
					}

					if (idx == distances.length) {
						return distances;
					}

					nextQueue.offer(i);
				}
			}
			queue = nextQueue;
		}

		return distances;
	}

	public static void main(String[] args) {
		int[] result = RustAndMurderer.rustMurderer(4, new int[][] {{1, 2}, {2, 3}}, 4);
		System.out.println(result);
	}
}
