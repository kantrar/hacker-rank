import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Leaderboard {
	public class Player implements Comparable<Player> {
		int id;
		int score;

		public Player(int id, int s) {
			this.id = id;
			this.score = s;
		}

		@Override
		public int compareTo(Player o2) {
			return this.score == o2.score ? this.id - o2.id : this.score - o2.score;
		}
	}

	Map<Integer, Integer> idToScore = new HashMap<>();
	TreeSet<Player> set = new TreeSet<>();

	public void addScore(int playerId, int score) {
		Integer s = idToScore.get(playerId);

		if (s == null) {
			idToScore.put(playerId, score);
			Player p = new Player(playerId, score);
			set.add(p);
		} else {
			Player p = new Player(playerId, s);
			set.remove(p);

			p.score += score;
			set.add(p);
		}
	}

	public int top(int K) {
		int sum = 0;
		Player current = set.last();
		int count = 0;
		while (current != null && count < K) {
			sum += current.score;
			current = set.lower(current);
			count++;
		}
		return sum;
	}

	public void reset(int playerId) {
		Integer s = idToScore.get(playerId);
		if (s != null) {
			Player p = new Player(playerId, s);
			set.remove(p);
		}
		idToScore.remove(playerId);
	}

	public static void main(String[] args) {
		Leaderboard leaderboard = new Leaderboard();
		leaderboard.addScore(1, 73);   // leaderboard = [[1,73]];
		leaderboard.addScore(2, 56);   // leaderboard = [[1,73],[2,56]];
		leaderboard.addScore(3, 39);   // leaderboard = [[1,73],[2,56],[3,39]];
		leaderboard.addScore(4, 51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
		leaderboard.addScore(5, 4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
		System.out.println(leaderboard.top(1));           // returns 73;
		leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
		leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
		leaderboard.addScore(2, 51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
		System.out.println(leaderboard.top(3));           // returns 141 = 51 + 51 + 39;
	}
}
