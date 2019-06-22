import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0) {
			return new int[] {};
		}

		int[] answers = new int[nums.length - k + 1];
		int answerIdx = 0;

		Deque<Integer> deque = new LinkedList<>();

		int idx = 0;
		while (idx < k && idx < nums.length) {
			while (!deque.isEmpty() && nums[idx] > nums[deque.peekLast()]) {
				deque.removeLast();
			}

			deque.addLast(idx);
			idx++;
		}

		if (idx == nums.length) {
			return new int[] {nums[deque.peekFirst()]};
		}

		answers[answerIdx++] = nums[deque.peekFirst()];

		while (idx < nums.length) {

			while (!deque.isEmpty() && nums[idx] > nums[deque.peekLast()]) {
				deque.removeLast();
			}

			deque.addLast(idx);

			if (deque.peekFirst() == idx - k) {
				deque.removeFirst();
			}
			answers[answerIdx++] = nums[deque.peekFirst()];

			idx++;
		}

		return answers;
	}

}
