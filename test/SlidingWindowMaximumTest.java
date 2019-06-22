import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SlidingWindowMaximumTest {
	@Test
	public void test() {
		SlidingWindowMaximum s = new SlidingWindowMaximum();
		int[] result;
		result = s.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {3, 3, 5, 5, 6, 7}));

		result = s.maxSlidingWindow(new int[] {1, 3, 1, 2, 0, 5}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {3, 3, 2, 5}));

	}
}