import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	private static class Graph {
		int noNodes;
		List<Integer> edges[];

		public Graph(int n) {
			this.noNodes = n;
			edges = new LinkedList[n];
			for (int i = 0; i < n; i++) {
				edges[i] = new LinkedList<>();
			}
		}

		public void addEdge(int from, int to) {
			edges[from].add(to);
		}

		public void topologicalSort() {
			Stack<Integer> stack = new Stack<>();
			boolean[] visited = new boolean[noNodes];
			for (int i = 0; i < noNodes; i++) {
				if (!visited[i]) {
					topologicalSortUtil(visited, i, stack);
				}
			}

			while(!stack.isEmpty()) {
				System.out.println(stack.pop());
			}
		}

		private void topologicalSortUtil(boolean[] visited, int node, Stack<Integer> stack) {
			visited[node] = true;

			for (Integer to : edges[node]) {
				if (!visited[to]) {
					topologicalSortUtil(visited, to, stack);
				}
			}

			stack.push(node);
		}
	}

	public static void main(String args[]) {
		// Create a graph given in the above diagram
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		g.topologicalSort();
	}
}
