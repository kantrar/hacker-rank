import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SummingPiece {
	private static final long MOD = 1000000007L;
	private static long answer = 0;

	static long summingPieces(long[] arr) {
		long[] sum = new long[arr.length];
		long[] f = new long[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			calculate(arr, i, f, sum);
		}
		return f[0];
	}

	private static void calculate(long[] arr, int pos, long[] f, long[] sum) {
		if (pos == arr.length - 1) {
			sum[pos] = arr[pos];
			f[pos] = arr[pos];
			return;
		}

		long answer = 0;
		sum[pos] = sum[pos + 1] + sum[pos + 1] / (arr.length - pos - 1) + arr[pos] * (arr.length - pos);
		answer += sum[pos] % MOD;
		answer += (f[pos + 1] + arr[pos] * Math.pow(2, arr.length - pos - 2)) % MOD;

		long pureSum = sum[pos] / (arr.length - pos);
		for (int i = pos + 2; i < arr.length; i++) {
			answer += (((pureSum - sum[i] / (arr.length - i)) * (i-pos) * Math.pow(2, arr.length - i -1)) % MOD + f[i]) % MOD;
		}
		f[pos] = answer;
	}

	// timeout
	static long summingPieces2(long[] arr) {
		findSum(arr, 0, 0, new ArrayList<>());
		return answer;
	}

	private static void findSum(long[] arr, int pos, long sum, List<Long> subarray) {
		if (pos == arr.length - 1) {
			subarray.add(arr[pos]);
			answer += (sum + subarray.stream().mapToLong(Long::longValue).sum() * subarray.size());
			subarray.remove(arr[pos]);
			return;
		}

		subarray.add(arr[pos]);
		long newSum = sum % MOD + subarray.stream().mapToLong(Long::longValue).map(x -> x % MOD).sum() * subarray.size();
		findSum(arr, pos + 1, newSum, new ArrayList<>());

		findSum(arr, pos + 1, sum, subarray);
		subarray.remove(arr[pos]);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int arrCount = scanner.nextInt();

		long[] arr = new long[arrCount];

		for (int arrItr = 0; arrItr < arrCount; arrItr++) {
			arr[arrItr] = scanner.nextLong();
		}

		System.out.println(summingPieces(arr));
		System.out.println(summingPieces2(arr));
	}
}
