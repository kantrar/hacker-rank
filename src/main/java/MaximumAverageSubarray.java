public class MaximumAverageSubarray {

	public double findMaxAverage(int[] nums, int k) {
		long sum = 0;
		double avg = 0.0;
		double maxAvg = -100000;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sum -= (i - k >= 0 ? nums[i - k] : 0);
			if (i >= k - 1) {
				avg = (double) sum / k;
				maxAvg = Math.max(maxAvg, avg);
			}
		}

		return maxAvg;
	}
}
