import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CouplesHoldingHandTest {
	@Test
	public void test() {
		CouplesHoldingHand h = new CouplesHoldingHand();
		int result;

		result = h.minSwapsCouples(new int[] {5, 4, 2, 6, 3, 1, 0, 7});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = h.minSwapsCouples(new int[] {0, 3, 2, 5, 4, 7, 6, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(3));

		result = h.minSwapsCouples(new int[] {0, 2, 1, 3, 4, 5, 6, 7});
		Assert.assertThat(result, CoreMatchers.equalTo(1));
	}
}