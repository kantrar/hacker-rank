package AlgoExpert;

import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingSubsequenceTest {
	ArrayList<Integer> res;

	@Test
	public void test() {
//		res = LongestIncreasingSubsequence.longestIncreasingSubsequence(new int[] {1, 2, 3, 4, 5});
//		Assert.assertThat(res, CoreMatchers.equalTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));

		res = LongestIncreasingSubsequence.longestIncreasingSubsequence(new int[] {1, 2, 3, 2, 5});
		Assert.assertThat(res, CoreMatchers.equalTo(new ArrayList<>(Arrays.asList(1, 2, 3, 5))));

		res = LongestIncreasingSubsequence.longestIncreasingSubsequence(new int[] {1, 7, 6, 3, 2, 3, 4, 2, 9, 4});
		Assert.assertThat(res, CoreMatchers.equalTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9))));
	}
}
