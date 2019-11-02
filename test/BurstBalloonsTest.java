import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class BurstBalloonsTest {
	BurstBalloons b = new BurstBalloons();
	int result;

	@Test
	public void test() {
		result = b.maxCoins(new int[] {9, 76, 64});
		Assert.assertThat(result, CoreMatchers.equalTo(44416));

		result = b.maxCoins(new int[] {});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = b.maxCoins(new int[] {5});
		Assert.assertThat(result, CoreMatchers.equalTo(5));

		result = b.maxCoins(new int[] {5, 8});
		Assert.assertThat(result, CoreMatchers.equalTo(48));

		result = b.maxCoins(new int[] {3, 1, 5});
		Assert.assertThat(result, CoreMatchers.equalTo(35));

		result = b.maxCoins(new int[] {3, 1, 5, 8});
		Assert.assertThat(result, CoreMatchers.equalTo(167));

		result = b.maxCoins(new int[] {3, 4, 5, 6, 7});
		Assert.assertThat(result, CoreMatchers.equalTo(462));

	}
}
