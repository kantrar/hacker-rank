public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {
		int[] count = new int[128];
		int unique = 0;
		for (char c : t.toCharArray()) {
			count[c]++;
			if (count[c] == 1) {
				unique++;
			}
		}
		int left = 0;
		int right = 0;
		int maxRight = s.length();
		int maxLeft = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			count[c]--;
			if (count[c] == 0) {
				unique--;
			}
			while (unique == 0 && left < right) {
				if (maxRight - maxLeft > right - left) {
					maxRight = right;
					maxLeft = left;
				}
				char leftChar = s.charAt(left);
				count[leftChar]++;
				if (count[leftChar] == 1) {
					unique++;
				}
				left++;
			}
			right++;
		}
		return s.substring(maxLeft, maxRight + 1);
	}
}
