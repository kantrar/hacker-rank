import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class MinimizeMaxDistanceToGasStationTest {
	@Test
	public void test() {
		MinimizeMaxDistanceToGasStation m = new MinimizeMaxDistanceToGasStation();
		double result = m.minmaxGasDist(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9);
		Assert.assertThat(result, Matchers.closeTo(0.5, .01));
	}
}