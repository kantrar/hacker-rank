import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {
	int MAX = Integer.MAX_VALUE;
	public List<Integer> splitIntoFibonacci(String S) {
		if (S.length() < 3) {
			return new ArrayList<>();
		}

		List<Integer> res = split(S, 0, S.length() - 1, null, null);
		return res.size() < 3 ? new ArrayList<>(): res;
	}

	public List<Integer> split(String s, int start, int end, Integer first, Integer second) {
		if (start > end) {
			return new ArrayList<>();
		}
		for (int i = start; i <= end; i++) {
			long current = Long.parseLong(s.substring(start, i + 1));
			if (i != start && s.charAt(start) == '0') {
				return Arrays.asList(-1);
			}
			if (current > MAX) {
				break;
			}
			if (first == null) {
				List<Integer> res = split(s, i + 1, end, (int) current, second);
				if (!res.isEmpty() && res.get(0) == -1) continue;
				res.add(0, (int) current);
				if (res.size() < 3) continue;
				return res;
			} else if (second == null) {
				List<Integer> res = split(s, i + 1, end, first, (int) current);
				if (!res.isEmpty() && res.get(0) == -1) continue;
				res.add(0, (int) current);
				if (res.size() < 2) continue;
				return res;
			} else if (current == first + second) {
				List<Integer> res = split(s, i + 1, end, second, (int) current);
				if (!res.isEmpty() && res.get(0) == -1) continue;
				res.add(0, (int) current);
				return res;
			} else if (current > first + second) {
				break;
			}
		}

		return Arrays.asList(-1);
	}
}
