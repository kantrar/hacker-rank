import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NQueensIITest {
	@Test
	public void test() {
		NQueensII n = new NQueensII();
		int res = n.totalNQueens(4);
		Assert.assertThat(res, CoreMatchers.equalTo(2));
	}
}
