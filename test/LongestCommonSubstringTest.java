import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubstringTest {
	@Test
	public void test() {
		LongestCommonSubstring l = new LongestCommonSubstring();
		int result;
		result = l.longestCommonSubstring("ABCDGH", "ACDGHR");
		Assert.assertThat(result, CoreMatchers.equalTo(4));

		result = l.longestCommonSubstring("ABC", "AC");
		Assert.assertThat(result, CoreMatchers.equalTo(1));
	}
}