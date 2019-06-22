import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class BulbSwitcherIITest {
	@Test
	public void test() {
		BulbSwitcherII b = new BulbSwitcherII();
		int result = b.flipLights(6, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(7));
	}
}