import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NonNegativeIntegersWithoutConsecutiveOnesTest {
	NonNegativeIntegersWithoutConsecutiveOnes n;
	int result;

	@Test
	public void test() {
		n = new NonNegativeIntegersWithoutConsecutiveOnes();
		assertResult(5, 5);
		assertResult(6, 5);
		assertResult(16, 9);
	}

	private void assertResult(int input, int expected) {
		result = n.findIntegers(input);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}