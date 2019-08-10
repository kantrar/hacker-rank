import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class BestTimeToBuyAndSellStockWithTransactionFeeTest {
	@Test
	public void test() {
		BestTimeToBuyAndSellStockWithTransactionFee b = new BestTimeToBuyAndSellStockWithTransactionFee();
		int res;
		res = b.maxProfit(new int[] {}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = b.maxProfit(new int[] {1, 8}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(5));

		res = b.maxProfit(new int[] {1, 5, 10}, 0);
		Assert.assertThat(res, CoreMatchers.equalTo(9));

		res = b.maxProfit(new int[] {1, 5, 10}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(7));

		res = b.maxProfit(new int[] {1, 3, 2, 8}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(5));

		res = b.maxProfit(new int[] {1, 3, 2, 8}, 0);
		Assert.assertThat(res, CoreMatchers.equalTo(8));

		res = b.maxProfit(new int[] {1, 3, 2, 8, 4, 9}, 0);
		Assert.assertThat(res, CoreMatchers.equalTo(13));

		res = b.maxProfit(new int[] {1, 3, 2, 8, 4, 9}, 2);
		Assert.assertThat(res, CoreMatchers.equalTo(8));

	}
}