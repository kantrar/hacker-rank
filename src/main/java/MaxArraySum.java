import java.io.IOException;
import java.util.Scanner;

public class MaxArraySum {
	static int maxSubsetSum(int[] arr) {
		int[][] answers = new int[arr.length][2];
		for (int i = 0; i < answers.length; i++) {
			answers[i][0] = -1;
			answers[i][1] = -1;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, calculateMaxSubsetSum(arr, i, true, answers));
		}

		return max == Integer.MIN_VALUE ? 0 : max;
	}

	static int calculateMaxSubsetSum(int[] arr, int pos, boolean canBeIncluded, int[][] answers) {
		if (pos >= arr.length) {
			return 0;
		}
		int canBeIncludedInt;

		if (canBeIncluded) {
			canBeIncludedInt = 1;
		} else {
			canBeIncludedInt = 0;
		}
		if (answers[pos][canBeIncludedInt] != -1) {
			return answers[pos][canBeIncludedInt];
		}

		int answer = 0;
		if (canBeIncluded && arr[pos] > 0) {
			// Include this element
			System.out.println(pos);
			int answer1 = arr[pos] + calculateMaxSubsetSum(arr, pos + 1, false, answers);
			// Not include this element
			int answer2 = calculateMaxSubsetSum(arr, pos + 1, true, answers);

			answer = Math.max(answer1, answer2);
		} else {
			// Not include this element
			answer = calculateMaxSubsetSum(arr, pos + 1, true, answers);
		}

		answers[pos][canBeIncludedInt] = answer;
		return answer;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int res = maxSubsetSum(arr);

		System.out.println(res);

		scanner.close();
	}
}
