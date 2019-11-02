import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class KthLargestElementInAnArrayTest {
	KthLargestElementInAnArray k = new KthLargestElementInAnArray();
	int result;

	@Test
	public void test() {

		result = k.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(6));

		result = k.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(5));

		result = k.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(4));

		result = k.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 4);
		Assert.assertThat(result, CoreMatchers.equalTo(3));

		result = k.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 5);
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = k.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 6);
		Assert.assertThat(result, CoreMatchers.equalTo(1));

	}

	@Test
	public void testDupArray() {
		int[] input = {3, 3, 3, 3, 3, 3, 3, 3};
		for (int i = 0; i < input.length; i++) {
			result = k.findKthLargest(input, i + 1);
			Assert.assertThat(result, CoreMatchers.equalTo(3));
		}
	}

	@Test
	public void testDupElements() {
		int[] input;

		input = new int[] {3, 2, 6, 4, 4, 5, 1};
		result = k.findKthLargest(input, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(6));

		input = new int[] {3, 2, 6, 4, 4, 5, 1};
		result = k.findKthLargest(input, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(5));

		input = new int[] {3, 2, 6, 4, 4, 5, 1};
		result = k.findKthLargest(input, 3);
		Assert.assertThat(result, CoreMatchers.equalTo(4));

		input = new int[] {3, 2, 6, 4, 4, 5, 1};
		result = k.findKthLargest(input, 4);
		Assert.assertThat(result, CoreMatchers.equalTo(4));

		input = new int[] {3, 2, 6, 4, 4, 5, 1};
		result = k.findKthLargest(input, 5);
		Assert.assertThat(result, CoreMatchers.equalTo(3));

		input = new int[] {3, 2, 6, 4, 4, 5, 1};
		result = k.findKthLargest(input, 6);
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		input = new int[] {3, 2, 6, 4, 4, 5, 1};
		result = k.findKthLargest(input, 7);
		Assert.assertThat(result, CoreMatchers.equalTo(1));
	}
}