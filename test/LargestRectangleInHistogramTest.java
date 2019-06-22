import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class LargestRectangleInHistogramTest {
	@Test
	public void test() {
		LargestRectangleInHistogram l = new LargestRectangleInHistogram();
		int result;
//		result = l.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3});
//		Assert.assertThat(result, CoreMatchers.equalTo(10));

		result = l.largestRectangleArea(new int[] {9, 0});
		Assert.assertThat(result, CoreMatchers.equalTo(9));
	}
}