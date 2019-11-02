package AlgoExpert;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class HeapSortTest {
	@Test
	public void test() {
		int[] res;
		res = HeapSort.heapSort(new int[] {5, 2, 1, 4, 3});
		Assert.assertThat(res, CoreMatchers.equalTo(new int[] {1, 2, 3, 4, 5}));

		res = HeapSort.heapSort(new int[] {1, 2, 4, 5, 6});
		Assert.assertThat(res, CoreMatchers.equalTo(new int[] {1, 2, 4, 5, 6}));

		res = HeapSort.heapSort(new int[] {6, 5, 4, 2, 1});
		Assert.assertThat(res, CoreMatchers.equalTo(new int[] {1, 2, 4, 5, 6}));

		res = HeapSort.heapSort(new int[] {9, 1, 7, 6, 4, 23, 2, 5});
		Assert.assertThat(res, CoreMatchers.equalTo(new int[] {1, 2, 4, 5, 6, 7, 9, 23}));
	}
}
