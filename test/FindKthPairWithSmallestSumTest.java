import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class FindKthPairWithSmallestSumTest {
	@Test
	public void test() {
		FindKthPairWithSmallestSum f = new FindKthPairWithSmallestSum();
		List<List<Integer>> result;
		result = f.kSmallestPairsDiff(new int[] {1}, new int[] {2}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(Arrays.asList(1, 2))));

		result = f.kSmallestPairsDiff(new int[] {1}, new int[] {2}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(Arrays.asList(1, 2))));

		result = f.kSmallestPairsDiff(new int[] {1}, new int[] {2, 5}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(Arrays.asList(1, 2))));

		result = f.kSmallestPairsDiff(new int[] {2, 5}, new int[] {1}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(Arrays.asList(2, 1))));

		result = f.kSmallestPairsDiff(new int[] {1}, new int[] {2, 5}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 5))));

		result = f.kSmallestPairsDiff(new int[] {2, 5}, new int[] {1}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(Arrays.asList(2, 1), Arrays.asList(5, 1))));

		result = f.kSmallestPairsDiff(new int[] {2, 5}, new int[] {1, 3}, 4);
		Assert.assertThat(result, CoreMatchers
				.equalTo(Arrays.asList(Arrays.asList(2, 1), Arrays.asList(2, 3), Arrays.asList(5, 1), Arrays.asList(5, 3))));

		result = f.kSmallestPairsDiff(new int[] {2, 5}, new int[] {1, 3}, 3);
		Assert.assertThat(result,
				CoreMatchers.equalTo(Arrays.asList(Arrays.asList(2, 1), Arrays.asList(2, 3), Arrays.asList(5, 3))));

		result = f.kSmallestPairsDiff(new int[] {1, 7, 11}, new int[] {2, 4, 6}, 3);
		Assert.assertThat(result,
				CoreMatchers.equalTo(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 4), Arrays.asList(1, 6))));

		result = f.kSmallestPairsDiff(new int[] {1, 1, 2}, new int[] {1, 2, 3}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(Arrays.asList(1, 1), Arrays.asList(1, 1))));

		result = f.kSmallestPairsDiff(new int[] {1, 2}, new int[] {3}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(2, 3))));
	}
}