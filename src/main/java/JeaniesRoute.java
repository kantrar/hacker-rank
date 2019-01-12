import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

// Incomplete
public class JeaniesRoute {

	private static class Edge {
		int from;
		int to;
		int weight;

		public Edge(int fromCity, PrimMST.Node road) {
			from = fromCity;
			to = road.node;
			weight = road.weight;
		}
	}

	static int jeanisRoute(int[] destination, int[][] roads) {
		Map<Integer, List<PrimMST.Node>> adjCities = buildGraph(roads);
		List<Integer> destinationCities = Arrays.stream(destination).boxed().collect(Collectors.toList());

		int minDistance = -1;
		for (Integer destinationCity : destinationCities) {
			int distanceFromCurrentCity = findShortestPath(destinationCity, destinationCities, adjCities);
			if (minDistance == -1 || distanceFromCurrentCity < minDistance) {
				minDistance = distanceFromCurrentCity;
			}
		}

		return minDistance;
	}

	private static int findGraphDiameter(List<Integer> destinationCities, Map<Integer, List<PrimMST.Node>> adjCities) {
		int diameter = 0;
		for (Integer destinationCity : destinationCities) {
			int maxDistance = findLongestPath(destinationCity, destinationCities, adjCities);
			if (maxDistance > diameter) {
				diameter = maxDistance;
			}
		}
		return diameter;
	}

	private static int findLongestPath(Integer city, List<Integer> destinationCities,
			Map<Integer, List<PrimMST.Node>> adjCities) {
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> visited = new LinkedList<>();
		Map<Integer, Integer> shortestPath = new HashMap<>();

		queue.add(city);
		shortestPath.put(city, 0);
		while (!queue.isEmpty()) {
			int currentCity = queue.remove();
			visited.add(currentCity);

			int distanceToCurrentCity = shortestPath.get(currentCity);

			for (PrimMST.Node node : adjCities.get(currentCity)) {
				if (visited.contains(node.node)) {
					continue;
				}

				Integer currentDistance = shortestPath.getOrDefault(node.node, null);
				if (currentDistance == null) {
					shortestPath.put(node.node, distanceToCurrentCity + node.weight);
				} else if (currentDistance > distanceToCurrentCity + node.weight) {
					shortestPath.put(node.node, distanceToCurrentCity + node.weight);
				}
				queue.add(node.node);
			}
		}
		int maxDistance = 0;
		for (Integer c : shortestPath.keySet()) {
			if (destinationCities.contains(c) && maxDistance < shortestPath.get(c)) {
				maxDistance = shortestPath.get(c);
			}
		}
		return maxDistance;
	}

	private static int findShortestPath(Integer startCity, List<Integer> destinationCities,
			Map<Integer, List<PrimMST.Node>> adjCities) {
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> visited = new LinkedList<>();
		Map<Integer, Integer> shortestPath = new HashMap<>();
		List<Edge> potentialRoads = new LinkedList<>();
		List<Integer> destinationAlreadyVisited = new LinkedList<>();
		int distance = 0;

		destinationAlreadyVisited.add(startCity);
		queue.add(startCity);
		shortestPath.put(startCity, 0);
		while (destinationAlreadyVisited.size() != destinationCities.size()) {
			int currentCity = queue.remove();
			visited.add(currentCity);

			for (PrimMST.Node road : adjCities.get(currentCity)) {
				if (!visited.contains(road.node)) {
					potentialRoads.add(new Edge(currentCity, road));
				}
			}

			potentialRoads = potentialRoads.stream().sorted(Comparator.comparingInt(o -> o.weight)).collect(Collectors.toList());
			Edge edgeToExplore = potentialRoads.remove(0);

			Integer currentMinDistance = shortestPath.getOrDefault(edgeToExplore.to, null);
			int currentDistance = shortestPath.get(edgeToExplore.from) + edgeToExplore.weight;
			if (currentMinDistance == null || currentMinDistance > currentDistance) {
				currentMinDistance = currentDistance;
				shortestPath.put(edgeToExplore.to, currentMinDistance);
			}

			if (destinationCities.contains(edgeToExplore.to) && !destinationAlreadyVisited.contains(edgeToExplore.to)) {
				distance += currentMinDistance;
				destinationAlreadyVisited.add(edgeToExplore.to);
				potentialRoads = new LinkedList<>();
				shortestPath = new HashMap<>();
				queue = new LinkedList<>();
				visited = new LinkedList<>();
				shortestPath.put(edgeToExplore.to, 0);
			}
			queue.add(edgeToExplore.to);
		}
		return distance;
	}

	static Map<Integer, List<PrimMST.Node>> buildGraph(int[][] roads) {
		Map<Integer, List<PrimMST.Node>> adjCities = new HashMap<>();

		for (int[] road : roads) {
			int fromNode = road[0];
			int toNode = road[1];
			int weight = road[2];

			PrimMST.updateMap(adjCities, fromNode, toNode, weight);
		}

		return adjCities;
	}
}
