import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TargetSumTest {
	@Test
	public void test() {
		TargetSum t = new TargetSum();
		int result;
		result = t.findTargetSumWays(new int[] {1, 2, 3}, 0);
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = t.findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(5));

		result = t.findTargetSumWays(new int[] {0, 0, 1}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(4));

	}
}