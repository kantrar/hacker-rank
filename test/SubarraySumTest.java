import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SubarraySumTest {
	@Test
	public void test() {
		SubarraySum s = new SubarraySum();
		int result = s.subarraySum(new int[] {1, 2, 0, 1, 1, 1}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(5));
	}
}