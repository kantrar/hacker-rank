import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CityOfBlindingLights {

	// Timeout
	public static void findShortestPath(Map<Integer, Integer>[] edgeMap, int source, int[][] distances, boolean[] visited) {
		visited[source] = true;

		for (int next : edgeMap[source].keySet()) {
			if (visited[next]) {
				continue;
			}

			if (distances[source][next] < 0 || distances[source][next] > edgeMap[source].get(next)) {
				distances[source][next] = edgeMap[source].get(next);
				findShortestPath(edgeMap, next, distances, visited);

				updateDistances(distances, source, next);
			}
		}

		visited[source] = false;
	}

	private static void updateDistances(int[][] distances, int source, int next) {
		for (int i = 0; i < distances.length; i++) {
			if (distances[next][i] < 0) {
				continue;
			}
			if (distances[source][i] < 0 || distances[source][i] > distances[source][next] + distances[next][i]) {
				distances[source][i] = distances[source][next] + distances[next][i];
			}
		}
	}

	public static Map<Integer, Integer>[] readRoads(int roadNodes, int[] roadFrom, int[] roadTo, int[] roadWeight) {
		Map<Integer, Integer>[] edgeMap = new HashMap[roadNodes + 1];
		for (int i = 1; i <= roadNodes; i++) {
			edgeMap[i] = new HashMap<>();
		}

		for (int i = 0; i < roadFrom.length; i++) {
			int f = roadFrom[i];
			int t = roadTo[i];
			int w = roadWeight[i];

			edgeMap[f].put(t, w);
		}

		return edgeMap;
	}

	public static void main(String[] args) {
		FastReader bufferedReader = new FastReader();

		int roadNodes = bufferedReader.nextInt();
		int roadEdges = bufferedReader.nextInt();

		int[] roadFrom = new int[roadEdges];
		int[] roadTo = new int[roadEdges];
		int[] roadWeight = new int[roadEdges];

		for (int i = 0; i < roadEdges; i++) {
			roadFrom[i] = bufferedReader.nextInt();
			roadTo[i] = bufferedReader.nextInt();
			roadWeight[i] = bufferedReader.nextInt();
		}

		int q = bufferedReader.nextInt();

		Map<Integer, Integer>[] edgeMap = readRoads(roadNodes, roadFrom, roadTo, roadWeight);
		boolean[] visited = new boolean[roadNodes + 1];
		int[][] distances = new int[roadNodes + 1][roadNodes + 1];

		for (int i = 1; i <= roadNodes; i++) {
			Arrays.fill(distances[i], -2);
			distances[i][i] = 0;
		}

		String answer = "";
		for (int qItr = 0; qItr < q; qItr++) {

			int x = bufferedReader.nextInt();

			int y = bufferedReader.nextInt();

			if (distances[x][y] == -2) {
				findShortestPath(edgeMap, x, distances, visited);
			}

			int res = distances[x][y] == -2 ? -1 : distances[x][y];
			answer += res + "\n";
		}

		System.out.print(answer);
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
}
