public class LongestRepeatingCharacterReplacement
{
	public int characterReplacement(String s, int k) {
		int[] count = new int[26];
		int start = 0, end = 0;

		int answer = 0;
		while (end < s.length()) {
			count[s.charAt(end++) - 'A']++;
			int maxLen = 0;
			for (int i = 0; i < 26; i++) {
				maxLen = Math.max(maxLen, count[i]);
			}
			int len = end - start;
			if (len - maxLen > k) count[s.charAt(start++) - 'A']--;
			else { answer = Math.max(answer, len); }

		}

		return answer;
	}
}
