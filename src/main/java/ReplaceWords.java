import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ReplaceWords {
	public String replaceWords(List<String> roots, String sentence) {
		if (sentence == null || sentence.length() == 0 || roots.size() == 0 || roots.contains("")) {
			return "";
		}

		String[] s = sentence.split(" ");
		Set<String> set = new TreeSet<>();
		for (int i = 0; i < s.length; i++) {
			set.add(s[i]);
		}

		Collections.sort(roots);

		int i = 0;
		Map<String, String> newWords = new HashMap<>();
		for (String word : set) {
			while (i < roots.size() && roots.get(i).charAt(0) < word.charAt(0)) {
				i++;
			}
			if (i < roots.size() && roots.get(i).charAt(0) > word.charAt(0)) {
				continue;
			}
			if (i < roots.size() && compareTo(roots.get(i), word) < 0) {
				int idxi = 0;
				if (i >= roots.size()) {
					break;
				}
				while (idxi < Math.min(roots.get(i).length(), word.length()) && roots.get(i).charAt(idxi) == word.charAt(idxi)) {
					idxi++;
				}
				if (idxi == roots.get(i).length()) {
					newWords.put(word, roots.get(i));
				}
			}

		}

		StringBuilder sb = new StringBuilder();
		for (i = 0; i < s.length; i++) {
			sb.append(newWords.getOrDefault(s[i], s[i]));
			sb.append(" ");
		}

		return sb.toString().trim();
	}

	private int compareTo(String s, String word) {
		for (int i = 0; i < Math.min(s.length(), word.length()); i++) {
			if (s.charAt(i) == word.charAt(i)) {
				continue;
			} else {
				return s.charAt(i) - word.charAt(i);
			}
		}

		return s.length() - word.length();
	}
}
