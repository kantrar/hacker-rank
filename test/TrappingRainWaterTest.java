import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TrappingRainWaterTest {
	@Test
	public void test() {
		TrappingRainWater t = new TrappingRainWater();
		int result = t.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(6));
	}
}