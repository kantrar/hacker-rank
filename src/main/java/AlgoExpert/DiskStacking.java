package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DiskStacking {
	public static ArrayList<Integer[]> diskStacking(ArrayList<Integer[]> disks) {
		Collections.sort(disks, (a, b) -> a[0] != b[0] ? a[0] - b[0] : (a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]));
		int[] dp = new int[disks.size() + 1];
		int[] parent = new int[disks.size()];
		Arrays.fill(parent, -1);
		int maxIdx = 0;
		for (int i = 0; i < disks.size(); i++) {
			Integer[] curDisk = disks.get(i);
			dp[i + 1] = curDisk[2];
			for (int j = i - 1; j >= 0; j--) {
				Integer[] prevDisk = disks.get(j);
				if (compare(curDisk, prevDisk) >= 0) {
					if (curDisk[2] + dp[j + 1] > dp[i + 1]) {
						dp[i + 1] = Math.max(dp[i + 1], curDisk[2] + dp[j + 1]);
						parent[i] = j;
					}
				}
			}
			if (dp[maxIdx + 1] < dp[i + 1]) {
				maxIdx = i;
			}
		}

		ArrayList<Integer[]> res = new ArrayList<>();
		while (maxIdx != -1) {
			res.add(disks.get(maxIdx));
			maxIdx = parent[maxIdx];
		}

		Collections.reverse(res);

		return res;
	}

	public static int compare(Integer[] cur, Integer[] prev) {
		if (cur[0] > prev[0] && cur[1] > prev[1] && cur[2] > prev[2]) {
			return 1;
		}
		return -1;
	}

}
