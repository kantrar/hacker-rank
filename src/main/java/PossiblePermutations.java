import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PossiblePermutations {
	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> input) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		permute(input, 0, input.size(), output);

		return output;
	}

	private static void permute(ArrayList<Integer> input, int idx, int end, ArrayList<ArrayList<Integer>> output) {
		if (idx + 1 >= end) {
			output.add(new ArrayList(input));
			return;
		}

		for (int i = idx; i < end; i++) {
			Collections.swap(input, i, idx);
			permute(input, idx + 1, end, output);
			Collections.swap(input, i, idx);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<>();
		input.addAll(Arrays.asList(1, 2, 3));

		ArrayList<ArrayList<Integer>> output = permute(input);

		for (int i = 0; i < output.size(); i++) {
			for (int j = 0; j < output.get(i).size(); j++) {
				System.out.print(output.get(i).get(j) + ", ");
			}
			System.out.println();
		}
	}
}
