import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class BitwiseOrsOfSubarrayTest {
	@Test
	public void test() {
		BitwiseOrsOfSubarray b = new BitwiseOrsOfSubarray();
		int res = b.subarrayBitwiseORs(new int[] {});
		Assert.assertThat(res, CoreMatchers.equalTo(0));
	}
}