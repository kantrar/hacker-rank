import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class OutOfBoundaryPathsTest {
	@Test
	public void test() {
		OutOfBoundaryPaths o = new OutOfBoundaryPaths();
		int result;
		result = o.findPaths(1, 3, 3, 0, 1);
		Assert.assertThat(result, CoreMatchers.equalTo(12));

		result = o.findPaths(1, 2, 50, 0, 0);
		Assert.assertThat(result, CoreMatchers.equalTo(150));

		result = o.findPaths(8, 50, 23, 5, 26);
		Assert.assertThat(result, CoreMatchers.equalTo(914783380));
	}
}