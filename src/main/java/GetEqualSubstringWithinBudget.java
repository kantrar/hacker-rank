public class GetEqualSubstringWithinBudget {
	public int equalSubstring(String s, String t, int maxCost) {
		int N = Math.min(s.length(), t.length());
		int left = 0;
		int right = 0;
		int sumCost = 0;
		int maxLength = 0;
		while (right < N) {
			int diff = Math.abs(s.charAt(right) - t.charAt(right));
			if (diff > maxCost) {
				right++;
				left = right;
				sumCost = 0;
				continue;
			}
			sumCost += diff;
			while (sumCost > maxCost) {
				sumCost -= Math.abs(s.charAt(left) - t.charAt(left));
				left++;
			}
			maxLength = Math.max(maxLength, right - left + 1);
			right++;
		}
		return maxLength;
	}
}
