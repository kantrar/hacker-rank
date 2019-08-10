import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CountNumbersWithUniqueDigitsTest {
	CountNumbersWithUniqueDigits c = new CountNumbersWithUniqueDigits();
	int res;

	@Test
	public void test() {
		assertResult(0, 1);
		assertResult(1, 10);
		assertResult(2, 91);
		assertResult(3, 91 + 9 * 9 * 8);
		assertResult(4, 91 + 9 * 9 * 8 + 9 * 9 * 8 * 7);
	}

	private void assertResult(int input, int expected) {
		res = c.countNumbersWithUniqueDigits(input);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}