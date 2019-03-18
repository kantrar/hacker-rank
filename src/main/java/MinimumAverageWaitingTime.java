import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class MinimumAverageWaitingTime {
	private static class Order {
		long orderTime;
		long cookingTime;
		boolean done;

		public Order(long orderTime, long cookingTime) {
			this.orderTime = orderTime;
			this.cookingTime = cookingTime;
		}

		public long getCookingTime() {
			return cookingTime;
		}
	}

	static long minimumAverage(int[][] customers) {
		long sumWaitingTime = 0;

		Map<Long, List<Order>> orderMap = new TreeMap<>();
		Queue<Order> cookingTimeQueue = new PriorityQueue<>(Comparator.comparingLong(Order::getCookingTime));
		Queue<Long> timeQueue = new PriorityQueue<>();

		for (int i = 0; i < customers.length; i++) {
			long orderTime = customers[i][0];
			long cookingTime = customers[i][1];

			Order newOrder = new Order(orderTime, cookingTime);
			List<Order> currentOrders = orderMap.getOrDefault(orderTime, new ArrayList<>());
			currentOrders.add(newOrder);
			orderMap.put(orderTime, currentOrders);
		}

		long finishTime = 0;

		timeQueue.addAll(orderMap.keySet());
		while (!timeQueue.isEmpty()) {
			long time = timeQueue.remove();

			List<Order> orderAtCurrentTime = orderMap.getOrDefault(time, null);
			if (orderAtCurrentTime != null) {
				cookingTimeQueue.addAll(orderAtCurrentTime);
			}

			while (!cookingTimeQueue.isEmpty() && time >= finishTime) {
				Order currentOrder = cookingTimeQueue.remove();
				if (currentOrder.done) {
					break;
				}
				currentOrder.done = true;
				sumWaitingTime += (time + currentOrder.cookingTime) - currentOrder.orderTime;
				finishTime = time + currentOrder.cookingTime;
				timeQueue.add(finishTime);
			}

			time++;
		}

		return sumWaitingTime / (long) customers.length;
	}

}
