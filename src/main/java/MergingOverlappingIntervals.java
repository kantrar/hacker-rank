import java.util.Arrays;
import java.util.Comparator;

public class MergingOverlappingIntervals {
	public static class DisjointSet {
		int start;
		int end;

		public DisjointSet(int s, int e) {
			this.start = s;
			this.end = e;
		}

		public int getStart() {
			return this.start;
		}
	}

	public static void merge(int[][] pairs) {
		DisjointSet[] disjointSets = new DisjointSet[pairs.length];

		int idx = 0;
		for (int i = 0; i < pairs.length; i++) {
			int first = pairs[i][0];
			int second = pairs[i][1];
			int min = Math.min(first, second);
			int max = Math.max(first, second);

			disjointSets[idx++] = new DisjointSet(min, max);
		}

		Arrays.sort(disjointSets, Comparator.comparingInt(DisjointSet::getStart));

		DisjointSet[] answers = new DisjointSet[pairs.length];
		int answerIdx = 0;
		answers[answerIdx] = disjointSets[0];
		for (int i = 1; i < idx; i++) {
			if (answers[answerIdx].end >= disjointSets[i].start) {
				answers[answerIdx].end = disjointSets[i].end;
			} else {
				answers[++answerIdx] = disjointSets[i];
			}
		}

		for (int i = 0; i <= answerIdx; i++) {
			System.out.print("[" + answers[i].start + ", " + answers[i].end + "]");
		}

		System.out.println();
	}
}
