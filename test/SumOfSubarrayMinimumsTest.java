import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SumOfSubarrayMinimumsTest {
	@Test
	public void test() {
		SumOfSubarrayMinimums s = new SumOfSubarrayMinimums();
		int result;
		result = s.sumSubarrayMins(new int[] {10, 5, 3, 7, 0});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = s.sumSubarrayMins(new int[] {71, 55, 82, 55});
		Assert.assertThat(result, CoreMatchers.equalTo(593));

	}
}