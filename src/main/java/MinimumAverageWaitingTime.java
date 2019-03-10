import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class MinimumAverageWaitingTime {
	private static class Order {
		int orderTime;
		int cookingTime;

		public Order(int orderTime, int cookingTime) {
			this.orderTime = orderTime;
			this.cookingTime = cookingTime;
		}

		public int getCookingTime() {
			return cookingTime;
		}

		public int getOrderTime() {
			return orderTime;
		}
	}

	static long minimumAverage(int[][] customers) {
		long sumWaitingTime = 0;

		Map<Integer, List<Order>> orderMap = new TreeMap<>();
		Queue<Order> cookingTimeQueue = new PriorityQueue<>(Comparator.comparingInt(Order::getCookingTime));
		Queue<Integer> timeQueue = new PriorityQueue<>();

		for (int i = 0; i < customers.length; i++) {
			int orderTime = customers[i][0];
			int cookingTime = customers[i][1];

			Order newOrder = new Order(orderTime, cookingTime);
			List<Order> currentOrders = orderMap.getOrDefault(orderTime, new ArrayList<>());
			currentOrders.add(newOrder);
			orderMap.put(orderTime, currentOrders);
		}

		int finishTime = 0;

		timeQueue.addAll(orderMap.keySet());
		while (!timeQueue.isEmpty()) {
			int time = timeQueue.remove();

			List<Order> orderAtCurrentTime = orderMap.getOrDefault(time, null);
			if (orderAtCurrentTime != null) {
				cookingTimeQueue.addAll(orderAtCurrentTime);
			}

			while (!cookingTimeQueue.isEmpty() && time >= finishTime) {
				Order currentOrder = cookingTimeQueue.remove();
				sumWaitingTime += (time + currentOrder.cookingTime) - currentOrder.orderTime;
				finishTime = time + currentOrder.cookingTime;
				timeQueue.add(finishTime);
			}

			time++;
		}

		return sumWaitingTime / (long) customers.length;
	}

}
