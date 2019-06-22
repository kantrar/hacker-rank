import java.util.Arrays;

public class TotalHammingDistance {
	public int totalHammingDistance(int[] nums) {
		// 0100 -> 0 1 0 0
		// 1110 -> 1 1 1 0
		// 0010 -> 0 0 1 0
		//         2 2 2 0

		// 0, 0, 1, 1
		String[] input = new String[nums.length];
		int[] countOne = new int[32];
		Arrays.fill(countOne, 0);
		for (int i = 0; i < nums.length; i++) {
			input[i] = String.format("%32s", Integer.toBinaryString(nums[i])).replace(' ', '0');

			for (int j = 0; j < 32; j++) {
				countOne[j] += input[i].charAt(j) == '1' ? 1 : 0;
			}
		}

		int answer = 0;
		int n = nums.length;
		for (int i = 0; i < 32; i++) {
			answer += countOne[i] * (n - countOne[i]);
		}

		return answer;
	}
}
