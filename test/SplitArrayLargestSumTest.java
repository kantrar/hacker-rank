import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SplitArrayLargestSumTest {
	@Test
	public void test() {
		SplitArrayLargestSum s = new SplitArrayLargestSum();
		int result;
		result = s.splitArray(new int[] {3, 1, 2, 4, 3}, 4);
		Assert.assertThat(result, CoreMatchers.equalTo(4));

		result = s.splitArray(new int[] {2, 3, 1, 2, 4, 3}, 5);
		Assert.assertThat(result, CoreMatchers.equalTo(4));
	}
}