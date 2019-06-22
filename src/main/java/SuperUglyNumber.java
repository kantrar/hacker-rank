import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n == 1) {
			return 1;
		}

		Arrays.sort(primes);

		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		List<Integer>[] queue = new LinkedList[primes.length];

		for (int i = 0; i < queue.length; i++) {
			queue[i] = new LinkedList<>();
			queue[i].add(primes[i]);
			pq.offer(new int[] {primes[i], i});
		}

		for (int i = 2; i < n; i++) {
			int[] current = pq.poll();
			queue[current[1]].remove(0);

			for (int j = current[1]; j < primes.length; j++) {
				queue[j].add(current[0] * primes[j]);
			}
			pq.offer(new int[] {queue[current[1]].get(0), current[1]});
		}

		return pq.poll()[0];
	}
}
