import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SumOfDistancesInTreeTest {
	@Test
	public void test() {
		SumOfDistancesInTree s = new SumOfDistancesInTree();
		int[] result;

		result = s.sumOfDistancesInTree(1, null);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0}));

		result = s.sumOfDistancesInTree(1, new int[][] {});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0}));

		result = s.sumOfDistancesInTree(2, new int[][] {{0, 1}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 1}));

		result = s.sumOfDistancesInTree(3, new int[][] {{0, 1}, {0, 2}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {2, 3, 3}));

		result = s.sumOfDistancesInTree(4, new int[][] {{0, 1}, {1, 2}, {1, 3}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {5, 3, 5, 5}));

		result = s.sumOfDistancesInTree(4, new int[][] {{0, 1}, {0, 2}, {0, 3}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {3, 5, 5, 5}));

		result = s.sumOfDistancesInTree(4, new int[][] {{0, 1}, {1, 2}, {2, 3}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {6, 4, 4, 6}));

		result = s.sumOfDistancesInTree(6, new int[][] {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {8, 12, 6, 10, 10, 10}));

		result = s.sumOfDistancesInTree(9, new int[][] {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {3, 5}, {3, 6}, {6, 7}, {6, 8}});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {22, 15, 22, 12, 19, 19, 15, 22, 22}));
	}
}
