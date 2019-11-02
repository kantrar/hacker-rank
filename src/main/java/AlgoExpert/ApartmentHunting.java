package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;

public class ApartmentHunting {
	public static int apartmentHunting(ArrayList<HashMap<String, Boolean>> blocks, String[] reqs) {
		int[][] distances = new int[reqs.length][blocks.size()];
		for (int i = 0; i < reqs.length; i++) {
			String required = reqs[i];
			for (int j = 0; j < blocks.size(); j++) {
				if (blocks.get(j).getOrDefault(required, false)) {
					distances[i][j] = 0;
				} else {
					distances[i][j] = (j == 0 || distances[i][j - 1] == Integer.MAX_VALUE) ?
							Integer.MAX_VALUE :
							distances[i][j - 1] + 1;
				}
			}

			for (int j = blocks.size() - 1; j >= 0; j--) {
				if (blocks.get(j).getOrDefault(required, false)) {
					distances[i][j] = Math.min(distances[i][j], 0);
				} else {
					int d = (j == blocks.size() - 1 || distances[i][j + 1] == Integer.MAX_VALUE) ?
							Integer.MAX_VALUE :
							distances[i][j + 1] + 1;
					distances[i][j] = Math.min(distances[i][j], d);
				}
			}
		}

		int res = Integer.MAX_VALUE;
		int blockIndex = 0;
		for (int i = 0; i < blocks.size(); i++) {
			int ans = 0;
			for (int j = 0; j < reqs.length; j++) {
				ans = Math.max(ans, distances[j][i]);
			}
			if (res > ans) {
				res = ans;
				blockIndex = i;
			}
		}
		return blockIndex;
	}

}
