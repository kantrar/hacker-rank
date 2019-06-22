import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] answer = new int[nums.length];
		Arrays.fill(answer, 1);

		int prev = 1;
		for (int i = 0; i < nums.length; i++) {
			prev = nums[i] * prev;
			if (i + 1 < nums.length) {
				answer[i + 1] *= prev;
			}
		}

		int next = 1;
		for (int i = nums.length - 1; i > 0; i--) {
			next = nums[i] * next;
			answer[i - 1] *= next;
		}

		return answer;
	}
}
