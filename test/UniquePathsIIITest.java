import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class UniquePathsIIITest {
	@Test
	public void test() {
		UniquePathsIII u = new UniquePathsIII();
		int result = u.uniquePathsIII(new int[][] {{1, 0, 0}, {0, 0, 0}, {0, 0, 2}});
		Assert.assertThat(result, CoreMatchers.equalTo(2));
	}
}