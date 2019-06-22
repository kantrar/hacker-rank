import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ValidBoomerangTest {
	@Test
	public void test() {
		ValidBoomerang v = new ValidBoomerang();
		boolean result = v.isBoomerang(new int[][] {{1, 0}, {0, 0}, {2, 0}});
		Assert.assertThat(result, CoreMatchers.equalTo(false));

	}
}