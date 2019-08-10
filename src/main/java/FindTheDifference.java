public class FindTheDifference {
	public char findTheDifference(String s, String t) {
		int[] count = new int[8];
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		int res = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < sChars.length; j++) {
				count[i] += (sChars[j] & (1 << i)) != 0 ? 1 : 0;
				sChars[j] ^= (1 << i);
			}

			for (int j = 0; j < tChars.length; j++) {
				count[i] -= (tChars[j] & (1 << i)) != 0 ? 1 : 0;
				tChars[j] ^= (1 << i);
			}

			if (count[i] != 0) {
				res |= 1 << i;
			}
		}

		return (char) (res);
	}
}
