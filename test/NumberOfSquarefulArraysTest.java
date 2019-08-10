import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NumberOfSquarefulArraysTest {
	@Test
	public void test() {
		NumberOfSquarefulArrays n = new NumberOfSquarefulArrays();
		int result;
		result = n.numSquarefulPerms(new int[] {1, 17, 8});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = n.numSquarefulPerms(new int[] {1, 1, 8, 1, 8});
		Assert.assertThat(result, CoreMatchers.equalTo(1));

		result = n.numSquarefulPerms(new int[] {2, 2, 2, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(1));
	}
}