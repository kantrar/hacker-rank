import java.util.ArrayList;
import java.util.List;

public class ParlindromePartitioning {
	public List<List<String>> partition(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int len = 1; len <= s.length(); len++) {
			for (int j = 0; j + len - 1 < s.length(); j++) {
				if (s.charAt(j) == s.charAt(j + len - 1)) {
					dp[j][j + len - 1] = j + 1 <= j + len - 2 ? dp[j + 1][j + len - 2] : true;
				}
			}
		}

		List<List<String>> res = new ArrayList<>();
		backtrack(s, 0, dp, new ArrayList<>(), res);
		return res;
	}

	public void backtrack(String s, int pos, boolean[][] dp, List<String> current, List<List<String>> res) {
		if (pos >= s.length()) {
			res.add(new ArrayList<>(current));
			return;
		}

		for (int i = pos; i < s.length(); i++) {
			if (dp[pos][i]) {
				current.add(s.substring(pos, i + 1));
				backtrack(s, i + 1, dp, current, res);
				current.remove(current.size() - 1);
			}
		}
	}
}
