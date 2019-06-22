import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class OddEvenJumpsTest {
	@Test
	public void test() {
		OddEvenJumps o = new OddEvenJumps();
		int result;
		result = o.oddEvenJumps(new int[] {5, 1, 3, 4, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(3));
	}
}