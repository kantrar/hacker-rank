import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class DistinctSubsequencesTest {
	DistinctSubsequences d = new DistinctSubsequences();
	int res;

	@Test
	public void test() {
//		assertResult("abca", 14);
		assertResult("abcaa", 21);
		assertResult("abcaaa", 28);
	}

	private void assertResult(String input, int expected) {
		res = d.distinctSubseqII(input);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}