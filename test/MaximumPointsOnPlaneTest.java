import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MaximumPointsOnPlaneTest {
	@Test
	public void test() {
		int[][] input = {{-1, 1}, {0, 0}, {1, 1}, {2, 2}, {3, 3}, {3, 4}};
		int result = MaximumPointsOnPlane.findMaximumPoints(input);
		Assert.assertThat(result, CoreMatchers.equalTo(4));
	}
}