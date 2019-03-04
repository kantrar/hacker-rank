import java.util.Arrays;

public class NewYearChaos {
	static void minimumBribes(int[] q) {
		// 1 2 3 4 7 6 9 10 8 5
		// 1 2 3 4 5 6 7 8 9 10
		// 1 2 3 4 6 5 7 9 8 10 // 2 6, 9
		// 1 2 3 4 7 6 5 9 8 10 // 2 7, 7
		// 1 2 3 4 7 6 9 5 10 8 // 2 9, 10
		// 1 2 3 4 7 6 9 10 8 5 // 2 8, 10
		// 1 2 3 4 5 7 6 9 10 8
		// 1 2 3 4 5 6 7 8 9 10
		// Bubble sort ?
		int[] counts = new int[q.length + 1];
		for (int i = 0; i < 2; i++) {

			for (int j = q.length - 1; j >= 1; j--) {
				int currentAtBeforeJ = q[j - 1];
				counts[currentAtBeforeJ] += swapIfNeeded(q, j - 1, j);
				// Doesn't need this part
				//				if (counts[currentAtBeforeJ] > 2) {
				//					System.out.println("Too chaotic");
				//					return;
				//				}
			}
		}

		for (int i = 0; i < q.length; i++) {
			if (q[i] != i + 1) {
				System.out.println("Too chaotic");
				return;
			}
		}

		System.out.println(Arrays.stream(counts).sum());
	}

	private static int swapIfNeeded(int[] q, int before, int after) {
		if (q[before] > q[after]) {
			int temp = q[before];
			q[before] = q[after];
			q[after] = temp;
			return 1;
		}

		return 0;
	}

	public static void main(String[] args) {
		minimumBribes(new int[] {2, 5, 1, 3, 4});
	}
}
