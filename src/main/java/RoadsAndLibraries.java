import java.util.ArrayList;
import java.util.List;

public class RoadsAndLibraries {
	private static class Node {
		int seq;
		List<Node> next = new ArrayList<>();

		public Node(int s) {
			this.seq = s;
		}
	}

	static long roadsAndLibraries(int n, long c_lib, long c_road, int[][] cities) {
		if (c_lib <= c_road) {
			return n * c_lib;
		}

		List<Node> nodes = buildGraph(n, cities);
		boolean[] visited = new boolean[n];

		long answer = 0;
		for (Node node : nodes) {
			if (!visited[node.seq]) {
				answer += (findConnectedCities(node, visited) - 1) * c_road + c_lib;
			}
		}
		return answer;
	}

	private static List<Node> buildGraph(int size, int[][] cities) {
		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			nodes.add(new Node(i));
		}
		for (int i = 0; i < cities.length; i++) {
			Node c1 = nodes.get(cities[i][0] - 1);
			Node c2 = nodes.get(cities[i][1] - 1);

			c1.next.add(c2);
			c2.next.add(c1);
		}
		return nodes;
	}

	private static long findConnectedCities(Node source, boolean[] visited) {
		long sum = 1;
		visited[source.seq] = true;
		for (Node node : source.next) {
			if (!visited[node.seq]) {
				sum += findConnectedCities(node, visited);
			}
		}

		return sum;
	}
}
