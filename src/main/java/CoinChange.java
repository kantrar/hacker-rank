public class CoinChange {

	static class Result {
		Long[][] values;

		public Result(long n, int len) {
			this.values = new Long[(int) (n + 1)][len];
		}
	}

	static long getWays(long n, long[] c) {
		Result result = new Result(n, c.length);
		long answer = getWaysAndUpdateResult(n, 0, c, result);
		return answer;
	}

	private static long getWaysAndUpdateResult(long n, int startIndex, long[] c, Result result) {

		if (result.values[(int) n][startIndex] != null) {
			return result.values[(int) n][startIndex];
		}

		if (c.length - startIndex < 1) {
			return 0;
		}

		if (n == 0) {
			return 1;
		}

		if (c.length - startIndex == 1) {
			if (n % c[startIndex] == 0) {
				result.values[(int) n][startIndex] = 1L;
				return 1;
			}
			result.values[(int) n][startIndex] = 0L;
			return 0;
		}

		long answer = 0;
		long tempGoal = n;

		while (tempGoal >= c[startIndex]) {
			long goal = tempGoal - c[startIndex];
			answer += getWaysAndUpdateResult(goal, startIndex + 1, c, result);
			tempGoal = goal;
		}
		long answer2 = getWaysAndUpdateResult(n, startIndex + 1, c, result);

		result.values[(int) n][startIndex] = answer + answer2;
		return answer + answer2;
	}

}
