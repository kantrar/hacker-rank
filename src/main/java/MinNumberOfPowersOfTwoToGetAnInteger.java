public class MinNumberOfPowersOfTwoToGetAnInteger {
	public int minNumber(int num) {
		String str = Integer.toBinaryString(num);
		int[] min = new int[str.length() + 1];
		int[] max = new int[str.length() + 1];
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == '0') {
				min[i] = min[i + 1];
				max[i] = max[i + 1];
			} else {
				min[i] = 1 + min[i + 1];
				max[i] = 1 + max[i + 1];
				int j = i + 1;
				while (j < str.length()) {
					min[i] = Math.min(min[i], 1 + (str.length() - i) - max[j]);
					max[i] = Math.max(max[i], 1 + (str.length() - i) - min[i]);
					j++;
				}
			}
		}
		return min[0];
	}
}
