import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
	@Test
	public void test() {
		Assert.assertThat(BinarySearch.search(new int[] {1, 2, 3, 4, 5, 6}, 1), CoreMatchers.equalTo(0));
		Assert.assertThat(BinarySearch.search(new int[] {1, 2, 3, 4, 5, 6}, 2), CoreMatchers.equalTo(1));
		Assert.assertThat(BinarySearch.search(new int[] {1, 2, 3, 4, 5, 6}, 3), CoreMatchers.equalTo(2));
		Assert.assertThat(BinarySearch.search(new int[] {1, 2, 3, 4, 5, 6}, 4), CoreMatchers.equalTo(3));
		Assert.assertThat(BinarySearch.search(new int[] {1, 2, 3, 4, 5, 6}, 5), CoreMatchers.equalTo(4));
		Assert.assertThat(BinarySearch.search(new int[] {1, 2, 3, 4, 5, 6}, 6), CoreMatchers.equalTo(5));
		Assert.assertThat(BinarySearch.search(new int[] {1, 2, 3, 4, 5, 6}, 0), CoreMatchers.equalTo(-1));
		Assert.assertThat(BinarySearch.search(new int[] {1, 2, 3, 4, 5, 6}, 7), CoreMatchers.equalTo(-1));

		Assert.assertThat(BinarySearch.search(new int[] {1, 1, 3, 5, 8, 9, 11, 12, 12, 14}, 14), CoreMatchers.equalTo(9));
		Assert.assertThat(BinarySearch.search(new int[] {1, 1, 3, 5, 8, 9, 11, 12, 12, 14}, 12), CoreMatchers.equalTo(7));
		Assert.assertThat(BinarySearch.search(new int[] {1, 1, 3, 5, 8, 9, 11, 12, 12, 14}, 3), CoreMatchers.equalTo(2));
		Assert.assertThat(BinarySearch.search(new int[] {1, 1, 3, 5, 8, 9, 11, 12, 12, 14}, 1), CoreMatchers.equalTo(0));

		Assert.assertThat(BinarySearch.search(new int[] {1, 1, 3, 5, 8, 9, 11, 12, 12, 14}, 12), CoreMatchers.equalTo(7));

		Assert.assertThat(BinarySearch.search(new int[] {1, 1, 3, 5, 8, 9, 11, 12, 12, 14, 14}, 14), CoreMatchers.equalTo(9));
	}
}