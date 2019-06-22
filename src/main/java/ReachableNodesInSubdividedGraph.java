import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReachableNodesInSubdividedGraph {

	public class Subgraph {
		int minEnd;
		int maxEnd;
		boolean visitedMinEnd;
		boolean visitedMaxEnd;
		int nodes;
		int nodesVisitedFromMinEnd;
		int nodesVisitedFromMaxEnd;
		int nodesVisited;
		int maxMovesFromMinEnd;
		int maxMovesFromMaxEnd;
		boolean visited;

		public Subgraph(int minEnd, int maxEnd, int nodes) {
			this.minEnd = minEnd;
			this.maxEnd = maxEnd;
			this.nodes = nodes;
		}
	}

	// Time limit exceeded
	public int reachableNodes(int[][] edges, int M, int N) {
		List<Subgraph>[] subgraphs = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			subgraphs[i] = new ArrayList<>();
		}

		Set<Subgraph> set = new HashSet<>();
		for (int i = 0; i < edges.length; i++) {
			int minEnd = Math.min(edges[i][0], edges[i][1]);
			int maxEnd = Math.max(edges[i][0], edges[i][1]);
			int nodes = edges[i][2];
			Subgraph g1 = new Subgraph(minEnd, maxEnd, nodes);
			set.add(g1);
			subgraphs[minEnd].add(g1);
			subgraphs[maxEnd].add(g1);
		}

		dfs(subgraphs, 0, M + 1);

		int answer = 0;
		boolean[] visitedEnd = new boolean[N];
		for (Subgraph g : set) {
			visitedEnd[g.minEnd] = g.visitedMinEnd ? g.visitedMinEnd : visitedEnd[g.minEnd];
			visitedEnd[g.maxEnd] = g.visitedMaxEnd ? g.visitedMaxEnd : visitedEnd[g.maxEnd];

			answer += g.nodesVisited;
		}

		for (int i = 0; i < N; i++) {
			answer += visitedEnd[i] ? 1 : 0;
		}

		return answer == 0 ? 1 : answer;
	}

	public void dfs(List<Subgraph>[] subgraphs, int current, int originalMoves) {
		if (originalMoves < 1) {
			return;
		}

		for (Subgraph g : subgraphs[current]) {
			int moves = originalMoves;

			if (current == g.minEnd && moves > g.maxMovesFromMinEnd) {
				g.maxMovesFromMinEnd = moves;
			} else if (current == g.maxEnd && moves > g.maxMovesFromMaxEnd) {
				g.maxMovesFromMaxEnd = moves;
			} else {
				continue;
			}

			if (current == g.minEnd) {
				g.visitedMinEnd = true;
			} else {
				g.visitedMaxEnd = true;
			}
			moves--;

			if (moves >= g.nodes) {
				g.nodesVisited = g.nodes;
				if (current == g.minEnd) {
					dfs(subgraphs, g.maxEnd, moves - g.nodes);
				} else {
					dfs(subgraphs, g.minEnd, moves - g.nodes);
				}
			} else {
				if (current == g.minEnd) {
					g.nodesVisitedFromMinEnd = Math.max(moves, g.nodesVisitedFromMinEnd);
				} else if (current == g.maxEnd) {
					g.nodesVisitedFromMaxEnd = Math.max(moves, g.nodesVisitedFromMaxEnd);
				}

				if (g.nodesVisitedFromMinEnd + g.nodesVisitedFromMaxEnd >= g.nodes) {
					g.nodesVisited = g.nodes;
				} else {
					g.nodesVisited = Math.max(g.nodesVisited, g.nodesVisitedFromMinEnd + g.nodesVisitedFromMaxEnd);
				}
			}
		}
	}
}
