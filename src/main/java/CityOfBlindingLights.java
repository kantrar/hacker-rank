import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CityOfBlindingLights {

	public static int findShortestPath(Map<Integer, Integer>[] edgeMap, int source, int destination, int[][] distances,
			boolean[] visited) {
		if (source == destination) {
			distances[source][source] = 0;
			return 0;
		}

		visited[source] = true;

		for (int next : edgeMap[source].keySet()) {
			if (visited[next]) {
				continue;
			}

			if (distances[source][next] != -1) {
				distances[source][next] = Math
						.min(distances[source][next], distances[source][source] + edgeMap[source].get(next));
			} else {
				distances[source][next] = edgeMap[source].get(next);
				;
			}

			int minDistance = findShortestPath(edgeMap, next, destination, distances, visited);

			if (minDistance == -1) {
				continue;
			}
			if (distances[source][destination] == -1 || distances[source][destination] > distances[source][next] + minDistance) {
				distances[source][destination] = distances[source][next] + minDistance;
			}
		}

		return distances[source][destination];
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

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] roadNodesEdges = scanner.nextLine().split(" ");
		int roadNodes = Integer.parseInt(roadNodesEdges[0].trim());
		int roadEdges = Integer.parseInt(roadNodesEdges[1].trim());

		int[] roadFrom = new int[roadEdges];
		int[] roadTo = new int[roadEdges];
		int[] roadWeight = new int[roadEdges];

		for (int i = 0; i < roadEdges; i++) {
			String[] roadFromToWeight = scanner.nextLine().split(" ");
			roadFrom[i] = Integer.parseInt(roadFromToWeight[0].trim());
			roadTo[i] = Integer.parseInt(roadFromToWeight[1].trim());
			roadWeight[i] = Integer.parseInt(roadFromToWeight[2].trim());
		}

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		Map<Integer, Integer>[] edgeMap = readRoads(roadNodes, roadFrom, roadTo, roadWeight);
		boolean[] visited = new boolean[roadNodes + 1];
		int[][] distances = new int[roadNodes + 1][roadNodes + 1];

		for (int i = 1; i <= roadNodes; i++) {
			Arrays.fill(distances[i], -1);
			distances[i][i] = 0;
		}

		for (int qItr = 0; qItr < q; qItr++) {
			String[] xy = scanner.nextLine().split(" ");

			int x = Integer.parseInt(xy[0]);

			int y = Integer.parseInt(xy[1]);

			//			if (distances[x][y] == -1) {
			findShortestPath(edgeMap, x, y, distances, new boolean[roadNodes + 1]);
			//			}

			System.out.println(distances[x][y]);

		}

		scanner.close();
	}
}
