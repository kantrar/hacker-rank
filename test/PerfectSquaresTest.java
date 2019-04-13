import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PerfectSquaresTest {
	@Test
	public void test() {
		PerfectSquares p = new PerfectSquares();
		int result = p.numSquares(12);
		Assert.assertThat(result, CoreMatchers.equalTo(3));
	}
}