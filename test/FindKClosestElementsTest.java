import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class FindKClosestElementsTest {
	@Test
	public void test() {
		FindKClosestElements f = new FindKClosestElements();
		List<Integer> result;
		result = f.findClosestElements(new int[] {0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5);
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(3, 3, 4)));

		result = f.findClosestElements(new int[] {1, 2, 3, 4, 5}, 4, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(1, 2, 3, 4)));

	}
}