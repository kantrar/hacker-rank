import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SwapForLongestRepeatedCharacterSubstringTest {
	SwapForLongestRepeatedCharacterSubstring s = new SwapForLongestRepeatedCharacterSubstring();
	int result;

	@Test
	public void test() {
		assertResult("aabaaabaaaba", 7);
		assertResult("", 0);
		assertResult("ababa", 3);
		assertResult("a", 1);
		assertResult("ab", 1);
		assertResult("aaabaaa", 6);
		assertResult("aaabbaaa", 4);
		assertResult("aaaaa", 5);
		assertResult("abcdef", 1);
		assertResult("aaaabaabaaaaaaaaaaaa", 15);
		assertResult("aaaabacada", 6);
	}

	private void assertResult(String input, int expected) {
		result = s.maxRepOpt1(input);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}