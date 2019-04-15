import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ShortestSubarrayWithSumAtLeastKTest {
	@Test
	public void test() {
		int result;
		ShortestSubarrayWithSumAtLeastK c = new ShortestSubarrayWithSumAtLeastK();

		result = c.shortestSubarray(
				new int[] {-34, 37, 51, 3, -12, -50, 51, 100, -47, 99, 34, 14, -13, 89, 31, -14, -44, 23, -38, 6}, 151);
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = c.shortestSubarray(new int[] {2, -1, 2, 0, 0, 1, 2}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = c.shortestSubarray(new int[] {3, 1, 3, -2, 4, 0, 1}, 5);
		Assert.assertThat(result, CoreMatchers.equalTo(2));
	}
}