package AlgoExpert;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PalindromePartitioningMinCutsTest {
	@Test
	public void test() {
		assertResult("ababbbabbababa", 3);
		assertResult("noonabbad", 2);
	}

	private void assertResult(String input, int expected) {
		int res = PalindromePartitioningMinCuts.palindromePartitioningMinCuts(input);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}
