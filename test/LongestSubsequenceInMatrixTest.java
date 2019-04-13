import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class LongestSubsequenceInMatrixTest {
	@Test
	public void test() {
		LongestSubsequenceInMatrix c = new LongestSubsequenceInMatrix();
		int[][] input;
		List<Integer> answers;

		input = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		answers = c.longestSubsequence(input);
		Assert.assertThat(answers, CoreMatchers.equalTo(Arrays.asList(1, 5, 9, 10, 11, 12)));

		input = new int[][] {{1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6}};
		answers = c.longestSubsequence(input);
		Assert.assertThat(answers, CoreMatchers.equalTo(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
	}
}