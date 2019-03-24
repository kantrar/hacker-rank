import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClimbingLeaderboard {
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		int[] answers = new int[alice.length];
		List<Integer> distinctScores = new ArrayList<>();
		distinctScores.add(scores[0]);
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] == distinctScores.get(distinctScores.size() - 1)) {
				continue;
			}

			distinctScores.add(scores[i]);
		}

		for (int i = 0; i < alice.length; i++) {
			answers[i] = addIfNeeded(distinctScores, alice[i]) + 1;
		}

		return answers;
	}

	private static int addIfNeeded(List<Integer> distinctScores, int score) {
		int left = 0;
		int right = distinctScores.size();
		int mid = (left + right) / 2;

		while (left < right) {
			if (distinctScores.get(mid) < score) {
				right = mid;
			} else if (distinctScores.get(mid) > score) {
				left = mid + 1;
			} else if (distinctScores.get(mid) == score) {
				return mid;
			}
			mid = (left + right) / 2;
		}

		if (mid == distinctScores.size()) {
			distinctScores.add(score);
			return mid;
		}

		distinctScores.add(mid, score);
		return mid;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int scoresCount = scanner.nextInt();

		int[] scores = new int[scoresCount];

		for (int i = 0; i < scoresCount; i++) {
			scores[i] = scanner.nextInt();
		}

		int aliceCount = scanner.nextInt();

		int[] alice = new int[aliceCount];

		for (int i = 0; i < aliceCount; i++) {
			alice[i] = scanner.nextInt();
		}

		int[] result = climbingLeaderboard(scores, alice);

		System.out.println();
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

		scanner.close();
	}
}
