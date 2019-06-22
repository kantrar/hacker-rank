import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TrappingRainWaterIITest {
	@Test
	public void test() {
		TrappingRainWaterII t = new TrappingRainWaterII();
		int result = t.trapRainWater(new int[][] {
				{1, 4, 3, 1, 3, 2},
				{3, 2, 1, 3, 2, 4},
				{2, 3, 3, 2, 3, 1}});
		Assert.assertThat(result, CoreMatchers.equalTo(4));
	}
}