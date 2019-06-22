import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class FirstMissingPositiveTest {
	@Test
	public void test() {
		FirstMissingPositive f = new FirstMissingPositive();
		int result;
		result = f.firstMissingPositive(new int[] {1, 2, 0});
		Assert.assertThat(result, CoreMatchers.equalTo(3));

		result = f.firstMissingPositive(new int[] {1, 2, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(4));

		result = f.firstMissingPositive(new int[] {3, 4, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = f.firstMissingPositive(new int[] {1, 4, 3, 4, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = f.firstMissingPositive(new int[] {1, -1, 3, -1, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = f.firstMissingPositive(new int[] {0, -1, 3, -1, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = f.firstMissingPositive(new int[] {7, 6, 9, 10});
		Assert.assertThat(result, CoreMatchers.equalTo(1));
	}
}