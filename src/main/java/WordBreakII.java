import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII {
	public class Trie {
		Trie[] next = new Trie[26];
		int index = -1;
	}
	public List<String> wordBreak(String s, List<String> wordDict) {
		if (wordDict.size() == 0) return Arrays.asList();

		Trie root = buildTrie(wordDict);

		List<String>[] dp = new ArrayList[s.length() + 1];
		dp[0] = new ArrayList<>();
		dp[0].add("");

		for (int i = 0; i < s.length(); i++) {
			dp[i + 1] = new ArrayList<>();
			Trie current = root;
			int j = i;
			while (current != null && j >= 0) {
				char c = s.charAt(j);
				current = current.next[c - 'a'];
				if (current == null) break;
				if (current.index != -1) {
					for (String w: dp[j]) {
						String t = new String(w);
						dp[i + 1].add(t.isEmpty() ? wordDict.get(current.index) : t + " " + wordDict.get(current.index));
					}
				}
				j--;
			}
		}

		return dp[s.length()];
	}

	private Trie buildTrie(List<String> wordDict) {
		Trie root = new Trie();

		for (int idx = 0; idx < wordDict.size(); idx++) {
			String word = wordDict.get(idx);
			Trie current = root;
			for (int i = word.length() - 1; i >= 0; i--) {
				char c = word.charAt(i);
				if (current.next[c - 'a'] == null) {
					current.next[c - 'a'] = new Trie();
				}
				current = current.next[c - 'a'];
			}
			current.index = idx;
		}

		return root;
	}
}
