import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromeTest {
	@Test
	public void test() {
		LongestPalindrome l = new LongestPalindrome();
		String result = l.longestPalindrome("babad");
		Assert.assertThat(result, CoreMatchers.equalTo("aba"));
	}
}