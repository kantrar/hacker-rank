import org.junit.Test;

public class MergeSortTest {
	@Test
	public void test() {
		int[] arr = {511, 152, 120, 98, 12};
		MergeSort.sort(arr);
		printArr(arr);

		int[] arr2 = {11, 152, 120, 98, 12, 3000, 12, 19, 19, 16, 85};
		MergeSort.sortDesc(arr2);
		printArr(arr2);
	}

	private void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");

		}
		System.out.println();
	}
}