import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class DistinctSubsequencesIITest {
	@Test
	public void test() {
		DistinctSubsequencesII d = new DistinctSubsequencesII();
		int res = d.distinctSubseqII("aaa");
		Assert.assertThat(res, CoreMatchers.equalTo(3));
	}
}
