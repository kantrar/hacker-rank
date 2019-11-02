import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class InterleaveStringTest {
	@Test
	public void test() {
		InterleaveString i = new InterleaveString();
		boolean result;
		result = i.isInterleave("a", "b", "a");
		Assert.assertThat(result, CoreMatchers.equalTo(false));

		result = i.isInterleave("a", "b", "ab");
		Assert.assertThat(result, CoreMatchers.equalTo(true));

		result = i.isInterleave("a", "b", "ba");
		Assert.assertThat(result, CoreMatchers.equalTo(true));

		result = i.isInterleave("aabcc", "dbbca", "aadbbcbcac");
		Assert.assertThat(result, CoreMatchers.equalTo(true));
	}
}
