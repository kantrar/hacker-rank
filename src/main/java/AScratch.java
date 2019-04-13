import java.util.Comparator;
import java.util.PriorityQueue;

public class AScratch {

	private static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}
	}

	public static void main(String[] args) {
		PriorityQueue<Interval> objects = new PriorityQueue<>(Comparator.comparingInt(Interval::getStart));
		objects.add(new Interval(1, 5));
		objects.add(new Interval(1, 5));
		System.out.println(objects.size());

	}
}
