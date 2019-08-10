import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SplitArrayIntoFibonacciSequenceTest {
	@Test
	public void test() {
		SplitArrayIntoFibonacciSequence s = new SplitArrayIntoFibonacciSequence();
		List<Integer> res;
		res = s.splitIntoFibonacci("0123");
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList()));
		res = s.splitIntoFibonacci("123456579");
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList(123, 456, 579)));
	}
}