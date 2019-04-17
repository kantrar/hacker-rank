import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ShortestPalindromeTest {
	@Test
	public void test() {
		ShortestPalindrome s = new ShortestPalindrome();
		String result = s.shortestPalindrome("aacecaaa");
		Assert.assertThat(result, CoreMatchers.equalTo("aaacecaaa"));
	}
}
