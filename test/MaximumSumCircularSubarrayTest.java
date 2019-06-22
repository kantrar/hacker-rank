import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MaximumSumCircularSubarrayTest {
	@Test
	public void test() {
		MaximumSumCircularSubarray m = new MaximumSumCircularSubarray();
		int result;
//		result = m.maxSubarraySumCircular(new int[] {5, -3, 5});
//		Assert.assertThat(result, CoreMatchers.equalTo(10));
//
//		result = m.maxSubarraySumCircular(new int[] {1,-2,3,-2});
//		Assert.assertThat(result, CoreMatchers.equalTo(3));


		result = m.maxSubarraySumCircular(
				new int[] {88, -35, 50, -38, -60, -31, -2, -8, -8, 91, -14, 50, -25, -26, 1, 71, -91, -64, -40, 46, 30, -97, 9,
						-55, -36, -75, 71, 99, 90, -53, -68, -20, -73, 89, -14, 74, -8, 72, 82, 48, 45, 2, -42, 12, 77, 22, 87,
						56, 73, -21, 78, 15, -6, -75, 24, 46, -11, -70, -90, -77, 57, 43, -66, 10, -30, -47, 91, -37, -4, -67,
						-88, 19, 66, 29, 86, 97, -4, 67, 54, -92, -54, 71, -42, -17, 57, -91, -9, -15, -26, 56, -57, -58, -72, 91,
						-55, 35, -20, 29, 51, 70});

		Assert.assertThat(result, CoreMatchers.equalTo(810));
	}
}