import java.util.Arrays;

public class MaxMin {
	static int maxMin(int k, int[] arr) {
		Arrays.sort(arr);

		if (k >= arr.length) {
			return arr[arr.length - 1] - arr[0];
		}

		int unfairness = arr[k - 1] - arr[0];

		for (int i = k; i < arr.length; i++) {
			int currentUnfairness = arr[i] - arr[i - k + 1];
			if (currentUnfairness < unfairness) {
				unfairness = currentUnfairness;
			}
		}

		return unfairness;
	}
}

