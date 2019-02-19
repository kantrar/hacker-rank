import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SnakesAndLadders {

	private static final int GOAL = 100;
	private static final int MAX_DIE = 6;

	public static int quickestWayUp() {

		Scanner in = new Scanner(System.in);
		//		int noOfTestCase = in.nextInt();
		//		int[] answers = new int[noOfTestCase];
		int noOfTestCase = 1;

		for (int t = 0; t < noOfTestCase; t++) {
			int noOfLadders = in.nextInt();
			List<Move> ladders = new ArrayList<>();
			for (int i = 0; i < noOfLadders; i++) {
				Move move = new Move(in.nextInt(), in.nextInt());
				ladders.add(move);
			}

			int noOfSnakes = in.nextInt();
			List<Move> snakes = new ArrayList<>();
			for (int i = 0; i < noOfSnakes; i++) {
				Move move = new Move(in.nextInt(), in.nextInt());
				snakes.add(move);
			}

			return calculate(ladders, snakes);
			//			System.out.println(calculate(ladders, snakes));
		}
		return 0;
	}

	private static int calculate(List<Move> ladders, List<Move> snakes) {
		Map<Integer, List<Integer>> map = getMapFromRules(ladders, snakes);

		return BFS(map);
	}

	private static int BFS(Map<Integer, List<Integer>> map) {
		Queue<Position> queue = new LinkedList();
		boolean[] visited = new boolean[GOAL];
		queue.add(new Position(0, 1));

		while (!queue.isEmpty()) {
			Position currentPosition = queue.remove();

			if (visited[currentPosition.pos]) {
				continue;
			}

			List<Integer> possibleRoutes = map.get(currentPosition.pos);
			visited[currentPosition.pos] = true;

			for (Integer possibleRoute : possibleRoutes) {
				if (possibleRoute == GOAL) {
					return currentPosition.distance + 1;
				}
				Position nextPosition = new Position(currentPosition.distance + 1, possibleRoute);
				queue.add(nextPosition);
			}
		}
		return -1;
	}

	private static Map<Integer, List<Integer>> getMapFromRules(List<Move> ladders, List<Move> snakes) {
		Map<Integer, List<Integer>> directions = new HashMap<>();

		List<Integer> laddersFrom = ladders.stream().map(Move::getFrom).collect(Collectors.toList());
		List<Integer> snakesFrom = snakes.stream().map(Move::getFrom).collect(Collectors.toList());

		int i = 1;
		while (i < GOAL) {
			boolean shouldFindNextDestination = true;
			for (int j = i + MAX_DIE; j >= i + 1; j--) {
				int snakePos = snakesFrom.indexOf(j);
				int ladderPos = laddersFrom.indexOf(j);

				if (snakePos != -1) {
					updateMap(directions, i, snakes.get(snakePos).to);
				} else if (ladderPos != -1) {
					updateMap(directions, i, ladders.get(ladderPos).to);
				} else if (shouldFindNextDestination) {
					if (j >= GOAL) {
						updateMap(directions, i, GOAL);
					} else {
						updateMap(directions, i, j);
					}
					shouldFindNextDestination = false;
				}
			}
			i++;
		}

		return directions;
	}

	private static void updateMap(Map<Integer, List<Integer>> directions, int i, int to) {
		List<Integer> possibleDirections = directions.getOrDefault(i, new ArrayList<>());
		possibleDirections.add(to);
		directions.put(i, possibleDirections);
	}

	private static class Move {
		int from;
		int to;

		public Move(int from, int to) {
			this.from = from;
			this.to = to;
		}

		public int getFrom() {
			return from;
		}

		public int getTo() {
			return to;
		}
	}

	private static class Position {
		int distance;
		int pos;

		public Position(int distance, int pos) {
			this.distance = distance;
			this.pos = pos;
		}
	}
}
