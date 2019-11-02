import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NumberOfValidWordsForEachPuzzle {
	public class Trie {
		Trie[] next = new Trie[26];
		int count = 0;
	}

	
	public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < puzzles.length; i++) {
			res.add(0);
		}

		Set<Character>[] sortedWords = getSortedChar(words);
		Trie root = buildTrie(sortedWords);

		Set<Character>[] sortedPuzzles = getSortedChar(puzzles);
		for (int i = 0; i < puzzles.length; i++) {
			res.set(i, findValidWords(root, sortedPuzzles[i], false, puzzles[i].charAt(0)));
		}

		return res;
	}

	private int findValidWords(Trie root, Set<Character> puzzle, boolean firstSeen, char firstChar) {
		if (root == null) return 0;
		int count = 0;
		if (firstSeen) count += root.count;

		for (char c : puzzle) {
			if (firstChar == c) {
				count += findValidWords(root.next[c - 'a'], puzzle, true, firstChar);
			} else {
				count += findValidWords(root.next[c - 'a'], puzzle, firstSeen, firstChar);
			}
		}
		return count;
	}

	private Trie buildTrie(Set<Character>[] words) {
		Trie root = new Trie();
		for (int i = 0; i < words.length; i++) {
			Trie current = root;
			Set<Character> word = words[i];
			for (char c : word) {
				if (current.next[c - 'a'] == null) {
					current.next[c - 'a'] = new Trie();
				}
				current = current.next[c - 'a'];
			}
			current.count++;
		}
		return root;
	}

	private TreeSet<Character>[] getSortedChar(String[] words) {
		TreeSet<Character>[] treeSet = new TreeSet[words.length];
		for (int i = 0; i < words.length; i++) {
			char[] charArray = words[i].toCharArray();
			treeSet[i] = new TreeSet<>();
			for (char c : charArray) {
				treeSet[i].add(c);
			}
		}
		return treeSet;
	}

	public static void main(String[] args) {

	}
}
