import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


// Incorrect
public class GenaPlayingHanoi {

	private static int towerOfHanoi(int[] arr) {
		BigInteger b = BigInteger.valueOf(1);

		List<Set<Integer>> towers = new ArrayList<>(arr.length + 1);

		int[] f = new int[arr.length + 1];

		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= arr.length; i++) {
			f[i] = 1 + 2 * f[i - 1];
		}

		for (int i = 0; i <= 4; i++) {
			towers.add(new HashSet<>());
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			towers.get(arr[i]).add(i+1);
		}

		int answer = 0;
		for (int i = 2; i < arr.length; i++) {
			answer += restore(towers, f, i, arr[i - 1]);
		}

		if (towers.get(1).contains(arr.length)) {
			answer += restore(towers, f, arr.length, 1);
		} else {
			if (towers.get(arr[arr.length - 2]).size() == arr.length) {
				answer += restore(towers, f, arr.length, 1);
			} else {
				answer++;
				answer += restore(towers, f, arr.length - 1, 1);
			}
		}

		return answer;
	}

	private static int restore(List<Set<Integer>> towers, int[] f, int disc, int destination) {
		boolean done = true;
		for (int i = disc; i >= 1; i--) {
			if (!towers.get(destination).contains(i)) {
				done = false;
			}

			for (int j = 1; j < towers.size(); j++) {
				towers.get(j).remove(i);
			}

			towers.get(destination).add(i);
		}

		if (done) {
			return 0;
		}

		return f[towers.get(destination).size()];
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();

		int[] a = new int[N];

		for (int i = 0; i < N; i++) {
			a[i] = scanner.nextInt();
		}

		System.out.println(towerOfHanoi(a));

		scanner.close();
	}

}
