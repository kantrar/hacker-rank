import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossiblePaths {
	private static class Graph {
		int noNodes;
		List<Edge>[] edges;

		public Graph(int noNodes) {
			this.noNodes = noNodes;
			edges = new ArrayList[noNodes];
			for (int i = 0; i < noNodes; i++) {
				edges[i] = new ArrayList<>();
			}
		}

		public void addEdge(int f, int t) {
			//			edges[f].add(new Edge(f, t));
			edges[t].add(new Edge(t, f));
		}

		public List<List<Integer>> findPaths(int source, int destination) {
			List<List<Integer>> answers = new ArrayList<>();

			if (source == destination) {
				List<Integer> answer = Arrays.asList(source);
				answers.add(answer);
			} else {
				for (Edge edge : edges[destination]) {
					List<List<Integer>> prevAnswers = findPaths(source, edge.to);
					for (List<Integer> prevAnswer : prevAnswers) {
						List<Integer> answer = new ArrayList<>(prevAnswer);
						answer.add(destination);

						answers.add(answer);
					}
				}
			}

			return answers;
		}
	}

	private static class Edge {
		int from;
		int to;

		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(9);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(8, 3);
		graph.addEdge(1, 8);
		graph.addEdge(7, 3);
		graph.addEdge(2, 6);
		graph.addEdge(6, 7);
		graph.addEdge(4, 6);
		graph.addEdge(4, 5);
		graph.addEdge(5, 3);

		List<List<Integer>> answers = graph.findPaths(0, 3);

		for (int i = 0; i < answers.size(); i++) {
			for (int j = 0; j < answers.get(i).size(); j++) {
				System.out.print(answers.get(i).get(j) + ", ");
			}

			System.out.println();
		}
	}
}
