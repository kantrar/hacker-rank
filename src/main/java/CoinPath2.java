import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinPath2 {
	public List<Integer> cheapestJump(int[] A, int B) {
		if (A.length == 0) {
			return new ArrayList<>();
		}

		int[] next = new int[A.length];
		Arrays.fill(next, Integer.MAX_VALUE);
		next[A.length - 1] = A.length - 1;

		int[] coins = new int[A.length];
		Arrays.fill(coins, -1);
		coins[A.length - 1] = 0;

		for (int i = A.length - 2; i >= 0; i--) {
			if (A[i] == -1) {
				continue;
			}
			for (int j = 1; j <= B && i + j < A.length; j++) {
				if (A[i + j] == -1) {
					continue;
				}
				if (coins[i] == -1 || coins[i] > coins[i + j] + A[i]) {
					coins[i] = coins[i + j] + A[i];
					next[i] = i + j;
				}
			}
		}

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < A.length - 1; i = next[i]) {
			if (next[i] == Integer.MAX_VALUE) {
				return new ArrayList<>();
			}
			answer.add(i + 1);
		}

		answer.add(A.length);

		return answer;
	}
}
