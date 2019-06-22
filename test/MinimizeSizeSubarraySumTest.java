import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MinimizeSizeSubarraySumTest {
	@Test
	public void test() {
		MinimizeSizeSubarraySum m = new MinimizeSizeSubarraySum();
		int result = m.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(2));
	}
}