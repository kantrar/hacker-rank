import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleCombinations2 {

	public static List<List<Integer>> getPossibleCombinations(List<Integer> input) {
		List<List<Integer>> answers = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();
		//		getPossibleCombinations(answers, answer, 2, 0, 0, input.size(), input);
		for (int i = 0; i < input.size(); i++) {
			getPossibleCombinations(answers, answer, i + 1, 0, 0, input.size(), input);
		}
		return answers;
	}

	public static void getPossibleCombinations(List<List<Integer>> answers, List<Integer> answer, int size, int idx, int start,
			int end, List<Integer> input) {
		if (idx == size) {
			List<Integer> a = new ArrayList<>();
			for (int i = 0; i < answer.size(); i++) {
				a.add(answer.get(i));
			}
			answers.add(a);
			return;
		}

		for (int i = start; i < end; i++) {
			answer.add(input.get(i));
			getPossibleCombinations(answers, answer, size, idx + 1, i + 1, end, input);
			answer.remove(input.get(i));
		}
	}

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
		List<List<Integer>> combinations = getPossibleCombinations(input);
		System.out.println(combinations.size());
		for (int i = 0; i < combinations.size(); i++) {
			for (int j = 0; j < combinations.get(i).size(); j++) {
				System.out.print(combinations.get(i).get(j) + ", ");
			}

			System.out.println();
		}
	}

}
