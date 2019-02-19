import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class XorAndSumTest {
	@Test
	public void testZeroB() {
		Assert.assertThat(XorAndSum.binarySum("1", "0", 314159), CoreMatchers.equalTo(314159));
		Assert.assertThat(XorAndSum.binarySum("10", "0", 314159), CoreMatchers.equalTo(314159 * 2));
		Assert.assertThat(XorAndSum.binarySum("10", "00", 314159), CoreMatchers.equalTo(314159 * 2));
		Assert.assertThat(XorAndSum.binarySum("110", "0", 314159), CoreMatchers.equalTo(314159 * 6));
		Assert.assertThat(XorAndSum.binarySum("1010", "0", 314159), CoreMatchers.equalTo(314159 * 10));
	}

	@Test
	public void testZeroA() {
		Assert.assertThat(XorAndSum.binarySum("0", "1", 4), CoreMatchers.equalTo((int) Math.pow(2, 4) - 1));
		Assert.assertThat(XorAndSum.binarySum("0", "10", 4), CoreMatchers.equalTo(2 * ((int) Math.pow(2, 4) - 1)));
		Assert.assertThat(XorAndSum.binarySum("0", "11", 4), CoreMatchers.equalTo(3 * ((int) Math.pow(2, 4) - 1)));
		Assert.assertThat(XorAndSum.binarySum("0", "11001", 4), CoreMatchers.equalTo(25 * ((int) Math.pow(2, 4) - 1)));
	}

	@Test
	public void testBase() {
		Assert.assertThat(XorAndSum.binarySum("10", "1", 10),
				CoreMatchers.equalTo(10 * 2 + 1 * ((int) Math.pow(2, 10) - 1) - 2 - 2 + 0));

		Assert.assertThat(XorAndSum.binarySum("10", "10", 10),
				CoreMatchers.equalTo(10 * 2 + 2 * ((int) Math.pow(2, 10) - 1) - 2 - 2 + 0));

		Assert.assertThat(XorAndSum.binarySum("10", "100", 10), CoreMatchers.equalTo(10 * 2 + 4 * ((int) Math.pow(2, 10) - 1)));
		Assert.assertThat(XorAndSum.binarySum("10", "1100", 10),
				CoreMatchers.equalTo(10 * 2 + 12 * ((int) Math.pow(2, 10) - 1)));
	}

	@Test
	public void testMixed() {
		Assert.assertThat(XorAndSum.binarySum("10", "101", 10),
				CoreMatchers.equalTo(10 * 2 + 5 * ((int) Math.pow(2, 10) - 1) - 2 - 10 + 8));

		Assert.assertThat(XorAndSum.binarySum("101", "101", 10),
				CoreMatchers.equalTo(10 * 5 + 5 * ((int) Math.pow(2, 10) - 1) - 5 - 5 + 0 - 5 - 20 + 17));

		Assert.assertThat(XorAndSum.binarySum("10", "1010", 10),
				CoreMatchers.equalTo(10 * 2 + 10 * ((int) Math.pow(2, 10) - 1) - 2 - 10 + 8));
	}

	@Test
	public void testComplex() {
		Assert.assertThat(XorAndSum.xorAndSum("10", "1010"), CoreMatchers.equalTo(489429555));
	}
}