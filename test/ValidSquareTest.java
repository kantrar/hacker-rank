import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ValidSquareTest {
	@Test
	public void test() {
		ValidSquare v = new ValidSquare();
		boolean result;
		result = v.validSquare(new int[] {1, 0}, new int[] {-1, 0}, new int[] {0, 1}, new int[] {0, -1});
		Assert.assertThat(result, CoreMatchers.equalTo(true));
		result = v.validSquare(new int[] {0, 0}, new int[] {1, 1}, new int[] {1, 0}, new int[] {0, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(true));

	}
}