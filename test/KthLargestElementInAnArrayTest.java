import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class KthLargestElementInAnArrayTest {
	@Test
	public void test() {
		KthLargestElementInAnArray k = new KthLargestElementInAnArray();
		int result;
		result = k.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(5));
	}
}