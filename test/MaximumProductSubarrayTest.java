import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MaximumProductSubarrayTest {
	@Test
	public void test() {
		MaximumProductSubarray m = new MaximumProductSubarray();
		int result;
		result = m.maxProduct(new int[] {-2, 3, -4});
		Assert.assertThat(result, CoreMatchers.equalTo(24));

		result = m.maxProduct(new int[] {-4, -3, -2});
		Assert.assertThat(result, CoreMatchers.equalTo(12));
	}
}