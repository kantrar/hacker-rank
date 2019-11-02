package AlgoExpert;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MaxProfitWithKTransactionsTest {
	int res;

	@Test
	public void test() {
//		assertResult(new int[] {3, 50, 60, 90}, 2, 87);
		assertResult(new int[] {1, 25, 24, 23, 12, 36, 14, 40, 31, 41, 5}, 1, 40);
		assertResult(new int[] {1, 25, 24, 23, 12, 36, 14, 40, 31, 41, 5}, 2, 62);
	}

	private void assertResult(int[] prices, int k, int expected) {
		res = MaxProfitWithKTransactions.maxProfitWithKTransactions(prices, k);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}
