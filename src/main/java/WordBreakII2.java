import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordBreakII2 {
	public class Trie {
		Trie[] next = new Trie[26];
		int index = -1;
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		if (wordDict.isEmpty()) {
			return Collections.emptyList();
		}
		Trie root = buildTrie(wordDict);

		return dfs(s, 0, root);
	}

	private List<String> dfs(String s, int pos, Trie root) {
		if (pos >= s.length()) {
			return Arrays.asList("");
		}
		List<String> res = new ArrayList<>();
		Trie current = root;
		int i = 0;
		while (i + pos < s.length() && current != null) {
			char c = s.charAt(i + pos);
			current = current.next[c - 'a'];
			if (current != null && current.index != -1) {
				List<String> next = dfs(s, i + pos + 1, root);
				String cur = s.substring(pos, i + pos + 1);
				for (String r : next) {
					res.add(r.isEmpty() ? cur : cur + " " + r);
				}
			}
			i++;
		}
		return res.isEmpty() ? Arrays.asList() : res;
	}

	private Trie buildTrie(List<String> wordDict) {
		Trie root = new Trie();

		for (int idx = 0; idx < wordDict.size(); idx++) {
			String word = wordDict.get(idx);
			Trie current = root;
			for (int i = 0; i < word.length(); i++) {
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
