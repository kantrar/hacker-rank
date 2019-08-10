import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NumberAtMostNGiveNDigitSetTest {
	@Test
	public void test() {
		NumberAtMostNGiveNDigitSet n = new NumberAtMostNGiveNDigitSet();
		int res;

		res = n.atMostNGivenDigitSet(new String[] {"1", "4", "9"}, 1000000000);
		Assert.assertThat(res, CoreMatchers.equalTo(29523));

		res = n.atMostNGivenDigitSet(new String[] {"1", "4", "9"}, 2345);
		Assert.assertThat(res, CoreMatchers.equalTo(66));

		res = n.atMostNGivenDigitSet(new String[] {"1", "2", "3"}, 5);
		Assert.assertThat(res, CoreMatchers.equalTo(3));

		res = n.atMostNGivenDigitSet(new String[] {"1", "2", "3"}, 10);
		Assert.assertThat(res, CoreMatchers.equalTo(3));

		res = n.atMostNGivenDigitSet(new String[] {"1", "2", "3"}, 15);
		Assert.assertThat(res, CoreMatchers.equalTo(6));

		res = n.atMostNGivenDigitSet(new String[] {"1", "2", "3"}, 25);
		Assert.assertThat(res, CoreMatchers.equalTo(9));

		res = n.atMostNGivenDigitSet(new String[] {"1", "4", "9"}, 25);
		Assert.assertThat(res, CoreMatchers.equalTo(6));

	}
}