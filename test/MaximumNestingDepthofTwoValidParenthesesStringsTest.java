import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MaximumNestingDepthofTwoValidParenthesesStringsTest {
	MaximumNestingDepthofTwoValidParenthesesStrings m = new MaximumNestingDepthofTwoValidParenthesesStrings();
	int[] res;

	@Test
	public void testSimple() {
		assertResult("", new int[] {});
		assertResult("()", new int[] {0, 0});
	}

	private void assertResult(String s, int[] expected) {
		res = m.maxDepthAfterSplit(s);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}

	@Test
	public void testNested() {
		assertResult("(())", new int[] {1, 0, 0, 1});
		assertResult("((()))", new int[] {1, 0, 0, 0, 0, 1});
		assertResult("(((())))", new int[] {1, 1, 0, 0, 0, 0, 1, 1});
		assertResult("(((()()())))", new int[] {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1});
		assertResult("(((()()())))", new int[] {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1});
	}

	@Test
	public void testSeperated() {
		assertResult("()()", new int[] {0, 0, 0, 0});
		assertResult("()()()", new int[] {0, 0, 0, 0, 0, 0});
	}

	@Test
	public void testNestedAndSeparated() {
		assertResult("()(())()", new int[] {0, 0, 1, 0, 0, 1, 0, 0});
		assertResult("(())(())", new int[] {1, 0, 0, 1, 1, 0, 0, 1});
		assertResult("(())(((())))", new int[] {1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1});

		assertResult("((()))(()()())", new int[] {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1});

		assertResult("(()((()))(((((()))))))", new int[] {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1});
	}
}