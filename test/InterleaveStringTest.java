import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class InterleaveStringTest {
	@Test
	public void test() {
		InterleaveString i = new InterleaveString();
		boolean result = i.isInterleave("aabcc", "dbbca", "aadbbcbcac");
		Assert.assertThat(result, CoreMatchers.equalTo(true));
	}
}