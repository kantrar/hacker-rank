import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PrimMSTTest {
	@Test
	public void testSimple() {
		Assert.assertThat(PrimMST.prims(5, new int[][] {{1, 2, 3}, {1, 3, 4}, {4, 2, 6}, {5, 2, 2}, {2, 3, 5}, {3, 5, 7}}, 1),
				CoreMatchers.equalTo(15));
	}
}