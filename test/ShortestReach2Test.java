import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ShortestReach2Test {
	@Test
	public void test() {
		int[] result;

		result = ShortestReach2.shortestReach(4, new int[][] {{1, 2, 24}, {1, 4, 20}, {3, 1, 3}, {4, 3, 12}}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {24, 3, 15}));

		result = ShortestReach2.shortestReach(5, new int[][] {{1, 2, 10}, {1, 3, 6}, {2, 4, 8}}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {10, 16, 8, -1}));

		result = ShortestReach2
				.shortestReach(6, new int[][] {{1, 2, 1}, {1, 3, 3}, {2, 4, 3}, {3, 4, 2}, {3, 5, 4}, {4, 5, 1}}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 3, 4, 5, -1}));

		result = ShortestReach2
				.shortestReach(6, new int[][] {{1, 2, 1}, {1, 3, 3}, {2, 4, 3}, {3, 4, 2}, {3, 5, 4}, {4, 5, 1}}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 4, 3, 4, -1}));

		result = ShortestReach2.shortestReach(3, new int[][] {{1, 2, 3}, {1, 2, 4}, {1, 2, 1}, {1, 2, 2}}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, -1}));

		result = ShortestReach2.shortestReach(3, new int[][] {{1, 2, 3}, {1, 2, 4}, {2, 1, 1}, {1, 2, 2}}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, -1}));

		result = ShortestReach2
				.shortestReach(4, new int[][] {{1, 2, 3}, {1, 3, 4}, {2, 1, 1}, {1, 2, 2}, {3, 1, 3}, {3, 1, 2}, {3, 1, 1}}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 1, -1}));

		result = ShortestReach2
				.shortestReach(4, new int[][] {{1, 2, 3}, {1, 3, 4}, {2, 1, 1}, {1, 2, 2}, {3, 1, 3}, {3, 1, 2}, {3, 1, 1}}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 2, -1}));

		result = ShortestReach2
				.shortestReach(4, new int[][] {{1, 2, 3}, {1, 3, 4}, {2, 1, 1}, {1, 2, 2}, {3, 1, 3}, {3, 1, 2}, {3, 1, 1}}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 2, -1}));

		result = ShortestReach2.shortestReach(3, new int[][] {{1, 2, 2}, {1, 2, 1}, {1, 3, 3}, {2, 3, 4}}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 3}));

		result = ShortestReach2.shortestReach(3, new int[][] {{1, 2, 2}, {1, 2, 1}, {1, 3, 3}, {2, 3, 4}}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 4}));
	}
}