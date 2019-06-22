import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CityOfBlindingLights2 {

	// Floyd
	public static int[][] findShortestPath(int noNodes, Map<Integer, Integer>[] edgeMap) {
		int[][] distances = new int[noNodes + 1][noNodes + 1];
		for (int i = 1; i < distances.length; i++) {
			Arrays.fill(distances[i], -1);
			for (int next : edgeMap[i].keySet()) {
				distances[i][next] = edgeMap[i].get(next);
			}
			distances[i][i] = 0;
		}
		for (int i = 1; i <= noNodes; i++) {
			for (int j = 1; j <= noNodes; j++) {
				for (int k = 1; k <= noNodes; k++) {
					if (distances[j][i] == -1 || distances[i][k] == -1) {
						continue;
					}
					int tempDistance = distances[j][i] + distances[i][k];
					if (distances[j][k] == -1 || distances[j][k] > tempDistance) {
						distances[j][k] = tempDistance;
					}
				}
			}
		}

		return distances;
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
		int[][] distances = findShortestPath(roadNodes, edgeMap);

		for (int qItr = 0; qItr < q; qItr++) {
			String[] xy = scanner.nextLine().split(" ");

			int x = Integer.parseInt(xy[0]);

			int y = Integer.parseInt(xy[1]);

			System.out.println(distances[x][y]);

		}

		scanner.close();
	}
}
