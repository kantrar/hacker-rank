import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PalindromePartitioningIITest {
	PalindromePartitioningII p = new PalindromePartitioningII();
	int res;

	@Test
	public void test() {
		res = p.minCut("");
		Assert.assertThat(res, CoreMatchers.equalTo(0));
		res = p.minCut("a");
		Assert.assertThat(res, CoreMatchers.equalTo(0));
		res = p.minCut("aa");
		Assert.assertThat(res, CoreMatchers.equalTo(0));
		res = p.minCut("ab");
		Assert.assertThat(res, CoreMatchers.equalTo(1));
		res = p.minCut("aab");
		Assert.assertThat(res, CoreMatchers.equalTo(1));
		res = p.minCut("aaba");
		Assert.assertThat(res, CoreMatchers.equalTo(1));
		res = p.minCut("acaba");
		Assert.assertThat(res, CoreMatchers.equalTo(2));
		res = p.minCut("acababa");
		Assert.assertThat(res, CoreMatchers.equalTo(2));
		res = p.minCut("aaaaacababa");
		Assert.assertThat(res, CoreMatchers.equalTo(2));
	}
}