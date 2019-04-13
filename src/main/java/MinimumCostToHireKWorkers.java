import java.util.List;
import java.util.Stack;

public class MinimumCostToHireKWorkers {
	public double mincostToHireWorkers(int[] quality, int[] wage, int required) {
		return hireWorkers(quality, wage, required, 0, new Stack<>());
	}

	public double hireWorkers(int[] quality, int[] wage, int required, int pos, Stack<Integer> workers) {

		if (required == workers.size()) {
			return getCost(quality, wage, workers);
		}

		if (pos > quality.length) {
			return -1;
		}

		if (required - workers.size() > quality.length - pos) {
			return -1;
		}

		workers.push(pos);
		double cost1 = hireWorkers(quality, wage, required, pos + 1, workers);
		workers.pop();

		double cost2 = hireWorkers(quality, wage, required, pos + 1, workers);

		if (cost1 == -1 && cost2 == -1) {
			return -1;
		}

		if (cost1 == -1) {
			return cost2;
		}

		if (cost2 == -1) {
			return cost1;
		}

		return Math.min(cost1, cost2);
	}

	public double getCost(int[] quality, int[] wage, List<Integer> workers) {
		double cost = 0;

		double maxRatio = 0;
		int maxIdx = 0;
		for (int i = 0; i < workers.size(); i++) {
			int idx = workers.get(i);
			double ratio = (double) wage[idx] / quality[idx];
			if (maxRatio < ratio) {
				maxRatio = ratio;
				maxIdx = i;
			}
		}

		for (int i = 0; i < workers.size(); i++) {
			int idx = workers.get(i);
			double ratio = (double) wage[idx] / quality[idx];
			cost += (maxRatio * wage[idx]) / ratio;
		}

		return cost;
	}
}
