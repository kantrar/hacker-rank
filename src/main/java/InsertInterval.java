public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		return null;
	}

	public int findTheFirstInterval(int[][] intervals, int[] newInterval) {
		int low = 0;
		int high = intervals.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (intervals[mid][0] == newInterval[0]) {
				return mid;
			} else if (intervals[mid][0] > newInterval[0]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

	public int findTheLastInterval(int[][] intervals, int[] newInterval) {
		int low = 0;
		int high = intervals.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (intervals[mid][1] == newInterval[1]) {
				return mid;
			} else if (intervals[mid][1] > newInterval[1]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}
}
