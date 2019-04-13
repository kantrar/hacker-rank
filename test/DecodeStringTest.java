import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class DecodeStringTest {
	@Test
	public void test() {
		DecodeString decodeString = new DecodeString();
		String result;
		result = decodeString.decodeString("abc");
		Assert.assertThat(result, CoreMatchers.equalTo("abc"));
	}
}