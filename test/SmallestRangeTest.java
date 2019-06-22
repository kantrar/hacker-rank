import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SmallestRangeTest {
	@Test
	public void test() {
		SmallestRange s = new SmallestRange();
		int[] result;
		result = s.smallestRange(Arrays.asList(Arrays.asList(4, 5), Arrays.asList(9, 10)));
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {5, 9}));

		result = s.smallestRange(Arrays.asList(Arrays.asList(4, 6), Arrays.asList(6, 10)));
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {6, 6}));

		result = s.smallestRange(Arrays.asList(Arrays.asList(4, 6), Arrays.asList(6, 7)));
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {6, 6}));

		result = s.smallestRange(Arrays.asList(Arrays.asList(4, 6, 9), Arrays.asList(1, 8, 13)));
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {8, 9}));

		result = s.smallestRange(Arrays.asList(Arrays.asList(4, 6, 9), Arrays.asList(1, 8, 13), Arrays.asList(14, 19, 20, 26)));
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {9, 14}));

		result = s.smallestRange(Arrays.asList(Arrays.asList(4, 9), Arrays.asList(1, 9, 13), Arrays.asList(14, 19, 20, 26)));
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {9, 14}));

		result = s.smallestRange(Arrays.asList(Arrays.asList(1, 4, 13), Arrays.asList(1, 9, 13), Arrays.asList(14, 19, 20, 26)));
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {13, 14}));
	}
}