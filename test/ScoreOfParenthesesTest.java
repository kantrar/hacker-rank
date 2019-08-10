import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ScoreOfParenthesesTest {
	ScoreOfParentheses s = new ScoreOfParentheses();
	int res;

	@Test
	public void test() {
		assertResult("", 0);
		assertResult("()", 1);
		assertResult("()()", 2);
		assertResult("(())", 2);
		assertResult("(())()", 3);
		assertResult("(())(())", 4);
		assertResult("(())()()", 4);
	}

	private void assertResult(String input, int expected) {
		Assert.assertThat(s.scoreOfParentheses(input), CoreMatchers.equalTo(expected));
	}
}