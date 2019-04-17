import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class DecodeStringTest {
	@Test
	public void test() {
		DecodeString decodeString = new DecodeString();
		String result;
//		result = decodeString.decodeString("abc");
//		Assert.assertThat(result, CoreMatchers.equalTo("abc"));

		result = decodeString.decodeString("3[a]2[bc]");
		Assert.assertThat(result, CoreMatchers.equalTo("aaabcbc"));

		result = decodeString.decodeString("3[a2[c]]");
		Assert.assertThat(result, CoreMatchers.equalTo("accaccacc"));
	}
}