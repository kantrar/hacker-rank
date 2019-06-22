import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ValidPermutationsForDISequence {
	public class Pair {
		Set<Integer> set;
		int value;

		public Pair(Set<Integer> set, int value) {
			this.set = set;
			this.value = value;
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Pair)) {
				return false;
			}
			Pair other = (Pair) o;
			return this.set.equals(other.set) && this.value == other.value;
		}
	}

	Map<Pair, Integer> map = new HashMap<>();

	public int numPermsDISequence(String s) {
		int answer = 0;
		Set<Integer> set = new LinkedHashSet<>();
		for (int i = 0; i <= s.length(); i++) {
			answer += backtrack(s, i, 0, set);
		}

		return answer;
	}

	public int backtrack(String s, int value, int pos, Set<Integer> set) {
		if (pos >= s.length()) {
			return 1;
		}

		Set<Integer> newSet = new LinkedHashSet<>(set);
		newSet.add(value);

		Pair key = new Pair(newSet, value);
		if (map.containsKey(key)) {
			return map.get(key);
		}

		int answer = 0;
		if (s.charAt(pos) == 'D') {
			for (int i = 0; i < value; i++) {
				if (!newSet.contains(i)) {
					answer += backtrack(s, i, pos + 1, newSet);
				}
			}
		} else {
			for (int i = value + 1; i <= s.length(); i++) {
				if (!newSet.contains(i)) {
					answer += backtrack(s, i, pos + 1, newSet);
				}
			}
		}

		map.put(key, answer);

		return answer;
	}
}
