import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SherlockAndCostTest {
	@Test
	public void test() {
		long result = SherlockAndCost.cost(new int[] {1, 1, 1, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(0L));

		result = SherlockAndCost.cost(new int[] {1, 2, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(5L));

		result = SherlockAndCost.cost(new int[] {1, 4, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(9L));

		result = SherlockAndCost.cost(new int[] {1, 200, 10, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(199L + 199L + 3L));

		result = SherlockAndCost.cost(new int[] {1, 3, 10, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(18L));

		result = SherlockAndCost.cost(new int[] {2, 3, 10, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(19L));

		result = SherlockAndCost.cost(new int[] {100, 50, 20, 10});
		Assert.assertThat(result, CoreMatchers.equalTo(99L + 19L + 19L));

		result = SherlockAndCost.cost(new int[] {10, 10, 2, 10});
		Assert.assertThat(result, CoreMatchers.equalTo(27L));

		result = SherlockAndCost.cost(new int[] {2, 4, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(6L));

		result = SherlockAndCost.cost(new int[] {100, 2, 100, 2, 100});
		Assert.assertThat(result, CoreMatchers.equalTo(396L));

		result = SherlockAndCost.cost(new int[] {300, 100, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(299L));

		result = SherlockAndCost.cost(new int[] {1000, 300, 100, 20});
		Assert.assertThat(result, CoreMatchers.equalTo(999L + 99L + 99L));

		result = SherlockAndCost.cost(new int[] {1});
		Assert.assertThat(result, CoreMatchers.equalTo(0L));

		result = SherlockAndCost.cost(new int[] {55, 68, 31, 80, 57, 18, 34, 28, 76, 55});
		Assert.assertThat(result, CoreMatchers.equalTo(508L));
	}
}