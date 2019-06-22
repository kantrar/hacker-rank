import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class KnightDialerTest {
	@Test
	public void test() {
		KnightDialer k = new KnightDialer();
		int result = k.knightDialer(2);
		Assert.assertThat(result, CoreMatchers.equalTo(20));
	}
}