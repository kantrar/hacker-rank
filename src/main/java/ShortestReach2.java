import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class ShortestReach2 {
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

		@Override
		public int hashCode() {
			return Objects.hash(from, to);
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Edge)) {
				return false;
			}

			Edge e = (Edge) obj;
			return this.hashCode() == e.hashCode();
		}
	}

	static int[] shortestReach(int noNodes, int[][] edges, int source) {
		int[] distances = new int[noNodes + 1];
		int[] answers = new int[noNodes - 1];
		Arrays.fill(distances, -1);

		List<Edge>[] edgeList = readEdges(noNodes, edges);
		Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getDistance));
		for (Edge edge : edgeList[source]) {
			queue.offer(edge);
		}

		boolean[] visited = new boolean[noNodes + 1];
		while (!queue.isEmpty()) {
			Edge current = queue.poll();
			if (visited[current.to]) {
				continue;
			}

			visited[current.to] = true;

			distances[current.to] = current.distance;

			for (Edge next : edgeList[current.to]) {
				queue.add(new Edge(next.from, next.to, distances[next.from] + next.distance));
			}
		}

		int idx = 0;
		for (int i = 1; i < distances.length; i++) {
			if (i == source) {
				continue;
			}
			answers[idx++] = distances[i];
		}

		return answers;
	}

	private static List<Edge>[] readEdges(int noNodes, int[][] edges) {
		List<Edge>[] edgeList = new ArrayList[noNodes + 1];
		for (int i = 1; i <= noNodes; i++) {
			edgeList[i] = new ArrayList<>();
		}
		for (int i = 0; i < edges.length; i++) {
			Edge e1 = new Edge(edges[i][0], edges[i][1], edges[i][2]);
			Edge e2 = new Edge(edges[i][1], edges[i][0], edges[i][2]);

			edgeList[e1.from].add(e1);
			edgeList[e2.from].add(e2);
		}

		return edgeList;
	}

	static int[] shortestReach2(int noNodes, int[][] edges, int source) {
		int[] distances = new int[noNodes + 1];
		int[] answers = new int[noNodes - 1];
		Arrays.fill(distances, -1);

		Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getDistance));
		Map<Edge, Integer>[] edgeList = new HashMap[noNodes + 1];
		for (int i = 1; i <= noNodes; i++) {
			edgeList[i] = new HashMap<>();
		}

		for (int i = 0; i < edges.length; i++) {
			Edge newEdge1 = new Edge(edges[i][0], edges[i][1], edges[i][2]);
			Edge newEdge2 = new Edge(edges[i][1], edges[i][0], edges[i][2]);

			if (!edgeList[edges[i][0]].containsKey(newEdge1) || edgeList[edges[i][0]].get(newEdge1) > edges[i][2]
					|| edgeList[edges[i][1]].get(newEdge2) > edges[i][2]) {
				newEdge1.distance = edges[i][2];
				edgeList[edges[i][0]].put(newEdge1, edges[i][2]);
				newEdge2.distance = edges[i][2];
				edgeList[edges[i][1]].put(newEdge2, edges[i][2]);
			}
		}

		for (Edge edge : edgeList[source].keySet()) {
			queue.offer(new Edge(edge.from, edge.to, edgeList[source].get(edge)));
		}

		boolean[] visited = new boolean[noNodes + 1];
		Set<Integer> nodeAdded = new HashSet<>();
		nodeAdded.add(source);
		visited[source] = true;
		distances[source] = 0;

		while (!queue.isEmpty() && nodeAdded.size() < noNodes) {
			Edge current = queue.poll();
			visited[current.to] = true;

			if (nodeAdded.contains(current.to)) {
				continue;
			}

			distances[current.to] = current.distance;

			nodeAdded.add(current.to);

			for (Edge next : edgeList[current.to].keySet()) {
				if (!visited[next.to]) {
					next.distance = distances[current.to] + edgeList[current.to].get(next);
					queue.offer(new Edge(next.from, next.to, next.distance));
				}
			}
		}

		int idx = 0;
		for (int i = 1; i < distances.length; i++) {
			if (i == source) {
				continue;
			}
			answers[idx++] = distances[i];
		}

		return answers;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) throws IOException {
		FastReader fastReader = new FastReader();
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = fastReader.nextInt();

		for (int tItr = 0; tItr < t; tItr++) {
			int n = fastReader.nextInt();

			int m = fastReader.nextInt();

			int[][] edges = new int[m][3];

			for (int i = 0; i < m; i++) {

				for (int j = 0; j < 3; j++) {

					edges[i][j] = fastReader.nextInt();
				}
			}

			int s = fastReader.nextInt();

			int[] result = shortestReach(n, edges, s);

			for (int i = 0; i < result.length; i++) {
				bufferedWriter.write(String.valueOf(result[i]));

				if (i != result.length - 1) {
					bufferedWriter.write(" ");
				}
			}

			bufferedWriter.newLine();
		}

		bufferedWriter.close();
	}
}
