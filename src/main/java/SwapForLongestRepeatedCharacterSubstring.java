public class SwapForLongestRepeatedCharacterSubstring {
	public int maxRepOpt1(String text) {
		if (text == null || text.length() <= 1) {
			return text == null ? 0 : text.length();
		}

		char prev = 0;

		int[] count = new int[128];

		char charAnswer = text.charAt(0);
		int[] maxSequence = new int[128];
		int currentSequence = 1;
		int longestSequence = 1;
		for (int i = 0; i < text.length(); i++) {
			count[text.charAt(i)]++;

			if (i == 0 && text.charAt(i) != text.charAt(i + 1)) {
				int j = i + 2;
				while (j < text.length() && text.charAt(j) == text.charAt(i + 1)) {
					j++;
				}
				if (j - i - 2 > maxSequence[charAnswer]) {
					charAnswer = text.charAt(i + 1);
					maxSequence[charAnswer] = j - i - 2;
				}
			} else if (i == text.length() - 1 && text.charAt(i) != text.charAt(i - 1)) {
				int j = i - 2;
				while (j >= 0 && text.charAt(j) == text.charAt(i - 1)) {
					j++;
				}
				if (i - j - 2 > maxSequence[charAnswer]) {
					charAnswer = text.charAt(i - 1);
					maxSequence[charAnswer] = i - j - 2;
				}
			} else if (i != 0 && i != text.length() - 1 && text.charAt(i - 1) == text.charAt(i + 1) && text.charAt(i - 1) != text
					.charAt(i)) {
				int j = i - 2;
				while (j >= 0 && text.charAt(j) == text.charAt(i - 1)) {
					j--;
				}
				int k = i + 2;
				while (k < text.length() && text.charAt(k) == text.charAt(i + 1)) {
					k++;
				}
				if (k - j - 2 > maxSequence[charAnswer]) {
					charAnswer = text.charAt(i + 1);
					maxSequence[charAnswer] = k - j - 2;
				}
			}

			if (text.charAt(i) == prev) {
				currentSequence++;
				longestSequence = Math.max(longestSequence, currentSequence);
			} else {
				currentSequence = 1;
			}
			prev = text.charAt(i);
		}

		int ans = maxSequence[charAnswer] < count[charAnswer] ? maxSequence[charAnswer] + 1 : maxSequence[charAnswer];
		ans = Math.max(ans, longestSequence < count[charAnswer] ? longestSequence + 1 : longestSequence);
		return ans;
	}
}
