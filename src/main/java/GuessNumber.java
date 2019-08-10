public class GuessNumber {
	public int guessNumber(int n) {
		int low = 1;
		int high = n;
		while (low <= high) {
			int mid = (low + high) / 2;
			int res = guess(mid);
			if (res == 0) {
				return mid;
			} else if (res > 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return 0;
	}

	private int guess(int guess) {
		if (guess == 1702766719) {
			return 0;
		}
		return guess > 1702766719 ? -1 : 1;
	}

	public static void main(String[] args) {
		GuessNumber g = new GuessNumber();
		int res = g.guessNumber(2126753390);
		System.out.println(res);
	}
}
