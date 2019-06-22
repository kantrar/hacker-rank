import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
	public class Edge implements Comparable<Edge> {
		int to;
		int from;
		Integer price;

		public Edge(int s, int e, int p) {
			this.to = s;
			this.from = e;
			this.price = p;
		}

		@Override
		public int compareTo(Edge other) {
			return this.price.compareTo(other.price);
		}
	}

	// The main challenge of this problem is to find how to avoid repeated task, and thus dp.
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		if (src == dst) {
			return 0;
		}

		List<Edge>[] canReach = new ArrayList[n];
		int[][] distances = new int[n][K + 2];

		for (int i = 0; i < distances.length; i++) {
			canReach[i] = new ArrayList<>();

			Arrays.fill(distances[i], -1);
		}

		distances[dst][0] = 0;

		for (int i = 0; i < flights.length; i++) {
			canReach[flights[i][1]].add(new Edge(flights[i][1], flights[i][0], flights[i][2]));
		}

		Queue<Edge> queue = new LinkedList<>();

		for (Edge edge : canReach[dst]) {
			queue.offer(edge);
		}

		int count = 1;
		boolean hasAnswer = false;
		while (!queue.isEmpty() && count <= K + 1) {
			Queue<Edge> nextQueue = new LinkedList<>();
			for (Edge current : queue) {
				if (distances[current.from][count] == -1
						|| distances[current.from][count] > distances[current.to][count - 1] + current.price) {
					distances[current.from][count] = distances[current.to][count - 1] + current.price;

					if (current.from == src) {
						hasAnswer = true;
					}

					for (Edge next : canReach[current.from]) {
						nextQueue.offer(next);
					}
				}

			}

			queue = nextQueue;
			count++;
		}

		return hasAnswer ? Arrays.stream(distances[src]).filter(a -> a != -1).min().getAsInt() : -1;
	}
}
