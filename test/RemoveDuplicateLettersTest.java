import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicateLettersTest {
	@Test
	public void test() {
		RemoveDuplicateLetters r = new RemoveDuplicateLetters();
		String result;

		result = r.removeDuplicateLetters("bddbccd");
		Assert.assertThat(result, CoreMatchers.equalTo("bcd"));

		result = r.removeDuplicateLetters("cbacdcbc");
		Assert.assertThat(result, CoreMatchers.equalTo("acdb"));

	}
}