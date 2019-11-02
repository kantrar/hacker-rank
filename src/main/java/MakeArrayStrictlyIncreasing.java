import java.util.Arrays;
import java.util.TreeSet;

public class MakeArrayStrictlyIncreasing {

	public int makeArrayIncreasing(int[] arr1, int[] arr2) {
		if (arr1.length == 0) {
			return 0;
		}
		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int a : arr2) {
			treeSet.add(a);
		}

		int[][] dp = new int[arr1.length + 1][arr1.length + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			dp[0][i] = Integer.MIN_VALUE;
		}

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j <= i + 1; j++) {
				if (arr1[i] > dp[i][j]) {
					dp[i + 1][j] = arr1[i];
				}
				if (j > 0 && treeSet.higher(dp[i][j - 1]) != null) {
					dp[i + 1][j] = Math.min(dp[i + 1][j], treeSet.higher(dp[i][j - 1]));
				}
				if (i == arr1.length - 1 && dp[i + 1][j] != Integer.MAX_VALUE) {
					return j;
				}
			}
		}
		return -1;
	}
}
