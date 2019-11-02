import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MinDeletionSizeTest {

	@Test
	public void test() {
		MinDeletionSize m = new MinDeletionSize();
		int res = m.minDeletionSize(new String[] {"babca", "bbazb"});
		Assert.assertThat(res, CoreMatchers.equalTo(3));
	}
}
