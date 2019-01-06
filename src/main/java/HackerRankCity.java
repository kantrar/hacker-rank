public class HackerRankCity {

	public static class ExistingGraph {
		int noOfNode = 1;
		int distance = 0;
		int[] distances = new int[] {0, 0, 0, 0, 0, 0};
		int result = 0;
	}

	static int hackerRankCity(int[] A) {
		ExistingGraph existingGraph = new ExistingGraph();
		int times = 0;
		for (int edge : A) {
			times = existingGraph.noOfNode * 3 + 2;
			expandGraph(existingGraph, edge, times);
		}
		return existingGraph.result;
	}

	private static void expandGraph(ExistingGraph existingGraph, int edge, Integer times) {
		for (int i = 0; i < times; i++) {

			if (i == 0) {
				existingGraph.distances[1] = (edge * existingGraph.noOfNode) + existingGraph.distances[0];
				existingGraph.distance = (edge * existingGraph.noOfNode) + existingGraph.distances[0];
			} else if (i == 1) {
				existingGraph.distance = (edge * existingGraph.noOfNode) + existingGraph.distances[1];
				existingGraph.distances[1] = existingGraph.distances[1] + edge;
			} else if (i == 2) {
				existingGraph.distances[3] = (edge * existingGraph.noOfNode) + existingGraph.distances[1];
				existingGraph.distance = (edge * existingGraph.noOfNode) + existingGraph.distances[1];
			} else if (i == 3) {
				existingGraph.distance = (edge * existingGraph.noOfNode) + existingGraph.distances[3];
				existingGraph.distances[3] = existingGraph.distances[3] + edge;
			} else if (i == 4) {
				existingGraph.distances[5] = (edge * existingGraph.noOfNode) + existingGraph.distances[3];
				existingGraph.distance = (edge * existingGraph.noOfNode) + existingGraph.distances[3];
			}

			existingGraph.result = existingGraph.result + existingGraph.distance;
			existingGraph.noOfNode++;
		}
	}

}
