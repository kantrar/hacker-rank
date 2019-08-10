import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MCTFromLeafValuesTest {
	@Test
	public void test() {
		MCTFromLeafValues m = new MCTFromLeafValues();
		int res;
		res = m.mctFromLeafValues(new int[] {6, 2, 4});
		Assert.assertThat(res, CoreMatchers.equalTo(32));
	}
}