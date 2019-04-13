import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CountingTriangles {
	public static int nTriang(ArrayList<Integer> input) {
		int answer = 0;

		Collections.sort(input);

		for (int i = 0; i < input.size(); i++) {
			for (int j = i + 1; j < input.size() - 1; j++) {
				int sumPair = input.get(i) + input.get(j);

				int kIdx = j + 1;

				while (kIdx < input.size() && sumPair > input.get(kIdx)) {
					answer++;
					kIdx++;
				}

			}
		}

		return answer;
	}

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<>();
		input.addAll(Arrays.asList(4, 6, 13, 16, 20, 3, 1, 12));
		System.out.println(nTriang(input));
	}
}
