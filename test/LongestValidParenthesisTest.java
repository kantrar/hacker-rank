import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class LongestValidParenthesisTest {
	@Test
	public void test() {
		LongestValidParenthesis l = new LongestValidParenthesis();
		int res = l.longestValidParentheses("()()()(((())))");
		Assert.assertThat(res, CoreMatchers.equalTo(14));
	}
}
