public class CapacityToShipPackagesWithinDDays {
	public int shipWithinDays(int[] weights, int D) {
		int min = 0, max = 0;
		for (int i = 0; i < weights.length; i++) {
			min = Math.max(min, weights[i]);
			max += weights[i];
		}

		while (min < max) {
			int mid = (min + max) / 2;
			if (isShippable(mid, weights, D)) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		return min;
	}

	public boolean isShippable(int originalCapacity, int[] weights, int days) {
		int capacity = originalCapacity;

		for (int i = 0; i < weights.length; i++) {
			if (capacity >= weights[i]) {
				capacity -= weights[i];
			} else {
				if (--days <= 0) {
					return false;
				}
				capacity = originalCapacity - weights[i];
				if (capacity < 0) {
					return false;
				}
			}
		}
		return true;
	}

}
