import org.junit.Test;

public class MergingOverlappingIntervalsTest {
	@Test
	public void test() {
		int[][] pairs;

		pairs = new int[][] {{1, 3}, {2, 4}, {5, 7}, {6, 8}};
		MergingOverlappingIntervals.merge(pairs);

		pairs = new int[][] {{1, 3}, {3, 4}, {5, 7}, {6, 8}};
		MergingOverlappingIntervals.merge(pairs);

		pairs = new int[][] {{1, 2}, {3, 4}, {5, 7}, {6, 8}};
		MergingOverlappingIntervals.merge(pairs);

		pairs = new int[][] {{1, 2}, {5, 6}, {5, 7}, {6, 8}};
		MergingOverlappingIntervals.merge(pairs);

		pairs = new int[][] {{1, 2}, {5, 6}, {5, 7}, {6, 8}, {1, 5}};
		MergingOverlappingIntervals.merge(pairs);
	}
}