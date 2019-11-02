import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MaximumSumOf3NonOverlappingSubarraysTest {
	@Test
	public void test() {
		MaximumSumOf3NonOverlappingSubarrays m = new MaximumSumOf3NonOverlappingSubarrays();
		int[] result;
		result = m.maxSumOfThreeSubarrays(new int[] {1, 2, 1, 2, 1, 2, 1, 2, 1}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 2, 4}));

		result = m.maxSumOfThreeSubarrays(new int[] {1, 2, 1, 2, 6, 7, 5, 1}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 3, 5}));

		result = m.maxSumOfThreeSubarrays(new int[] {4, 3, 2, 1}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {0, 1, 2}));

	}
}
