import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrayManipulation {

	static long arrayManipulation(int n, int[][] queries) {
		int[] sum = new int[n + 2];

		// O(K)
		for (int[] query : queries) {
			sum[query[0]] += query[2];
			sum[query[1] + 1] += -query[2];
		}

		// O(N)g
		long max = 0;
		long s = 0;
		for (int i = 1; i <= n; i++) {
			s += sum[i];
			if (s > max) {
				max = s;
			}
		}

		return max;
	}

	private static class Range {
		private int start;
		private int end;
		private int value;
		private boolean used;

		public Range(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
			this.used = false;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}
	}

	static long arrayManipulation3(int n, int[][] queries) {
		long[] answers = new long[n + 1];
		long max = 0;

		List<Range> list = new ArrayList<>();

		List<Integer> points = new ArrayList<>();

		// O(K)
		for (int[] query : queries) {

			if (!points.contains(query[0])) {
				points.add(query[0]);
			}
			if (!points.contains(query[1])) {
				points.add(query[1]);
			}

			Range range = new Range(query[0], query[1], query[2]);
			list.add(range);
		}

		// O(KlogK)
		Collections.sort(points);
		// O(KlogK)
		Collections.sort(list, Comparator.comparingInt(Range::getStart).thenComparingInt(Range::getEnd));

		// O(K)
		int sum = 0;
		for (Integer point : points) {

			Iterator<Range> iterator = list.iterator();
			while (iterator.hasNext()) {
				Range range = iterator.next();

				if (range.end < point) {
					sum -= range.value;
					iterator.remove();
					continue;
				}

				if (range.start <= point && range.end >= point) {
					if (!range.used) {
						sum += range.value;
						if (sum > max) {
							max = sum;
						}
						range.used = true;
					}

				} else if (range.start > point) {
					break;
				}

			}
		}
		return max;
	}

	static long arrayManipulation2(int n, int[][] queries) {
		long[] answers = new long[n + 1];
		long max = 0;

		// O(NK)
		for (int[] query : queries) {
			int start = query[0];
			int end = query[1];
			int value = query[2];
			for (int j = start; j <= end; j++) {
				answers[j] += value;
				if (max < answers[j]) {
					max = answers[j];
				}
			}
		}
		return max;
	}
}
