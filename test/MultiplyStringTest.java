import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MultiplyStringTest {
	@Test
	public void test() {
		String result = MultiplyString.multiply("999", "999");
		Assert.assertThat(result, CoreMatchers.equalTo("998001"));
	}
}