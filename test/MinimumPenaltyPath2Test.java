import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MinimumPenaltyPath2Test {
	@Test
	public void test() {
		int result = MinimumPenaltyPath2.beautifulPath(3, new int[][] {{1, 2, 1}, {1, 2, 1000}, {2, 3, 3}, {1, 3, 100}}, 1, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(3));
	}
}