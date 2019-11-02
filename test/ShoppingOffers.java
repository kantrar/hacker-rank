import java.util.ArrayList;
import java.util.List;

public class ShoppingOffers {
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		return helper(price, special, needs, 0);
	}
	private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
		int min = directPurchase(price, needs);
		for (int i = pos; i < special.size(); i++) {
			boolean canUse = true;
			List<Integer> updated = new ArrayList<>(needs);
			for (int j = 0; j < needs.size(); j++) {
				if (needs.get(j) < special.get(i).get(j)) {
					canUse = false;
					break;
				}
				updated.set(j, needs.get(j) - special.get(i).get(j));
			}
			if (canUse) {
				min = Math.min(min, special.get(i).get(updated.size()) + helper(price, special, updated, pos));
			}
		}
		return min;
	}

	private int directPurchase(List<Integer> price, List<Integer> needs) {
		int total = 0;
		for (int i = 0; i < price.size(); i++) {
			total += (price.get(i) * needs.get(i));
		}
		return total;
	}
}
