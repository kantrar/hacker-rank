import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CapacityToShipPackagesWithinDDaysTest {
	@Test
	public void test() {
		CapacityToShipPackagesWithinDDays c = new CapacityToShipPackagesWithinDDays();
		int result;

		result = c.shipWithinDays(new int[] {1, 1, 1, 1}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = c.shipWithinDays(new int[] {1, 2}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(3));

		result = c.shipWithinDays(new int[] {1, 2}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = c.shipWithinDays(new int[] {9, 10}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(10));

		result = c.shipWithinDays(new int[] {8, 9, 10}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(10));

		result = c.shipWithinDays(new int[] {6, 8, 9, 10}, 4);
		Assert.assertThat(result, CoreMatchers.equalTo(10));

		result = c.shipWithinDays(new int[] {6, 7, 8}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(13));

		result = c.shipWithinDays(new int[] {6, 7, 8, 9, 10}, 4);
		Assert.assertThat(result, CoreMatchers.equalTo(13));

		result = c.shipWithinDays(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
		Assert.assertThat(result, CoreMatchers.equalTo(15));
	}
}