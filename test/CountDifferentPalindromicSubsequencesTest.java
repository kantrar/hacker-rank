import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CountDifferentPalindromicSubsequencesTest {
	@Test
	public void test() {
		CountDifferentPalindromicSubsequences c = new CountDifferentPalindromicSubsequences();

		int res;
		res = c.countPalindromicSubsequences("baab");
		Assert.assertThat(res, CoreMatchers.equalTo(6));
		res = c.countPalindromicSubsequences("abaaba");
		Assert.assertThat(res, CoreMatchers.equalTo(12));
	}
}
