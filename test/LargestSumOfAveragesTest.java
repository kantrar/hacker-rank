import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class LargestSumOfAveragesTest {
	@Test
	public void test() {
		LargestSumOfAverages l = new LargestSumOfAverages();
		double res;
		res = l.largestSumOfAverages(new int[] {4, 1, 7, 5, 6, 2, 3}, 4);
		Assert.assertThat(res, Matchers.closeTo(18.17, 0.05));

		res = l.largestSumOfAverages(new int[] {9, 1, 2, 3, 9}, 2);
		Assert.assertThat(res, Matchers.closeTo(12.75, 0.05));
	}
}