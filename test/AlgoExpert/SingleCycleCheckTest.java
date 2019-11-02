package AlgoExpert;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SingleCycleCheckTest {
	@Test
	public void test() {
		boolean res;

		res = SingleCycleCheck.hasSingleCycle(new int[] {1, 2, 3, 4, -2, 3, 7, 8, -8});
		Assert.assertThat(res, CoreMatchers.equalTo(true));

		res = SingleCycleCheck.hasSingleCycle(new int[] {1, 2, 3, 4, -2, 3, 7, 8, -17});
		Assert.assertThat(res, CoreMatchers.equalTo(true));

		res = SingleCycleCheck.hasSingleCycle(new int[] {1, 2, 3, 4, -2, 3, 7, 8, -26});
		Assert.assertThat(res, CoreMatchers.equalTo(true));
	}
}
