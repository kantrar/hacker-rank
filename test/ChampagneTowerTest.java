import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ChampagneTowerTest {
	@Test
	public void test() {
		ChampagneTower c = new ChampagneTower();
		double result;
		result = c.champagneTower(6, 3, 1);
		Assert.assertThat(result, Matchers.closeTo(0.25, 0.01));


		result = c.champagneTower(4, 2, 0);
		Assert.assertThat(result, Matchers.closeTo(0.25, 0.01));
	}
}