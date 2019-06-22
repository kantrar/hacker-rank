import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSums {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> answer = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}

				List<Integer> current = new ArrayList<>();
				current.add(nums[i]);
				current.add(nums[j]);
				twoSum(nums, j + 1, target - nums[i] - nums[j], answer, current);
			}
		}

		return answer;
	}

	public void twoSum(int[] nums, int pos, int target, List<List<Integer>> answer, List<Integer> current) {
		int left = pos;
		int right = nums.length - 1;

		while (left < right) {
			if (nums[left] + nums[right] == target) {
				answer.add(new ArrayList<>(current));
				answer.get(answer.size() - 1).add(nums[left]);
				answer.get(answer.size() - 1).add(nums[right]);
				left++;
				right--;
				while (left < right && nums[left] == nums[left - 1]) {
					left++;
				}
				while (left < right && nums[right] == nums[right + 1]) {
					right--;
				}
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else {
				right--;
			}
		}
	}
}
