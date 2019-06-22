import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PossibleCombinations {

	public static void main(String[] args) {
		combine(4, 2);

	}

	private static void printPossibleCombinations(int[] inputs, int[] data, int start, int end, int index, int size) {
		if (index == size) {
			for (int i = 0; i < data.length; i++) {
				System.out.print(data[i]);
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= end && end - i + 1 >= size - index; i++) {
			data[index] = inputs[i];
			printPossibleCombinations(inputs, data, i + 1, end, index + 1, size);
		}
	}

	private static List<List<Integer>> answer;
	public static List<List<Integer>> combine(int n, int k) {
		answer = new ArrayList<>();
		List<Integer> input = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			input.add(i);
		}

		generate(input, 0, k, new ArrayList<Integer>());

		return answer;
	}

	public static void generate(List<Integer> input, int pos, int limit, List<Integer> current) {
		if (current.size() >= limit) {
			answer.add(new ArrayList<>(current));
			return;
		}

		for (int i = pos; i < input.size(); i++) {
			current.add(input.get(i));
			generate(input, i + 1, limit, current);
			current.remove(current.size() - 1);
		}
	}
}
