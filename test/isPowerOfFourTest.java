import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class isPowerOfFourTest {
	@Test
	public void test() {
		isPowerOfFour i = new isPowerOfFour();

		boolean res = i.isPowerOfFour(4);
		Assert.assertThat(res, CoreMatchers.equalTo(true));

		res = i.isPowerOfFour(5);
		Assert.assertThat(res, CoreMatchers.equalTo(false));

		res = i.isPowerOfFour(16);
		Assert.assertThat(res, CoreMatchers.equalTo(true));
	}
}