public class StockMaximize {
static long stockmax(long[] prices) {
      long answer = 0 ;
      long[] max = new long[prices.length];

      max[prices.length - 1] = prices[prices.length - 1];

      for (int i = prices.length - 2; i >= 0; i--) {

          
        max[i] = Math.max(prices[i], max[i + 1]);
        
      }

      for (int i = 0; i < prices.length - 1; i++) {
        answer += maximize(prices, i + 1, prices[i], max);
        System.out.println(maximize(prices, i + 1, prices[i], max));
      }

      return answer;
    }

    static long maximize(long[] prices, int pos, long boughtPrice, long[] max) {
      if (pos >= prices.length) {
        return 0;
      }

      if (boughtPrice > max[pos]) {
        return 0;
      } else {
        return max[pos] - boughtPrice;
      }
    }
}
