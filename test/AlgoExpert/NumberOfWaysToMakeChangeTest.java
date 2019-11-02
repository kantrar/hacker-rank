package AlgoExpert;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NumberOfWaysToMakeChangeTest {
	@Test
	public void test() {
		int res;
		res = NumberOfWaysToMakeChange.numberOfWaysToMakeChange(6, new int[] {1, 5});
		Assert.assertThat(res, CoreMatchers.equalTo(2));
	}
}
