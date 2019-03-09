import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class JackGoesToRapture {

	private static class Node {
		private long cost;
		private List<Node> comesFrom;
		private List<Edge> edges;

		public Node() {
			this.cost = -1;
			comesFrom = new ArrayList<>();
			edges = new ArrayList<>();
		}
	}

	private static class Edge {
		private int from;
		private int to;
		private long weight;
		private long rank;

		public Edge(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		public long getRank() {
			return rank;
		}

		public void updateRank(Node source) {
			if (source.cost == -1) {
				this.rank = weight;
			}
			if (this.weight > source.cost) {
				this.rank = weight;
			} else {
				this.rank = source.cost;
			}
		}
	}

	// Dijkstra's algorithm
	public static long getCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
		List<Node> nodes = buildNodes(gNodes);
		buildGraph(nodes, gFrom, gTo, gWeight);

		nodes.get(1).cost = 0;
		return findLowestCost(nodes, 1, gNodes);
	}

	private static long findLowestCost(List<Node> nodes, int source, int destination) {
		if (source == destination) {
			return -1;
		}

		Queue<Edge> edgeQueue = new PriorityQueue<>(Comparator.comparingLong(Edge::getRank));

		Node sourceNode = nodes.get(source);
		for (Edge edge : sourceNode.edges) {
			edge.updateRank(sourceNode);
			edgeQueue.add(edge);
		}

		do {
			Edge edge = edgeQueue.remove();
			Node currentNode = nodes.get(edge.from);
			Node nextNode = nodes.get(edge.to);

			long cost = 0;
			if (edge.weight > currentNode.cost) {
				cost = edge.weight;
			} else {
				cost = currentNode.cost;
			}

			nextNode.comesFrom.add(currentNode);
			if (nextNode.cost == -1 || nextNode.cost > cost) {
				nextNode.cost = cost;
				if (edge.to == destination) {
					return cost;
				}
			}

			currentNode = nodes.get(edge.to);

			for (Edge e : currentNode.edges) {
				if (nodes.get(e.to).comesFrom.contains(currentNode)) {
					continue;
				}
				e.updateRank(currentNode);
				edgeQueue.add(e);
			}

		} while (!edgeQueue.isEmpty());

		return -1;
	}

	// DFS yields Timeout
	public static long getCost2(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
		List<Node> nodes = buildNodes(gNodes);
		buildGraph(nodes, gFrom, gTo, gWeight);

		nodes.get(1).cost = 0;

		DFS(nodes, 1, null);

		return nodes.get(gNodes).cost;
	}

	private static List<Node> buildNodes(int gNodes) {
		List<Node> nodes = new ArrayList<>();
		nodes.add(new Node());

		for (int i = 0; i < gNodes; i++) {
			nodes.add(new Node());
		}

		return nodes;
	}

	private static void buildGraph(List<Node> nodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
		for (int i = 0; i < gFrom.size(); i++) {
			int from = gFrom.get(i);
			int to = gTo.get(i);
			int weight = gWeight.get(i);

			nodes.get(from).edges.add(new Edge(from, to, weight));
			nodes.get(to).edges.add(new Edge(to, from, weight));
		}
	}

	private static void DFS(List<Node> nodes, int source, Integer previousNode) {
		Node currentNode = nodes.get(source);

		for (Edge edge : currentNode.edges) {
			if (previousNode != null && edge.to == previousNode) {
				continue;
			}

			Node nextNode = nodes.get(edge.to);
			long cost;
			if (edge.weight - currentNode.cost > 0) {
				cost = edge.weight;
			} else {
				cost = currentNode.cost;
			}

			if (nextNode.cost == -1 || nextNode.cost > cost) {
				nextNode.cost = cost;

				if (edge.to == nodes.size() - 1) {
					continue;
				}

				DFS(nodes, edge.to, source);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int gNodes = Integer.parseInt(gNodesEdges[0]);
		int gEdges = Integer.parseInt(gNodesEdges[1]);

		List<Integer> gFrom = new ArrayList<>();
		List<Integer> gTo = new ArrayList<>();
		List<Integer> gWeight = new ArrayList<>();

		IntStream.range(0, gEdges).forEach(i -> {
			try {
				String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				gFrom.add(Integer.parseInt(gFromToWeight[0]));
				gTo.add(Integer.parseInt(gFromToWeight[1]));
				gWeight.add(Integer.parseInt(gFromToWeight[2]));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		long result = JackGoesToRapture.getCost(gNodes, gFrom, gTo, gWeight);
		System.out.println(result == -1 ? "NO PATH EXISTS" : result);

		bufferedReader.close();
	}
}
