import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CountOfSmallerNumbersAfterSelfTest {
	CountOfSmallerNumbersAfterSelf c = new CountOfSmallerNumbersAfterSelf();
	List<Integer> result;

	@Test
	public void test() {
		result = c.countSmaller(new int[] {});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList()));

		result = c.countSmaller(new int[] {5});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(0)));

		result = c.countSmaller(new int[] {5, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(1, 0)));

		result = c.countSmaller(new int[] {2, 2, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(0, 0, 0)));

		result = c.countSmaller(new int[] {2, 3, 5});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(0, 0, 0)));

		result = c.countSmaller(new int[] {5, 2, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(2, 0, 0)));

		result = c.countSmaller(new int[] {5, 3, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(2, 1, 0)));

		result = c.countSmaller(new int[] {1, 2, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(0, 0, 0, 0)));

		result = c.countSmaller(new int[] {2, 4, 2, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(0, 2, 0, 0)));

		result = c.countSmaller(new int[] {2, 4, 2, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(0, 2, 0, 0)));

		result = c.countSmaller(new int[] {2, 1, 4, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(1, 0, 1, 0)));

		result = c.countSmaller(new int[] {1, 4, 2, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(0, 2, 0, 0)));

		result = c.countSmaller(new int[] {4, 3, 2, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(3, 2, 1, 0)));

		result = c.countSmaller(new int[] {6, 1, 7});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(1, 0, 0)));

		result = c.countSmaller(new int[] {5, 2, 6, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(2, 1, 1, 0)));

		result = c.countSmaller(new int[] {5, 2, 6, 1, 7});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(2, 1, 1, 0, 0)));

		result = c.countSmaller(new int[] {5, 2, 6, 1, 7, 8});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(2, 1, 1, 0, 0, 0)));

		result = c.countSmaller(new int[] {5, 2, 6, 1, 7, 8, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(4, 1, 3, 0, 2, 2, 0, 0)));
	}

	@Test
	public void testNegative() {
//		result = c.countSmaller(new int[] {0, -1});
//		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(1, 0)));

		result = c.countSmaller(new int[] {-1, 0});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(0, 0)));

	}
}
