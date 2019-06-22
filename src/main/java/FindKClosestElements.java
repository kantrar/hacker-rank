import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKClosestElements {
	public static int pivot = 0;
	public static int[] input;

	public class DiffComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer a, Integer b) {
			if (Math.abs(input[a] - pivot) == Math.abs(input[b] - pivot)) {
				return input[a] - input[b];
			} else {
				return Math.abs(input[a] - pivot) - Math.abs(input[b] - pivot);
			}
		}
	}

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		pivot = x;
		input = arr;
		List<Integer> answer = new ArrayList<>();
		if (k >= arr.length) {
			for (int i = 0; i < arr.length; i++) {
				answer.add(arr[i]);
			}

			return answer;
		}

		Queue<Integer> queue = new PriorityQueue<>(new DiffComparator());

		int idx = Arrays.binarySearch(arr, x);
		idx = idx < 0 ? -(idx + 1) : idx;

		int left = idx - 1;
		int right = idx + 1;
		int i = 0;

		if (arr[idx] == x) {
			answer.add(idx);
			i++;
		} else {
			right = idx;
		}

		if (left >= 0) {
			queue.offer(left);
		}

		if (right < arr.length) {
			queue.offer(right);
		}

		while (i < k) {
			int nextIdx = queue.poll();
			answer.add(nextIdx);
			if (nextIdx == left) {
				left = nextIdx - 1;
				if (left >= 0) {
					queue.offer(left);
				}
			} else {
				right = nextIdx + 1;
				if (right < arr.length) {
					queue.offer(right);
				}
			}

			i++;
		}

		Collections.sort(answer);
		List<Integer> result = new ArrayList<>();
		for (i = 0; i < answer.size(); i++) {
			result.add(arr[answer.get(i)]);
		}

		return result;
	}
}
