import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class IntervalSelection {
	public static class Interval {
		int start;
		int end;

		public Interval(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}

	public static class EndComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval a, Interval b) {
			return a.end - b.end;
		}
	}

	static int intervalSelection(int[][] intervals) {
		Queue<Interval> queue = new PriorityQueue<>(new EndComparator());
		for (int i = 0; i < intervals.length; i++) {
			queue.offer(new Interval(intervals[i][0], intervals[i][1]));
		}
		int count = 0;
		int latestEnd = 0;
		while (!queue.isEmpty()) {
			Interval current = queue.poll();
			if (latestEnd < current.start) {
				latestEnd = current.end;
				count++;
			}
		}

		if (count == intervals.length) {
			return count;
		} else {
			return count + 1;
		}
	}



}
