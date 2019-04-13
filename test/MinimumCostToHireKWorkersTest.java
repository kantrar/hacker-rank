import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class MinimumCostToHireKWorkersTest {
	@Test
	public void test() {
		MinimumCostToHireKWorkers m = new MinimumCostToHireKWorkers();
		double result = m.mincostToHireWorkers(new int[] {10, 20, 5}, new int[] {70, 50, 30}, 2);
		Assert.assertThat(result, Matchers.closeTo(105, 0.01));

	}
}