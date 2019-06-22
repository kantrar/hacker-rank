import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class LongestArithmeticSequenceTest {
	@Test
	public void test() {
		LongestArithmeticSequence l = new LongestArithmeticSequence();
		int result = l.longestArithSeqLength(
				new int[] {44, 46, 22, 68, 45, 66, 43, 9, 37, 30, 50, 67, 32, 47, 44, 11, 15, 4, 11, 6, 20, 64, 54, 54, 61, 63,
						23, 43, 3, 12, 51, 61, 16, 57, 14, 12, 55, 17, 18, 25, 19, 28, 45, 56, 29, 39, 52, 8, 1, 21, 17, 21, 23,
						70, 51, 61, 21, 52, 25, 28});
		Assert.assertThat(result, CoreMatchers.equalTo(6));
	}
}