import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NthDigitTest {
	NthDigit n = new NthDigit();
	int result;

	@Test
	public void test() {
		assertResult(2147483647, 2);
		assertResult(1000000000, 1);
		assertResult(1, 1);
		assertResult(2, 2);
		assertResult(3, 3);
		assertResult(4, 4);
		assertResult(5, 5);
		assertResult(6, 6);
		assertResult(7, 7);
		assertResult(10, 1);
		assertResult(11, 0);
		assertResult(12, 1);
		assertResult(13, 1);
		assertResult(14, 1);
		assertResult(15, 2);
		assertResult(190, 1);
		assertResult(191, 0);
		assertResult(192, 0);
		assertResult(193, 1);
		assertResult(194, 0);
		assertResult(195, 1);
		assertResult(196, 1);
	}

	private void assertResult(int input, int expected) {
		result = n.findNthDigit(input);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}
