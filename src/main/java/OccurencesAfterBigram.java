import java.util.ArrayList;
import java.util.List;

public class OccurencesAfterBigram {
	public String[] findOcurrences(String text, String first, String second) {
		String[] s;

		if (text == null || (s = text.split(" ")).length <= 2) {
			return new String[] {};
		}

		List<String> ans = new ArrayList<>();
		int i = 0;
		while (i + 2 < s.length) {
			if (first.equals(s[i]) && second.equals(s[i + 1])) {
				ans.add(s[i + 2]);
				i += 2;
			} else {
				i++;
			}
		}

		return ans.toArray(new String[ans.size()]);
	}
}
