public class BestTimeToBuyAndSellStockWithTransactionFee {
	public int maxProfit(int[] prices, int fee) {

		if (prices.length == 0) {
			return 0;
		}

		int prev = 0;
		int[] dpAll = new int[prices.length];

		for (int i = 1; i < prices.length; i++) {
			int temp = 0;
			int currentMax = 0;
			for (int j = 0; j < i; j++) {
				currentMax = Math.max(currentMax, prices[i] - prices[j] - fee + dpAll[j]);
				temp = Math.max(0, dpAll[j]);
			}
			prev = currentMax;
			dpAll[i] = Math.max(prev, temp);
		}

		return dpAll[prices.length - 1];
	}
}
