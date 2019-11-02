import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MaxSumOfThreeSubarraysTest {
	@Test
	public void test() {
		MaxSumOfThreeSubarrays m = new MaxSumOfThreeSubarrays();
		int[] result;
		result = m.maxSumOfThreeSubarrays(new int[] {1, 2, 1, 2, 6, 7, 5, 1}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0,3,5}));
	}
}
