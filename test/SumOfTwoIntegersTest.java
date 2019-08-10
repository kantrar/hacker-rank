import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SumOfTwoIntegersTest {
	@Test
	public void test() {
		SumOfTwoIntegers s = new SumOfTwoIntegers();
		int res = s.getSum(30, 10);
		Assert.assertThat(res, CoreMatchers.equalTo(40));
	}
}