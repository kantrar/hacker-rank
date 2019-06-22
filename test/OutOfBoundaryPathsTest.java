import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class OutOfBoundaryPathsTest {
	@Test
	public void test() {
		OutOfBoundaryPaths o = new OutOfBoundaryPaths();
		int result;
		result = o.findPaths(1, 2, 50, 0, 0);
		Assert.assertThat(result, CoreMatchers.equalTo(150));
	}
}