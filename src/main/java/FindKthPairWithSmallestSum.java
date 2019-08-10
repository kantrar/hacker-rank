import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindKthPairWithSmallestSum {

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		return Collections.emptyList();
	}

	// this solution is to find kth smallest pairs with minimum difference between pairs, which is not the goal of the question.
		public List<List<Integer>> kSmallestPairsDiff(int[] nums1, int[] nums2, int k) {
			if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k < 0) {
				return Collections.emptyList();
			}

			int min = 0;
			int max = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]) - Math.min(nums1[0], nums2[0]);

			while (min <= max) {
				int mid = min + (max - min) / 2;
				int v = count(nums1, nums2, mid);
				if (v >= k) {
					max = mid - 1;
				} else {
					min = mid + 1;
				}
			}

			List<List<Integer>> ans = new ArrayList<>();
			int targetSum = min;
			int start = 0;
			int end = 0;
			for (int i = 0; i < nums1.length; i++) {
				while (end < nums2.length && nums2[end] - nums1[i] <= targetSum ) {
					end++;
				}
				while (start < end && nums1[i] - nums2[start] > targetSum) {
					start++;
				}
				for (int j = start; j < end; j++) {
					ans.add(Arrays.asList(nums1[i], nums2[j]));
				}
			}

			return ans;
		}

		private int count(int[] nums1, int[] nums2, int targetSum) {
			int start = 0;
			int end = 0;
			int ans = 0;
			for (int i = 0; i < nums1.length; i++) {
				while (end < nums2.length && nums2[end] - nums1[i] <= targetSum ) {
					end++;
				}
				while (start < end && nums1[i] - nums2[start] > targetSum) {
					start++;
				}
				ans += (end - start);
			}
			return ans;
		}
}
