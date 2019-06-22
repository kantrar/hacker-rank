import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromeSubsequenceTest {
	@Test
	public void test() {
		LongestPalindromeSubsequence l = new LongestPalindromeSubsequence();
		int result;
		result = l.longestPalindromeSubseq("bbbab");
		Assert.assertThat(result, CoreMatchers.equalTo(4));

		result = l.longestPalindromeSubseq("abcabcabcabc");
		Assert.assertThat(result, CoreMatchers.equalTo(7));
	}
}