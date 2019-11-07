import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MinimumRemoveToMakeValidParenthesesTest {
	@Test
	public void test() {
		MinimumRemoveToMakeValidParentheses m = new MinimumRemoveToMakeValidParentheses();
		String res;
		res = m.minRemoveToMakeValid("a)b(c)d");
		Assert.assertThat(res, CoreMatchers.equalTo("ab(c)d"));

		res = m.minRemoveToMakeValid("))((");
		Assert.assertThat(res, CoreMatchers.equalTo(""));

		res = m.minRemoveToMakeValid("))(");
		Assert.assertThat(res, CoreMatchers.equalTo(""));

		res = m.minRemoveToMakeValid(")((((");
		Assert.assertThat(res, CoreMatchers.equalTo(""));
	}
}
