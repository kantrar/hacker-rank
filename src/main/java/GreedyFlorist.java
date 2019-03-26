import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GreedyFlorist {
	static int getMinimumCost(int friends, int[] costs) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < friends; i++) {
			queue.add(1);
		}

		int totalCost = 0;
		Arrays.sort(costs);

		for (int i = costs.length - 1; i >= 0; i--) {
			int noOfPurchesedFlowers = queue.remove();
			totalCost += costs[i] * noOfPurchesedFlowers;
			queue.add(noOfPurchesedFlowers + 1);
		}

		return totalCost;
	}

	public static void main(String[] args) {
		int result = getMinimumCost(2, new int[] {2, 5, 6});
		System.out.println(result);
	}
}
