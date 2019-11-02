package AlgoExpert;

public class HeapSort {
	public static int[] heapSort(int[] array) {
		buildMaxHeap(array);
		for (int i = array.length - 1; i >= 0; i--) {
			swap(array, 0, i);
			siftDown(array, 0, i);
		}
		return array;
	}

	private static void siftDown(int[] array, int cur, int end) {
		while (cur < end) {
			int toSwap = cur;
			int leftChild = cur * 2 + 1;
			if (leftChild < end) {
				toSwap = array[toSwap] < array[leftChild] ? leftChild : toSwap;
			}
			int rightChild = cur * 2 + 2;
			if (rightChild < end) {
				toSwap = array[toSwap] < array[rightChild] ? rightChild : toSwap;
			}

			if (toSwap == cur) {
				return;
			}

			swap(array, cur, toSwap);
			cur = toSwap;
		}
	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	private static void buildMaxHeap(int[] array) {
		int firstParentIndex = array.length / 2 - 1;
		for (int i = firstParentIndex; i >= 0; i--) {
			siftDown(array, i, array.length);
		}
	}

}
