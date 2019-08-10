import java.util.Arrays;

public class LastStoneWeightsII {
	public int lastStoneWeightII(int[] stones) {
		Arrays.sort(stones);
		int target = 0;
		int sum = 0;
		for (int value : stones) {
			sum += value;
		}
		target = sum / 2;

		boolean[] dp = new boolean[target + 1];
		dp[0] = true;
		int max = 0;
		for (int stone : stones) {
			for (int i = target; i >= 0; i--) {
				dp[i] = i - stone >= 0 ? (dp[i - stone] | dp[i]) : dp[i];
				max = dp[i] ? Math.max(i, max) : max;
			}
		}
		return sum - max - max;
	}
}
