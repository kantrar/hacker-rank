package AlgoExpert;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SubarraySortTest {
	@Test
	public void test() {
		int[] res;
		res = SubarraySort.subarraySort(new int[] {2, 1});
		Assert.assertThat(res, CoreMatchers.equalTo(new int[] {0, 1}));

		res = SubarraySort.subarraySort(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
		Assert.assertThat(res, CoreMatchers.equalTo(new int[] {3, 9}));
	}
}
