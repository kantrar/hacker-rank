import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class InterleavingStringIITest {
	@Test
	public void test() {
		InterleavingStringII i = new InterleavingStringII();
		boolean result;
		result = i.isInterleave("a", "", "c");
		Assert.assertThat(result, CoreMatchers.equalTo(false));

		result = i.isInterleave("aabcc", "dbbca", "aadbbcbcac");
		Assert.assertThat(result, CoreMatchers.equalTo(true));
	}
}