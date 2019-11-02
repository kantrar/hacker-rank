import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ReverseSubstringBetweenEachPairOfParenthesesTest {
	ReverseSubstringBetweenEachPairOfParentheses r = new ReverseSubstringBetweenEachPairOfParentheses();
	String res;

	@Test
	public void test() {
		assertResult("abcd", "abcd");
		assertResult("(abcd)", "dcba");
		assertResult("(abcd(efg))", "efgdcba");
		assertResult("(abcd(efg)hij)", "jihefgdcba");
		assertResult("(ab)(cd)", "badc");
		assertResult("(u(love)i)", "iloveu");
		assertResult("(ed(et(oc))el)", "leetcode");
		assertResult("a(bcdefghijkl(mno)p)q", "apmnolkjihgfedcbq");
	}

	private void assertResult(String input, String expected) {
		res = r.reverseParentheses(input);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}
