import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AScratch {

	public static int findZeroSumSubArrays(int arr[]) {

		HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		int sum = 0;
		int c = 0;
		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];

			if (sum == 0) {
				c++;
			}

			if (sumMap.containsKey(sum)) {
				c += sumMap.get(sum);
			}

			if (sumMap.containsKey(sum)) {
				sumMap.put(sum, sumMap.get(sum) + 1);
			} else {
				sumMap.put(sum, 1);
			}
		}

		return c;
	}

	public static int solve(List<List<Integer>> A) {

		if (A.size() == 0) {
			return 0;
		}
		int c = 0;
		int rows = A.size();
		int cols = A.get(0).size();

		for (int left = 0; left < cols; left++) {
			int[] temp = new int[rows];
			Arrays.fill(temp, 0);
			for (int right = left; right < cols; right++) {

				for (int i = 0; i < rows; i++) {
					temp[i] += A.get(i).get(right);
					System.out.print(temp[i] + ", ");
				}
				System.out.println();

				int x = findZeroSumSubArrays(temp);
				// System.out.println(x);
				c += x;

			}
		}

		return c;
	}

	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<>();
		//		input.add(Arrays.asList(-8, 9, 7));
		//		input.add(Arrays.asList(-8, 7, -8));
		//		input.add(Arrays.asList(5, -8, 9));
		input.add(Arrays.asList(16, -1, 1, -1, 1));
		//		input.add(Arrays.asList(16));
		//		input.add(Arrays.asList(-1));
		//		input.add(Arrays.asList(1));
		//		input.add(Arrays.asList(-1));
		//		input.add(Arrays.asList(1));
		int result = solve(input);
		System.out.println(result);
		String a = "abc";
		String substring = a.substring(1, 2);
		System.out.println(substring);
	}
}
