import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PerfectSquares2Test {
	@Test
	public void test() {
		PerfectSquares2 p = new PerfectSquares2();
		int result = p.numSquares(5);
		Assert.assertThat(result, CoreMatchers.equalTo(2));
	}
}