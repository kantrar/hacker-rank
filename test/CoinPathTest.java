import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CoinPathTest {
	@Test
	public void test() {
		CoinPath c = new CoinPath();
		List<Integer> result;

		result = c.cheapestJump(new int[] {1, 2, 4, -1, 2}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(1, 3, 5)));
	}
}