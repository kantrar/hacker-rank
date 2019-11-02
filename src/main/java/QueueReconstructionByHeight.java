import java.util.Arrays;

public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

		int[] inv = new int[people.length];
		for (int i = 0; i < inv.length; i++) {
			inv[i] = people[i][1];
		}
		mergeSort(people, inv, 0, inv.length - 1);
		return people;
	}

	private void mergeSort(int[][] people, int[] inv, int left, int right) {
		if (left >= right) return;
		int mid = left + (right - left) / 2;
		mergeSort(people, inv, left, mid);
		mergeSort(people, inv, mid + 1, right);
		merge(people, inv, left, mid, right);
	}

	private void merge(int[][] people, int[] inv, int left, int mid, int right) {
		int i = left, j = mid + 1, cur = 0;
		int[][] newPeople = new int[right - left + 1][2];
		int[] newInv = new int[right - left + 1];
		int rightCount = 0;

		while (i <= mid && j <= right) {
			if (inv[i] - rightCount < inv[j]) {
				newPeople[cur] = people[i];
				newInv[cur++] = inv[i++] - rightCount;
			} else if (inv[i] - rightCount > inv[j]) {
				newPeople[cur] = people[j];
				newInv[cur++] = inv[j++];
				rightCount++;
			} else {
				if (people[i][0] < people[j][0]) {
					newPeople[cur] = people[i];
					newInv[cur++] = inv[i++] - rightCount;
				} else {
					newPeople[cur] = people[j];
					newInv[cur++] = inv[j++];
					rightCount++;
				}
			}
		}
		while (i <= mid) {
			newPeople[cur] = people[i];
			newInv[cur++] = inv[i++] - rightCount;
		}
		while (j <= right) {
			newPeople[cur] = people[j];
			newInv[cur++] = inv[j++];
		}

		for (i = left; i <= right; i++) {
			people[i] = newPeople[i - left];
			inv[i] = newInv[i - left];
		}
	}

}
