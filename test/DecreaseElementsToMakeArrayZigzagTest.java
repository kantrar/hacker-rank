import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class DecreaseElementsToMakeArrayZigzagTest {
	@Test
	public void test() {
		DecreaseElementsToMakeArrayZigzag d = new DecreaseElementsToMakeArrayZigzag();
		int res;
		res = d.movesToMakeZigzag(new int[] {2, 7, 10, 9, 8, 9});
		Assert.assertThat(res, CoreMatchers.equalTo(4));

		res = d.movesToMakeZigzag(new int[] {1});
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = d.movesToMakeZigzag(new int[] {1, 2});
		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = d.movesToMakeZigzag(new int[] {1, 2, 3});
		Assert.assertThat(res, CoreMatchers.equalTo(2));

		res = d.movesToMakeZigzag(new int[] {9, 6, 1, 6, 2});
		Assert.assertThat(res, CoreMatchers.equalTo(4));

		res = d.movesToMakeZigzag(new int[] {10, 4, 4, 10, 10, 6, 2, 3});
		Assert.assertThat(res, CoreMatchers.equalTo(13));
	}
}