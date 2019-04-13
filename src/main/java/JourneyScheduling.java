import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class JourneyScheduling {
	public static long[] journeyScheduling(int noNodes, int[][] roads, int[][] journeys) {
		List<Integer>[] edgeList = readRoads(noNodes, roads);

		int[] distances1 = new int[noNodes + 1];
		List<Integer> furthest1 = BFS(edgeList, 1, distances1);
		Collections.sort(furthest1);

		int[] distances2 = new int[noNodes + 1];
		List<Integer> furthest2 = BFS(edgeList, furthest1.get(0), distances2);
		Collections.sort(furthest2);

		int[] distances3 = new int[noNodes + 1];
		List<Integer> furthest3 = BFS(edgeList, furthest2.get(0), distances3);
		Collections.sort(furthest3);

		long[] answers = new long[journeys.length];
		for (int i = 0; i < journeys.length; i++) {
			int startNode = journeys[i][0];
			int cityToBeVisited = journeys[i][1];
			long total = 0;
			if (distances2[startNode] < distances3[startNode]) {
				total += distances3[startNode];
			} else {
				total += distances2[startNode];
			}
			total += (cityToBeVisited - 1) * (long) distances2[furthest2.get(0)];
			answers[i] = total;
		}

		return answers;
	}

	public static List<Integer>[] readRoads(int noNodes, int[][] roads) {
		List<Integer>[] edgeList = new ArrayList[noNodes + 1];
		for (int i = 1; i <= noNodes; i++) {
			edgeList[i] = new ArrayList<>();
		}

		for (int i = 0; i < roads.length; i++) {
			int from = roads[i][0];
			int to = roads[i][1];
			edgeList[from].add(to);
			edgeList[to].add(from);
		}

		return edgeList;
	}

	public static List<Integer> BFS(List<Integer>[] edgeList, int source, int[] distances) {
		int distance = 0;
		boolean[] visited = new boolean[edgeList.length];

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(source);
		visited[source] = true;

		List<Integer> answers = new ArrayList<>();

		while (!queue.isEmpty()) {
			Queue<Integer> nextQueue = new LinkedList<>();
			for (int current : queue) {
				distances[current] = distance;

				for (int next : edgeList[current]) {
					if (visited[next]) {
						continue;
					}

					visited[next] = true;
					nextQueue.add(next);
				}
			}
			distance++;

			if (nextQueue.isEmpty()) {
				return queue.stream().collect(Collectors.toList());
			}

			queue = nextQueue;
		}

		return answers;
	}
}
