import java.util.ArrayList;
import java.util.List;

public class KSimilarStrings {
	public int kSimilarity(String A, String B) {
		if (A == null || B == null || A.length() == 0) {
			return 0;
		}

		List<Character> wrong = new ArrayList<>();
		List<Character> correct = new ArrayList<>();
		for (int i = 0; i < B.length(); i++) {
			if (A.charAt(i) != B.charAt(i)) {
				wrong.add(A.charAt(i));
				correct.add(B.charAt(i));
			}
		}

		int ans = 0;

		ans += backtrack(wrong, correct, 0);

		return ans;
	}

	private int backtrack(List<Character> src, List<Character> dest, int current) {
		if (current >= src.size()) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < src.size(); i++) {
			if (src.get(i) == dest.get(current)) {
				if (i == current) {
					return backtrack(src, dest, current + 1);
				}
				swap(src, i, current);
				min = Math.min(min, backtrack(src, dest, current + 1));
				swap(src, i, current);
			}
		}
		return min == Integer.MAX_VALUE ? 0 : 1 + min;
	}

	private void swap(List<Character> s, int sIndex, int dIndex) {
		char temp = s.get(sIndex);
		s.set(sIndex, s.get(dIndex));
		s.set(dIndex, temp);
	}
}
