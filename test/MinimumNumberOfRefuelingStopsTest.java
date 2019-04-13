import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MinimumNumberOfRefuelingStopsTest {
	@Test
	public void test() {
		int result;
		MinimumNumberOfRefuelingStops m = new MinimumNumberOfRefuelingStops();

		result = m.minRefuelStops(100, 50, new int[][] {{25, 25}, {50, 50}});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = m.minRefuelStops(100, 50, new int[][] {{25, 50}, {50, 25}});
		Assert.assertThat(result, CoreMatchers.equalTo(1));


		result = m.minRefuelStops(100, 25, new int[][] {{25, 25}, {50, 25}, {75, 25}});
		Assert.assertThat(result, CoreMatchers.equalTo(3));
	}
}