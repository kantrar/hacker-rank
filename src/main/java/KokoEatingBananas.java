public class KokoEatingBananas {
	public int minEatingSpeed(int[] piles, int H) {
		if (H < piles.length) {
			return 0;
		}

		int max = 0;
		int total = 0;
		for (int i = 0; i < piles.length; i++) {
			total += piles[i]/ H;
			max = Math.max(max, piles[i]);
		}

		int minBound = total / H;
		int maxBound = (int) Math.ceil(max / Math.floor(H / piles.length));

		return binarySearch(piles, minBound, maxBound, H);
	}

	public int binarySearch(int[] piles, int minBound, int maxBound, int H) {
		int mid = minBound + (maxBound - minBound) / 2;

		while (minBound <= maxBound) {
			int cmp = isPossible(piles, mid, H);
			if (cmp > 0) {
				minBound = mid + 1;
			} else {
				maxBound = mid - 1;
			}
			mid = minBound + (maxBound - minBound) / 2;
		}

		return minBound;
	}

	public int isPossible(int[] piles, int speed, int H) {
		int total = 0;
		for (int i = 0; i < piles.length; i++) {
			total += (int) Math.ceil((double) piles[i] / speed);
		}

		return total == H ? 0 : (total > H ? 1 : -1);
	}
}
