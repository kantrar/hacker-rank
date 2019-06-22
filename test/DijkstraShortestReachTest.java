import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class DijkstraShortestReachTest {
	@Test
	public void test() {
		int[] result;
		result = DijkstraShortestReach.shortestReach(4, new int[][] {{1, 2, 24}, {1, 4, 20}, {3, 1, 3}, {4, 3, 12}}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(24, 3, 15)));

		result = DijkstraShortestReach.shortestReach(5, new int[][] {{1, 2, 10}, {1, 3, 6}, {2, 4, 8}}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(10, 16, 8, -1)));

	}
}