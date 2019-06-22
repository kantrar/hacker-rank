import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class DFSConnectedCellInAGrid2Test {
	@Test
	public void test() {
		int result = DFSConnectedCellInAGrid2
				.maxRegion(new int[][] {{1, 0, 1, 1, 0}, {1, 1, 0, 0, 1}, {0, 1, 1, 1, 0}, {0, 0, 0, 0, 1}, {1, 1, 1, 0, 0}});
		Assert.assertThat(result, CoreMatchers.equalTo(10));
	}
}