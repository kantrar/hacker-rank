public class MaximumEqualsFrequency {
	int MAX = 100001;

	public int maxEqualFreq(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] count = new int[MAX];
		int[] freq = new int[MAX];
		count[nums[0]] = 1;
		freq[count[nums[0]]]++;
		int res = 1;
		for (int i = 1; i < nums.length; i++) {
			if (freq[count[nums[i - 1]]] * count[nums[i - 1]] == i) {
				res = i + 1;
			}
			freq[count[nums[i]]]--;
			count[nums[i]]++;
			freq[count[nums[i]]]++;

			int d = i + 1 - freq[count[nums[i]]] * count[nums[i]];
			if ((d == 1 || d == count[nums[i]] + 1) && freq[d] == 1) {
				res = i + 1;
			}
		}
		return res;
	}
}
