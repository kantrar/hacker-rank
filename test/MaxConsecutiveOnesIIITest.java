import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MaxConsecutiveOnesIIITest {
	@Test
	public void test() {
		MaxConsecutiveOnesIII m = new MaxConsecutiveOnesIII();
		int result;
		result = m.longestOnes(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(6));

		result = m.longestOnes(new int[] {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(10));

		result = m.longestOnes(new int[] {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 8);
		Assert.assertThat(result, CoreMatchers.equalTo(19));

		result = m.longestOnes(new int[] {1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(10));

		result = m.longestOnes(new int[] {1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(12));
	}
}