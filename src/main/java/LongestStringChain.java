import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestStringChain {
	private static int max = 0;

	public int longestStrChain(String[] words) {
		if (words.length == 0) {
			return 0;
		}
		max = 1;
		Arrays.sort(words, Comparator.comparingInt(String::length));

		List<Integer>[] wordsByLength = new ArrayList[17];
		for (int i = 0; i < 17; i++) {
			wordsByLength[i] = new ArrayList<>();
		}
		for (int i = 0; i < words.length; i++) {
			wordsByLength[words[i].length()].add(i);
		}

		List<int[]> dp = new ArrayList<>();
		for (int i = 1; i < 16; i++) {
			if (dp.isEmpty()) {
				for (int j = 0; j < wordsByLength[i].size(); j++) {
					dp.add(new int[] {wordsByLength[i].get(j), 1});
				}
			}
			find(words, i + 1, dp, wordsByLength);
		}

		return max;
	}

	public void find(String[] words, int length, List<int[]> dps, List<Integer>[] wordsByLength) {

		List<int[]> newDp = new ArrayList<>();
		List<Integer> current = wordsByLength[length];

		for (int[] dp : dps) {
			int prevIdx = dp[0];
			int[][] ptr = new int[words.length][2];
			for (char c : words[prevIdx].toCharArray()) {
				for (int curIdx : current) {
					while (ptr[curIdx][1] <= 1 && ptr[curIdx][0] < words[curIdx].length() && c != words[curIdx]
							.charAt(ptr[curIdx][0])) {
						ptr[curIdx][1]++;
						ptr[curIdx][0]++;
					}
					ptr[curIdx][0]++;
				}
			}
			for (int curIdx : current) {
				if (ptr[curIdx][1] <= 1) {
					newDp.add(new int[] {curIdx, dp[1] + 1});
					max = Math.max(max, dp[1] + 1);
				} else {
					newDp.add(new int[] {curIdx, 1});
				}
			}
		}

		dps.removeAll(dps);
		dps.addAll(newDp);
	}
}
