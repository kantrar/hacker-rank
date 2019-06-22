import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest {
	@Test
	public void test() {
		SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
		int result;

		result = s.search(new int[] {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 0, 1, 2}, 12);
		Assert.assertThat(result, CoreMatchers.equalTo(8));

		result = s.search(new int[] {4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2}, 0);
		Assert.assertThat(result, CoreMatchers.equalTo(8));


		result = s.search(new int[] {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, -4, -3, -2, -1, 0, 1, 2}, 0);
		Assert.assertThat(result, CoreMatchers.equalTo(14));

		result = s.search(new int[] {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, -4, -3, -2, -1, 0, 1, 2}, 4);
		Assert.assertThat(result, CoreMatchers.equalTo(14));

		result = s.search(new int[] {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, -4, -3, -2, -1, 0, 1, 2}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(14));

		result = s.search(new int[] {-4, -3, -2, -1, 0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, -3);
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = s.search(new int[] {-4, -3, -2, -1, 0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, -4);
		Assert.assertThat(result, CoreMatchers.equalTo(0));
	}
}