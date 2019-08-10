import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class IntegerBreakTest {
		IntegerBreak i = new IntegerBreak();
	@Test
	public void test() {
		assertResult(2, 1);
		assertResult(3, 2);
		assertResult(4, 4);
		assertResult(5, 6);
		assertResult(6, 9);
		assertResult(7, 12);
		assertResult(10, 36);
	}

	private void assertResult(int input, int expected) {
		int res = i.integerBreak(input);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}