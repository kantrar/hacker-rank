import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MaximumPointsTest {
	@Test
	public void test() {
		int result;
		result = MaximumPoints.maximumPoints(new int[] {1, 2, 1, 3, 2, 2, 2, 2, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(10));

		result = MaximumPoints.maximumPoints(new int[] {1, 2, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(4));

		result = MaximumPoints.maximumPoints(new int[] {1, 5, 7});
		Assert.assertThat(result, CoreMatchers.equalTo(13));

		result = MaximumPoints.maximumPoints(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(18));

		result = MaximumPoints.maximumPoints(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(24));

		result = MaximumPoints.maximumPoints(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(20));

		result = MaximumPoints
				.maximumPoints(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(24));

		result = MaximumPoints
				.maximumPoints(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(24));

		result = MaximumPoints.maximumPoints(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(21));

		result = MaximumPoints.maximumPoints(new int[] {1, 1, 2, 2, 2, 2, 2, 3, 3, 4, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(18));
	}
}