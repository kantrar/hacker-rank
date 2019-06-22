import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MovingStonesUntilConsecutiveII {
	public int[] numMovesStonesII(int[] stones) {
		Arrays.sort(stones);

		int a = 0;
		int b = 0;

		int range = 0;
		int minMove = Integer.MAX_VALUE;
		while (b < stones.length) {
			if (stones[b] - stones[a] + 1 == stones.length - 1) {
				minMove = Math.min(minMove, 2);
				b++;
			} else if (stones[b] - stones[a] + 1 <= stones.length) {
				range = Math.max(range, b - a + 1);
				b++;
			} else {
				a++;
			}
		}

		minMove = stones.length - range;

		Map<Integer, Integer> next = new HashMap<>();
		Map<Integer, Integer> prev = new HashMap<>();

		next.put(stones[stones.length - 1], stones[stones.length - 1] + 1);
		for (int i = stones.length - 2; i >= 0; i--) {
			if (stones[i] + 1 == stones[i + 1]) {
				next.put(stones[i], next.get(stones[i + 1]));
			} else {
				next.put(stones[i], stones[i] + 1);
			}
		}

		prev.put(stones[0], stones[0] - 1);
		for (int i = 1; i < stones.length; i++) {
			if (stones[i] == stones[i - 1] + 1) {
				prev.put(stones[i], prev.get(stones[i - 1]));
			} else {
				prev.put(stones[i], stones[i] - 1);
			}
		}

		int left = 0;
		int right = stones.length - 1;

		int maxMove = 0;
		while (left < right) {
			int nextSpace = next.get(stones[left + 1]);
			int prevSpace = prev.get(stones[right - 1]);

			if (nextSpace > stones[right] && prevSpace < stones[left]) {
				break;
			}

			maxMove++;

			if (stones[right] - stones[left + 1] > stones[right - 1] - stones[left]) {
				prev.put(stones[left], stones[left] - 1);
				left++;
				if (left >= stones.length - 1) {
					continue;
				}
				if (nextSpace + 1 == stones[left + 1]) {
					next.put(stones[left], next.get(stones[left + 1]));
					next.put(stones[left + 1], next.get(stones[left + 1]));
				} else {
					next.put(stones[left], nextSpace + 1);
					next.put(stones[left + 1], nextSpace + 1);
				}

			} else {
				next.put(stones[right], stones[right] - 1);
				right--;
				if (right <= 0) {
					continue;
				}
				if (prevSpace - 1 == stones[right - 1]) {
					prev.put(stones[right], prev.get(stones[right - 1]));
					prev.put(stones[right - 1], prev.get(stones[right - 1]));
				} else {
					prev.put(stones[right], prevSpace - 1);
					prev.put(stones[right - 1], prevSpace - 1);
				}
			}

		}

		return new int[] {minMove, maxMove};
	}
}
