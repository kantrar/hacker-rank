import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ArithmeticSlicesIISubsequenceTest {
	@Test
	public void test() {
		ArithmeticSlicesIISubsequence a = new ArithmeticSlicesIISubsequence();
		int result;

		result = a.numberOfArithmeticSlices(new int[] {2, 4, 6, 8, 10});
		Assert.assertThat(result, CoreMatchers.equalTo(7));

		result = a.numberOfArithmeticSlices(new int[] {2, 2, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = a.numberOfArithmeticSlices(new int[] {0, 1, 2, 2, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(4));
	}
}