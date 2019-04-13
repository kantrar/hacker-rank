import java.io.IOException;
import java.util.Scanner;

public class BricksGame {
	static long bricksGame(int[] arr) {
		long[][] f = new long[arr.length][2];
		for (int i = 0; i < arr.length; i++) {
			f[i][0] = -1;
		}

		for (int i = arr.length - 1; i >= 1; i--) {
			play(arr, i, f);
		}
		return play(arr, 0, f)[0];
	}

	static long[] play(int[] arr, int pos, long[][] f) {
		if (pos >= arr.length) {
			return new long[] {0, 0};
		}

		if (f[pos][0] != -1) {
			return f[pos];
		}

		long[] p1 = play(arr, pos + 1, f);
		long[] p2 = play(arr, pos + 2, f);
		long[] p3 = play(arr, pos + 3, f);

		long otherPlayerScore = Math.min(p1[0], Math.min(p2[0], p3[0]));
		long playerScore = 0;
		if (otherPlayerScore == p1[0] || pos + 1 >= arr.length) {
			playerScore = arr[pos] + p1[1];
		} else if (otherPlayerScore == p2[0] || pos + 2 >= arr.length) {
			playerScore = arr[pos] + arr[pos + 1] + p2[1];
		} else {
			playerScore = arr[pos] + arr[pos + 1] + arr[pos + 2] + p3[1];
		}

		f[pos] = new long[] {playerScore, otherPlayerScore};

		return f[pos];
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int t = scanner.nextInt();

		for (int tItr = 0; tItr < t; tItr++) {
			int arrCount = scanner.nextInt();

			int[] arr = new int[arrCount];

			for (int arrItr = 0; arrItr < arrCount; arrItr++) {
				arr[arrItr] = scanner.nextInt();
			}

			long result = bricksGame(arr);

			System.out.println(result);
		}
	}
}
