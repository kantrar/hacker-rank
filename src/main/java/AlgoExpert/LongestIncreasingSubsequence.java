package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
	public static ArrayList<Integer> longestIncreasingSubsequence(int[] array) {
		int[] parent = new int[array.length];
		Arrays.fill(parent, -1);
		ArrayList<Integer> indices = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			int idx = binarySearch(indices, array, i);

			if (idx >= 1) {
				parent[i] = indices.get(idx - 1);
			} else {
				parent[i] = -1;
			}

			if (idx >= indices.size()) {
				indices.add(i);
			} else {
				indices.set(idx, i);
			}
		}

		ArrayList<Integer> res = new ArrayList<>();
		int lastIndex = indices.get(indices.size() - 1);
		while (lastIndex != -1) {
			res.add(array[lastIndex]);
			lastIndex = parent[lastIndex];
		}

		Collections.reverse(res);
		return res;
	}

	private static int binarySearch(ArrayList<Integer> indices, int[] array, int pos) {
		int left = 0;
		int right = indices.size() - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[indices.get(mid)] >= array[pos]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
