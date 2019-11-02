import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class GetEqualSubstringWithinBudgetTest {
	@Test
	public void test() {
		GetEqualSubstringWithinBudget g = new GetEqualSubstringWithinBudget();
		int res;
		//		res = g.equalSubstring("abcd", "cdef", 3);
		//		Assert.assertThat(res, CoreMatchers.equalTo(1));
		//
		//		res = g.equalSubstring("abcd", "acde", 0);
		//		Assert.assertThat(res, CoreMatchers.equalTo(1));

		res = g.equalSubstring("abcdefgh", "fhidefhi", 10);
		Assert.assertThat(res, CoreMatchers.equalTo(6));
	}
}
