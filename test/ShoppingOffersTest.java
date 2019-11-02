import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ShoppingOffersTest {
	@Test
	public void test() {
		ShoppingOffers s = new ShoppingOffers();
		int res;
		res = s.shoppingOffers(Arrays.asList(2, 5), Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10)),
				Arrays.asList(3, 2));
		Assert.assertThat(res, CoreMatchers.equalTo(14));
	}
}
