import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TheStoryOfATree {
	private static class Graph {
		int noNodes;
		List<Integer>[] edges;
		int[] parents;

		public Graph(int n) {
			this.noNodes = n;
			edges = new ArrayList[noNodes + 1];
			for (int i = 0; i <= noNodes; i++) {
				edges[i] = new ArrayList<>();
			}
			parents = new int[noNodes + 1];
		}

		public void addEdge(int from, int to) {
			edges[from].add(to);
			edges[to].add(from);
		}

		public int getLeafNode() {
			for (int i = 1; i <= noNodes; i++) {
				if (edges[i].size() == 1) {
					return i;
				}
			}
			return -1;
		}

		public void findParents(int node) {
			boolean[] visited = new boolean[noNodes + 1];
			DFS(node, visited);
		}

		public void DFS(int node, boolean[] visited) {
			visited[node] = true;

			for (int edge : edges[node]) {
				if (!visited[edge]) {
					parents[edge] = node;
					DFS(edge, visited);
				}
			}
		}

		public int updateParents(int node, int parentNode, Map<Integer, List<Integer>> guessMap, int correct) {
			if (parents[node] == 0) {
				parents[node] = parentNode;

				List<Integer> currentGuess = guessMap.getOrDefault(node, new ArrayList<>());

				if (currentGuess.contains(parentNode)) {
					correct++;
				}

				return correct;
			}

			int prevParent = parents[node];
			parents[node] = parentNode;

			if (parentNode == prevParent) {
				return correct;
			}

			List<Integer> currentGuess = guessMap.getOrDefault(node, new ArrayList<>());

			boolean containsAnswerAfter = currentGuess.contains(parentNode);
			boolean containsAnswerBefore = currentGuess.contains(prevParent);

			if (containsAnswerAfter && !containsAnswerBefore) {
				correct++;
			} else if (!containsAnswerAfter && containsAnswerBefore) {
				correct--;
			}

			return updateParents(prevParent, node, guessMap, correct);
		}
	}

	static String storyOfATree(int noNodes, int[][] edges, int minCorrect, int[][] guesses) {
		int correctAnswer = 0;
		int incorrectAnswer = 0;
		Graph graph = new Graph(noNodes);
		for (int i = 0; i < edges.length; i++) {
			int from = edges[i][0];
			int to = edges[i][1];
			graph.addEdge(from, to);
		}

		HashMap<Integer, List<Integer>> guessMap = new HashMap<>();

		for (int i = 0; i < guesses.length; i++) {
			int expectedParent = guesses[i][0];
			int child = guesses[i][1];

			List<Integer> current = guessMap.getOrDefault(child, new ArrayList<>());
			current.add(expectedParent);
			guessMap.put(child, current);
		}

		// Find one of the leaf node
		int leafNode = graph.getLeafNode();
		graph.findParents(leafNode);
		int correct = checkAnswer(graph, guesses);

		Queue<Integer> queue = new LinkedList<>();
		queue.add(leafNode);

		boolean[] done = new boolean[noNodes + 1];

		while (!queue.isEmpty()) {
			int currentNode = queue.remove();

			if (done[currentNode]) {
				continue;
			}

			correct = graph.updateParents(currentNode, 0, guessMap, correct);

			if (correct >= minCorrect) {
				correctAnswer++;
			} else {
				incorrectAnswer++;
			}

			for (int edge : graph.edges[currentNode]) {
				queue.add(edge);
			}

			done[currentNode] = true;
		}

		int totalAnswer = correctAnswer + incorrectAnswer;
		int gcd = getGcd(correctAnswer, totalAnswer);
		totalAnswer = totalAnswer / gcd;
		correctAnswer = correctAnswer / gcd;

		if (correctAnswer == 0) {
			return "0/1";
		} else if (correctAnswer == totalAnswer) {
			return "1/1";
		} else {
			return String.format("%d/%d", correctAnswer, totalAnswer);
		}
	}

	private static int getGcd(int a, int b) {
		if (a == 0) {
			return b;
		}

		return getGcd(b % a, a);
	}

	private static int checkAnswer(Graph graph, int[][] guesses) {
		int correct = 0;

		for (int i = 0; i < guesses.length; i++) {
			int parent = guesses[i][0];
			int child = guesses[i][1];
			int realParent = graph.parents[child];
			if (realParent == parent) {
				correct++;
			}
		}

		return correct;
	}
}
