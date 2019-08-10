import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class GuessNumberHigherOrLowerIITest {
	@Test
	public void test() {
		GuessNumberHigherOrLowerII g = new GuessNumberHigherOrLowerII();
		int res = g.getMoneyAmount(10);
		Assert.assertThat(res, CoreMatchers.equalTo(16));

		res = g.getMoneyAmount(12);
		Assert.assertThat(res, CoreMatchers.equalTo(21));
	}
}