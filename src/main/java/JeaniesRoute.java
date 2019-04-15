import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// Incomplete
public class JeaniesRoute {

	private static class Edge {
		int from;
		int to;
		int weight;

		public Edge(int f, int t, int w) {
			from = f;
			to = t;
			weight = w;
		}
	}

	static int jeanisRoute(int[] destination, int[][] roads) {
		int noNodes = roads.length + 1;
		List<Edge>[] edgeList = readEdges(noNodes, roads);
		Set<Integer> destinationSet = getDestinationSet(destination);

		boolean[] removedNodes = getRemovedNodes(noNodes, destinationSet, edgeList);

		int[] result = findDistance(noNodes, edgeList, removedNodes, destination[0]);

		int totalWeight = result[0];
		int startNode = result[1];

		int diameter = findDistance(noNodes, edgeList, removedNodes, startNode)[2];

		return totalWeight * 2 - diameter;
	}

	private static Set<Integer> getDestinationSet(int[] destination) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < destination.length; i++) {
			set.add(destination[i]);
		}

		return set;
	}

	private static int[] findDistance(int noNodes, List<Edge>[] edgeList, boolean[] removedNodes, int source) {
		boolean[] visited = new boolean[noNodes + 1];
		int[] distances = new int[noNodes + 1];
		Arrays.fill(distances, -1);

		int total = 0;
		int lastNode = 0;
		int diameter = 0;

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(source);
		visited[source] = true;
		distances[source] = 0;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (Edge edge : edgeList[current]) {
				if (!removedNodes[edge.to] && !visited[edge.to]) {
					visited[edge.to] = true;
					total += edge.weight;
					distances[edge.to] = distances[edge.from] + edge.weight;
					if (diameter < distances[edge.to]) {
						diameter = distances[edge.to];
						lastNode = edge.to;
					}
					queue.offer(edge.to);
				}
			}
		}

		return new int[] {total, lastNode, diameter};
	}

	private static boolean[] getRemovedNodes(int noNodes, Set<Integer> destinationSet, List<Edge>[] edgeList) {
		boolean[] removedNodes = new boolean[noNodes + 1];
		int[] degrees = new int[noNodes + 1];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= noNodes; i++) {
			degrees[i] = edgeList[i].size();
			if (!destinationSet.contains(i) && degrees[i] == 1) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();
			removedNodes[current] = true;
			for (Edge edge : edgeList[current]) {
				int next = edge.to;
				if (destinationSet.contains(next)) {
					break;
				} else if (!removedNodes[next]) {
					degrees[next]--;
					if (degrees[next] == 1) {
						queue.offer(next);
					}
				}
			}
		}

		return removedNodes;
	}

	private static List<Edge>[] readEdges(int noNodes, int[][] roads) {
		List<Edge>[] edgeList = new ArrayList[noNodes + 1];
		for (int i = 1; i <= noNodes; i++) {
			edgeList[i] = new ArrayList<>();
		}

		for (int i = 0; i < roads.length; i++) {
			int f = roads[i][0];
			int t = roads[i][1];
			int w = roads[i][2];

			edgeList[f].add(new Edge(f, t, w));
			edgeList[t].add(new Edge(t, f, w));
		}

		return edgeList;
	}

}
