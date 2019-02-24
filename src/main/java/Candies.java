import java.util.Scanner;

public class Candies {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] inputs = new int[size];

		for (int i = 0; i < size; i++) {
			inputs[i] = scanner.nextInt();
		}

		System.out.println(candies1(size, inputs));

		// The worst case scenario is unbearable.
		System.out.println(candies2(size, inputs));
	}

	static long candies1(int n, int[] arr) {
		long sum = 0;

		int[] f = new int[n];
		f[0] = 1;

		// This loop is to ensure that the right student gets more candies if he/she has higher performace.
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[i - 1]) {
				f[i] = f[i - 1] + 1;
			} else {
				f[i] = 1;
			}
		}

		// This loop is to ensure that the left student gets more candies if he/she has higher performace.
		sum += f[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] > arr[i + 1] && f[i] <= f[i + 1]) {
				f[i] = f[i + 1] + 1;
			}
			sum += f[i];
		}

		return sum;
	}

	// Complete the candies function below.
	static long candies2(int n, int[] arr) {

		int[] f = new int[n];

		return calculate2(f, arr);
	}

	private static long calculate2(int[] f, int[] arr) {
		long sum = 0;

		for (int i = arr.length - 1; i >= 0; i--) {

			if (i == arr.length - 1) {
				f[i] = 1;
				sum += f[i];

			} else {

				if (arr[i] > arr[i + 1]) {
					f[i] = f[i + 1] + 1;
					sum += f[i];

				} else if (arr[i] < arr[i + 1]) {
					f[i] = 1;
					sum += f[i];

					int j = i + 1;
					while (j < arr.length) {

						if (arr[j] > arr[j - 1] && f[j] <= f[j - 1]) {
							int newFJ = f[j - 1] + 1;
							sum += (newFJ - f[j]);

							f[j] = newFJ;

						} else {
							break;
						}
						j++;
					}

				} else {
					f[i] = 1;
					sum += f[i];
				}
			}
		}

		return sum;
	}
}
