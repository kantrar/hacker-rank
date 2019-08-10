import java.util.Arrays;

public class IncreasingTripletSubsequence {

	public boolean increasingTriplet(int[] nums) {
		if (nums.length < 3) {
			return false;
		}

		int currentCount = 0;
		int[] min = new int[3];
		Arrays.fill(min, Integer.MAX_VALUE);
		int temp = Integer.MAX_VALUE;
		boolean mightStart = false;

		for (int i = 0; i < nums.length; i++) {
			if (min[currentCount] > nums[i]) {
				if (currentCount == 2 && nums[i] > min[1]) {
					return true;
				}
				if (mightStart == true && nums[i] > temp) {
					mightStart = false;
					min[0] = temp;
					min[1] = nums[i];
					currentCount = 2;
					continue;
				}

				if (currentCount == 2 && nums[i] <= min[1] && nums[i] > min[0]) {
					min[1] = nums[i];
				} else if (currentCount == 2 && nums[i] <= min[1] && nums[i] <= min[0]) {
					temp = nums[i];
					mightStart = true;
				} else if (currentCount == 1 && nums[i] > min[0]) {
					min[1] = nums[i];
					currentCount++;
				} else if (currentCount == 1 && nums[i] <= min[0]) {
					min[0] = nums[i];
				} else {
					min[0] = nums[i];
					currentCount++;
				}
			}
		}

		return false;
	}

}
