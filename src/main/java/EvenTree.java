import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EvenTree {

	public static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
		Map<Integer, List<Integer>> adjNodes = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> visited = new ArrayList<>();

		for (int i = 0; i < t_from.size(); i++) {
			updateMap(t_from, t_to, adjNodes, i);
			updateMap(t_to, t_from, adjNodes, i);
		}

		queue.add(1);
		return DFS(adjNodes, queue, visited);
	}

	private static int DFS(Map<Integer, List<Integer>> adjNodes, Queue<Integer> queue, List<Integer> visited) {
		int answer = 0;
		while (!queue.isEmpty()) {
			Integer currentNode = queue.remove();
			visited.add(currentNode);

			List<Integer> adjacentOfNode = adjNodes.get(currentNode);
			for (int i = 0; i < adjacentOfNode.size(); i++) {
				if (!visited.contains(adjacentOfNode.get(i))) {
					int countNode = countNodeAlongTheEdge(adjNodes, adjacentOfNode.get(i), currentNode);

					if (countNode % 2 == 0) {
						answer++;
					}
					queue.add(adjacentOfNode.get(i));
				}
			}
		}

		return answer;
	}

	private static int countNodeAlongTheEdge(Map<Integer, List<Integer>> adjNodes, Integer node, Integer parentNode) {
		int countNode = 1;
		for (int i = 0; i < adjNodes.get(node).size(); i++) {
			if (!adjNodes.get(node).get(i).equals(parentNode)) {
				countNode += countNodeAlongTheEdge(adjNodes, adjNodes.get(node).get(i), node);
			}
		}
		return countNode;
	}

	private static void updateMap(List<Integer> t_from, List<Integer> t_to, Map<Integer, List<Integer>> adjNodes, int i) {
		List<Integer> current = adjNodes.getOrDefault(t_from.get(i), new ArrayList<>());
		current.add(t_to.get(i));
		adjNodes.put(t_from.get(i), current);
	}
}
