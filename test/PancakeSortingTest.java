import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PancakeSortingTest {
	@Test
	public void test() {
		PancakeSorting p = new PancakeSorting();
		List<Integer> answer;
		answer = p.pancakeSort(new int[] {3, 2, 4, 1});
		Assert.assertThat(answer, CoreMatchers.equalTo(Arrays.asList(2, 3, 1)));

		answer = p.pancakeSort(new int[] {5, 1, 3, 2, 4});
		Assert.assertThat(answer, CoreMatchers.equalTo(Arrays.asList(1, 5, 1, 4, 3, 3, 2, 2, 1, 1)));

	}
}