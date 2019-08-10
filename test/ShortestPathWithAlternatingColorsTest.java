import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ShortestPathWithAlternatingColorsTest {
	@Test
	public void test() {
		ShortestPathWithAlternatingColors s = new ShortestPathWithAlternatingColors();
		int[] result;
		result = s.shortestAlternatingPaths(3, new int[][] {{0, 1}, {0, 2}}, new int[][] {{1, 0}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 1, 1}));

		result = s.shortestAlternatingPaths(5, new int[][] {{1, 4}, {0, 3}}, new int[][] {{3, 1}, {3, 4}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 2, -1, 1, 2}));

				result = s
						.shortestAlternatingPaths(5, new int[][] {{2, 2}, {0, 1}, {0, 3}, {0, 0}, {0, 4}, {2, 1}, {2, 0}, {1,
		 4}, {3,
										4}},
								new int[][] {{1, 3}, {0, 0}, {0, 3}, {4, 2}, {1, 0}});
				Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 1, 2, 1, 1}));

		result = s.shortestAlternatingPaths(3, new int[][] {{0, 1}, {1, 2}}, new int[][] {});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 1, -1}));

		result = s.shortestAlternatingPaths(3, new int[][] {{0, 1}}, new int[][] {{2, 1}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 1, -1}));

		result = s.shortestAlternatingPaths(3, new int[][] {{1, 0}}, new int[][] {{2, 1}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, -1, -1}));

		result = s.shortestAlternatingPaths(3, new int[][] {{0, 1}}, new int[][] {{1, 2}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 1, 2}));

		result = s.shortestAlternatingPaths(4, new int[][] {{0, 1}, {2, 2}}, new int[][] {{1, 2}, {2, 3}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 1, 2, 4}));

		result = s.shortestAlternatingPaths(4, new int[][] {{0, 1}, {2, 2}}, new int[][] {{1, 2}, {2, 3}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 1, 2, 4}));

		result = s.shortestAlternatingPaths(5, new int[][] {{0, 1}, {2, 2}, {3, 0}}, new int[][] {{1, 2}, {2, 3}, {0, 4}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 1, 2, 4, 1}));

		result = s.shortestAlternatingPaths(5, new int[][] {{0, 1}, {2, 2}, {3, 2}}, new int[][] {{1, 2}, {2, 3}, {2, 4}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 1, 2, 4, 4}));

		result = s.shortestAlternatingPaths(5, new int[][] {{0, 1}, {2, 2}, {3, 0}}, new int[][] {{1, 2}, {2, 3}, {0, 1}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 1, 2, 4, -1}));
	}
}