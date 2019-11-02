import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MinNumberOfPowersOfTwoToGetAnIntegerTest {
		MinNumberOfPowersOfTwoToGetAnInteger m = new MinNumberOfPowersOfTwoToGetAnInteger();
		int res;
	@Test
	public void test() {
		assertResult(0, 0);
		assertResult(1, 1);
		assertResult(2, 1);
		assertResult(3, 2);
		assertResult(4, 1);
		assertResult(5, 2);
		assertResult(6, 2);
		assertResult(7, 2);
		assertResult(8, 1);
		assertResult(9, 2);
		assertResult(10, 2);
		assertResult(119, 3);
		assertResult(208, 3);
	}

	private void assertResult(int input, int expected) {
		res = m.minNumber(input);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}
