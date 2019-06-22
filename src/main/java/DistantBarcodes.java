import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DistantBarcodes {
	public int[] rearrangeBarcodes(int[] barcodes) {
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

		int[] values = new int[10001];
		for (int i = 0; i < barcodes.length; i++) {
			values[barcodes[i]]++;
		}

		for (int i = 1; i <= 10000; i++) {
			if (values[i] != 0) {
				pq.offer(new int[] {values[i], i});
			}
		}

		int[] answer = new int[barcodes.length];
		int idx = 0;

		while (!pq.isEmpty()) {
			int size = pq.size() < 2 ? pq.size() : 2;

			List<int[]> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int[] current = pq.poll();
				answer[idx++] = current[1];
				current[0]--;
				if (current[0] > 0) {
					temp.add(current);
				}
			}

			pq.addAll(temp);
		}

		return answer;
	}
}
