import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayTest {
	@Test
	public void test() {
		RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
		int idx;
		idx = r.removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
		Assert.assertThat(idx, CoreMatchers.equalTo(5));

		idx = r.removeDuplicates(new int[] {1, 1, 2});
		Assert.assertThat(idx, CoreMatchers.equalTo(2));
	}
}