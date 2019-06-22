import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestRange {
	public int[] smallestRange(List<List<Integer>> nums) {
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		int[] bucket = new int[nums.size()];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			List<Integer> list = nums.get(i);
			if (list.isEmpty()) {
				return new int[] {};
			}

			min = Math.min(min, list.get(0));
			max = Math.max(max, list.get(0));
			bucket[i] = list.get(0);
			queue.offer(new int[] {list.get(0), i, 0});
		}

		int[] ans = new int[] {min, max};

		while (true) {
			int[] current = queue.poll();

			if (current[2] + 1>= nums.get(current[1]).size()) {
				return ans;
			}

			bucket[current[1]] = nums.get(current[1]).get(current[2] + 1);

			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for (int i = 0; i < bucket.length; i++) {
				min = Math.min(min, bucket[i]);
				max = Math.max(max, bucket[i]);
			}
			if (ans[1] - ans[0] > max - min) {
				ans = new int[] {min, max};
			}

			queue.offer(new int[] {bucket[current[1]], current[1], current[2] + 1});
		}
	}
}
