import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ChampagneTower {

	public class Tower {
		Integer row;
		Integer col;
		double vol;

		public Tower(int r, int c, double v) {
			this.row = r;
			this.col = c;
			this.vol = v;
		}
	}

	public double champagneTower(int poured, int query_row, int query_glass) {
		Queue<Tower> queue = new LinkedList<>();
		Map<String, Tower> map = new HashMap<>();
		Tower t = new Tower(0, 0, poured);
		queue.offer(t);
		map.put(key(0, 0), t);

		if (query_row == 0 && query_glass == 0) {
			return poured > 1 ? 1 : poured;
		}

		double total = 0;

		while (!queue.isEmpty()) {
			Tower current = queue.poll();
			if (current.vol > 1) {
				double excess = (current.vol - 1) / 2.0;
				if (query_row == (current.row + 1) && (query_glass == current.col || query_glass == current.col + 1)) {
					total += (excess > 1 ? 1 : excess);
					if (total > 0.9999999) {
						return 1.0;
					}
					continue;
				}

				if (query_row < (current.row + 1)) {
					continue;
				}

				if (excess > 0) {
					if (map.containsKey(key(current.row + 1, current.col))) {
						Tower next = map.get(key(current.row + 1, current.col));
						next.vol += excess;
					} else {
						Tower next = new Tower(current.row + 1, current.col, excess);
						queue.offer(next);
						map.put(key(current.row + 1, current.col), next);
					}
					if (map.containsKey(key(current.row + 1, current.col + 1))) {
						Tower next = map.get(key(current.row + 1, current.col + 1));
						next.vol += excess;
					} else {
						Tower next = new Tower(current.row + 1, current.col + 1, excess);
						queue.offer(next);
						map.put(key(current.row + 1, current.col + 1), next);
					}
				}

				current.vol = 1;
			}
		}

		return total;
	}

	private String key(int row, int col) {
		return String.format("%d-%d", row, col);
	}
}
