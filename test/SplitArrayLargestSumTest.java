import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SplitArrayLargestSumTest {
	@Test
	public void test() {
		SplitArrayLargestSum s = new SplitArrayLargestSum();
		int result;

		result = s.splitArray(new int[] {10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(137));

		result = s.splitArray(new int[] {10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(74));

		result = s.splitArray(new int[] {10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(50));

		result = s.splitArray(new int[] {10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8}, 8);
		Assert.assertThat(result, CoreMatchers.equalTo(25));

		result = s.splitArray(new int[] {7, 2, 5, 10, 8}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(18));

		result = s.splitArray(new int[] {}, 0);
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = s.splitArray(new int[] {1, Integer.MAX_VALUE}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(Integer.MAX_VALUE));

		result = s.splitArray(new int[] {1, 4, 4}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(4));

		result = s.splitArray(new int[] {3, 1, 2, 4, 3}, 4);
		Assert.assertThat(result, CoreMatchers.equalTo(4));

		result = s.splitArray(new int[] {2, 3, 1, 2, 4, 3}, 5);
		Assert.assertThat(result, CoreMatchers.equalTo(4));
	}
}
