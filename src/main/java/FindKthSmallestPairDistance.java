import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthSmallestPairDistance {
	public int smallestDistancePair(int[] nums, int k) {
		Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				queue.offer(Math.abs(nums[i] - nums[j]));
				if (queue.size() > k) {
					queue.poll();
				}
			}
		}

		return queue.poll();
	}
}
