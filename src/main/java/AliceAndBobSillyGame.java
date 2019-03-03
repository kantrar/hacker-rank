import java.util.ArrayList;
import java.util.List;

public class AliceAndBobSillyGame {
	static int sillyGame(int n) {
	    int[] f = new int[n+1];
		f[0] = 0;
		f[1] = 0;
		f[2] = 1;

		int noOfPrimes = countNoOfPrimes(n, f);
		
		return noOfPrimes % 2 == 0 ? 1 : 2;
	}

	private static int countNoOfPrimes(int n, int[] f) {
		if (n < 2) {
			return 0;
		}

		if (f[n] != 0) {
		 	return f[n];
		}

		List<Integer> primeNumbers = new ArrayList<>();
		primeNumbers.add(2);

		for (int i = 3; i <= n; i += 2) {
			boolean prime = true;

			double maxPossible = Math.sqrt(i);
			for (int primeNumber : primeNumbers) {
				if (primeNumber > maxPossible) {
					break;
				}
				if (i % primeNumber == 0) {
					prime = false;
					break;
				}
			}

			if (prime) {
				primeNumbers.add(i);
				f[i] = primeNumbers.size();
			}
		}

		f[n] = primeNumbers.size();
		return primeNumbers.size();
	}
}
