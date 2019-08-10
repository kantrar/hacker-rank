import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class EliminationGameTest {
	@Test
	public void test() {
		EliminationGame e = new EliminationGame();
		int res = e.lastRemaining(9);
		Assert.assertThat(res, CoreMatchers.equalTo(6));
	}
}