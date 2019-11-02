import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class LengthOfLongestFibonacciSequenceTest {
	@Test
	public void test() {
		LengthOfLongestFibonacciSequence l = new LengthOfLongestFibonacciSequence();
		int result = l.lenLongestFibSubseq(new int[] {2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50});
		Assert.assertThat(result, CoreMatchers.equalTo(5));
	}
}