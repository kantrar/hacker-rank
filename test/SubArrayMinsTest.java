import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SubArrayMinsTest {
	@Test
	public void test() {
		SubArrayMins s = new SubArrayMins();
		int result = s.sumSubarrayMins(new int[] {3, 1, 2, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(17));
	}
}