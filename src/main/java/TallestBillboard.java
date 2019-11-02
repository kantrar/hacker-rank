import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TallestBillboard {
	public int tallestBillboard(int[] rods) {
		List<Integer> sum = new ArrayList<>();
		return find(rods, 0, 0, sum);
	}

	private int find(int[] rods, int pos, int acc, List<Integer> sum) {
		int max = 0;
		if (acc % 2 == 0) {
			int target = acc / 2;
			Set<Integer> prefixSum = new HashSet<>();
			for (int i = 0; i < sum.size(); i++) {
				if (prefixSum.contains(sum.get(i) - target)) {
					max = target;
					break;
				}
				prefixSum.add(sum.get(i));
			}
		}
		for (int i = pos; i < rods.length; i++) {
			int newAcc = acc + rods[i];
			sum.add(newAcc);
			max = Math.max(max, find(rods, i + 1, newAcc, sum));
			sum.remove(sum.size() - 1);
		}
		return max;
	}
}
