import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class KSimilarStringsTest {
	KSimilarStrings k = new KSimilarStrings();
	int result;

	@Test
	public void test() {
		assertResult("", "", 0);
		assertResult("b", "b", 0);
		assertResult("ab", "ba", 1);
		assertResult("abc", "bca", 2);
		assertResult("abc", "bac", 1);
		assertResult("abc", "cba", 1);
		assertResult("abac", "baca", 2);
		assertResult("aabc", "abca", 2);
		assertResult("abced", "bcade", 3);
		assertResult("bccaba", "abacbc", 3);
	}

	private void assertResult(String A, String B, int expected) {
		result = k.kSimilarity(A, B);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}
