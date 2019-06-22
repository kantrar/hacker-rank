import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SplitArrayIntoConsecutiveSubsequencesTest {
	@Test
	public void test() {
		SplitArrayIntoConsecutiveSubsequences s = new SplitArrayIntoConsecutiveSubsequences();
		boolean result;
		result = s.isPossible(new int[] {3, 4, 4, 5, 6, 7, 8, 9, 10, 11});
		Assert.assertThat(result, CoreMatchers.equalTo(false));

		result = s.isPossible(new int[] {1, 2, 3, 6, 7, 8, 9});
		Assert.assertThat(result, CoreMatchers.equalTo(true));

		result = s.isPossible(new int[] {1, 2, 6, 7, 8, 9});
		Assert.assertThat(result, CoreMatchers.equalTo(false));

		result = s.isPossible(new int[] {1, 2, 3, 4, 6, 7, 8, 9, 10, 11});
		Assert.assertThat(result, CoreMatchers.equalTo(true));

		result = s.isPossible(new int[] {1, 2, 3, 4, 4, 5});
		Assert.assertThat(result, CoreMatchers.equalTo(false));

		result = s.isPossible(new int[] {1, 2, 3, 3, 4, 5});
		Assert.assertThat(result, CoreMatchers.equalTo(true));

	}
}