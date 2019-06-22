import java.util.Deque;
import java.util.LinkedList;

public class ContainsDuplicateIII {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		Deque<Integer> deque = new LinkedList<>();

		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && i - deque.peekFirst() > k) {
				deque.removeFirst();
			}

			while (!deque.isEmpty() && nums[deque.peekLast()] > nums[i]) {
				minDistance = Math.min(minDistance, nums[deque.peekLast()] - nums[i]);
				deque.removeLast();
			}

			if (!deque.isEmpty()) {
				minDistance = Math.min(minDistance, nums[i] - nums[deque.peekLast()]);
			}

			deque.addLast(i);
		}

		deque = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && i - deque.peekFirst() > k) {
				deque.removeFirst();
			}

			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				minDistance = Math.min(minDistance, nums[i] - nums[deque.peekLast()]);
				deque.removeLast();
			}

			if (!deque.isEmpty()) {
				minDistance = Math.min(minDistance, nums[deque.peekLast()] - nums[i]);
			}

			deque.addLast(i);
		}

		return minDistance <= t;
	}
}
