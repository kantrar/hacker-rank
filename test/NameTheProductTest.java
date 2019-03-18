import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NameTheProductTest {
	@Test
	public void test() {
		String result = NameTheProduct.productName(Arrays.asList("ready", "stedy"));
		Assert.assertThat(result, CoreMatchers.equalTo("aabaa"));
	}
}