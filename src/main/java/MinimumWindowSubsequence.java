import java.util.ArrayList;
import java.util.List;

public class MinimumWindowSubsequence {
	public class Pair {
		int start;
		int end;

		public Pair(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}

	// abcdebdde
	// bde

	// countMap = 'a': 1, 'b'
	public String minWindow(String S, String T) {
		List<Pair> positions = new ArrayList<>();

		for (int i = 0; i < S.length(); i++) {
			positions.add(new Pair(i, i));
		}

		for (int i = 0; i < T.length(); i++) {
			char key = T.charAt(i);

			int j = 0;
			int currentPos = j;
			List<Pair> newPositions = new ArrayList<>();
			while (currentPos < positions.size()) {
				j = findKeyInS(S, key, positions.get(currentPos).end);
				if (j > S.length()) {
					break;
				}

				// abac -> ac
				// positions = {0,0}, {1,1}, .., {3,3}
				// nextPositions = {0,1}, {2,3}
				// nextPositions =  {2,4}
				int newPos = currentPos;
				while (newPos + 1 < positions.size() && j - 1 >= positions.get(newPos + 1).end) {
					newPos++;
				}

				if (newPos == positions.size()) {
					break;
				}

				if (i == 0) {
					newPositions.add(new Pair(j - 1, j));
				} else {
					newPositions.add(new Pair(positions.get(newPos).start, j));
				}

				currentPos = newPos + 1;
			}

			positions = newPositions;
		}

		int minLength = S.length();
		if (positions.size() == 0) {
			return "";
		} else {
			String answer = new String(S);
			for (int i = 0; i < positions.size(); i++) {
				if (minLength > positions.get(i).end - positions.get(i).start) {
					minLength = positions.get(i).end - positions.get(i).start;
					answer = S.substring(positions.get(i).start, positions.get(i).end);
				}
			}

			return answer;
		}
	}

	public int findKeyInS(String s, char k, int startIdx) {
		for (int i = startIdx; i < s.length(); i++) {
			if (s.charAt(i) == k) {
				return i + 1;
			}
		}

		return s.length() + 1;
	}

	public static void main(String[] args) {
		MinimumWindowSubsequence mws = new MinimumWindowSubsequence();
		String result = mws.minWindow(

				"abcdebdde", "bde");
		System.out.println(result);

	}
}
