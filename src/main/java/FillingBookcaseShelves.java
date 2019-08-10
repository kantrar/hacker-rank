public class FillingBookcaseShelves {
	public int minHeightShelves(int[][] books, int shelfWidth) {
		if (books == null || books.length == 0 || books[0].length == 0) {
			return 0;
		}

		Integer[] memo = new Integer[books.length];
		return findMin(books, 0, shelfWidth, memo);
	}

	public int findMin(int[][] books, int pos, int maxWidth, Integer[] memo) {
		if (pos >= books.length) {
			return 0;
		}

		if (memo[pos] != null) {
			return memo[pos];
		}

		int width = 0;
		int currentHeight = 0;
		int totalHeight = Integer.MAX_VALUE;
		for (int i = pos; i < books.length && width + books[i][0] <= maxWidth; i++) {
			currentHeight = Math.max(currentHeight, books[i][1]);
			width += books[i][0];

			totalHeight = Math.min(totalHeight, currentHeight + findMin(books, i + 1, maxWidth, memo));
		}

		if (totalHeight == Integer.MAX_VALUE) {
			totalHeight = currentHeight;
		}

		memo[pos] = totalHeight;

		return totalHeight;
	}
}
