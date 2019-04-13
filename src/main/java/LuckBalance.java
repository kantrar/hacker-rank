import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LuckBalance {
	static int luckBalance(int k, int[][] contests) {
		int answer = 0;
		List<Integer> luckOfImportanceContests = new ArrayList<>();

		// 5, 1, 4 -> answer = 4;
		// 1, 5
		for (int i = 0; i < contests.length; i++) {
			int luck = contests[i][0];
			int importance = contests[i][1];

			if (importance == 1) {
				luckOfImportanceContests.add(luck);
			} else {
				answer += luck;
			}
		}

		Collections.sort(luckOfImportanceContests);

		for (int i = luckOfImportanceContests.size() - 1; i >= 0; i--) {
			if (k > 0) {
				answer += luckOfImportanceContests.get(i);
				k--;
			} else {
				answer -= luckOfImportanceContests.get(i);
			}
		}

		return answer;
	}

	public static void main(String[] args) {

	}
}
