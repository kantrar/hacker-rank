import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CoinPath {
	public class Answer {
		LinkedList<Integer> list = new LinkedList<>();
		int total = 0;
		boolean reachEnd = false;

		public Answer(int maxValue) {
			this.total = maxValue;
		}

		public Answer(Answer a) {
			this.list = new LinkedList<>(a.list);
			this.total = a.total;
		}
	}

	public List<Integer> cheapestJump(int[] A, int B) {
		if (A.length == 0) {
			return new ArrayList<>();
		}

		Map<Integer, Answer> map = new HashMap<>();

		Answer answer = new Answer(0);
		Answer minAnswer = findPath(A, B, 0, answer, map);

		if (minAnswer.total == Integer.MAX_VALUE) {
			return new ArrayList<>();
		} else {
			return minAnswer.list;
		}
	}

	private Answer findPath(int[] A, int B, int pos, Answer answer, Map<Integer, Answer> map) {
		if (pos >= A.length || A[pos] == -1) {
			Answer a = new Answer(Integer.MAX_VALUE);
			return a;
		}

		if (map.containsKey(pos)) {
			return map.get(pos);
		}

		if (pos == A.length - 1) {
			Answer a = new Answer(A[pos]);
			a.list = new LinkedList<>(Arrays.asList(pos + 1));
			a.reachEnd = true;

			map.put(pos, a);
			return a;
		}

		answer.list.add(pos + 1);
		answer.total += A[pos];

		Answer minAnswer = new Answer(Integer.MAX_VALUE);
		for (int i = 1; i <= B; i++) {
			Answer a = new Answer(0);
			a = findPath(A, B, pos + i, a, map);

			if (minAnswer.total > a.total) {
				minAnswer = a;
			}
		}

		if (minAnswer.reachEnd) {
			mergeAnswer(answer, minAnswer);
			map.put(pos, answer);

			return answer;
		} else {
			Answer a = new Answer(Integer.MAX_VALUE);
			map.put(pos, a);

			return a;
		}
	}

	private void mergeAnswer(Answer answer, Answer minAnswer) {
		answer.list.addAll(minAnswer.list);
		answer.total += minAnswer.total;
		answer.reachEnd = minAnswer.reachEnd;
	}

}
