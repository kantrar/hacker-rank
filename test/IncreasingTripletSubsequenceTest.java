import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class IncreasingTripletSubsequenceTest {
	@Test
	public void test() {
		IncreasingTripletSubsequence i = new IncreasingTripletSubsequence();
		boolean res;

		res = i.increasingTriplet(new int[] {1});
		Assert.assertThat(res, CoreMatchers.equalTo(false));

		res = i.increasingTriplet(new int[] {1, 2, 3});
		Assert.assertThat(res, CoreMatchers.equalTo(true));

		res = i.increasingTriplet(new int[] {2, 1, 3});
		Assert.assertThat(res, CoreMatchers.equalTo(false));

		res = i.increasingTriplet(new int[] {1, 3, 2, 5});
		Assert.assertThat(res, CoreMatchers.equalTo(true));

		res = i.increasingTriplet(new int[] {2, 4, 1, 5});
		Assert.assertThat(res, CoreMatchers.equalTo(true));

		res = i.increasingTriplet(new int[] {2, 8, 1, 3, 1, 2, 6});
		Assert.assertThat(res, CoreMatchers.equalTo(true));

		res = i.increasingTriplet(new int[] {2, 8, 1, 3, 1, 2, 9});
		Assert.assertThat(res, CoreMatchers.equalTo(true));

		res = i.increasingTriplet(new int[] {2, 8, 1, 3, 1, 5, 4});
		Assert.assertThat(res, CoreMatchers.equalTo(true));

		res = i.increasingTriplet(new int[] {2, 8, 1, 3, 1, 6});
		Assert.assertThat(res, CoreMatchers.equalTo(true));

		res = i.increasingTriplet(new int[] {1, 2, 3, 4, 5});
		Assert.assertThat(res, CoreMatchers.equalTo(true));

		res = i.increasingTriplet(new int[] {5, 4, 3, 2, 1});
		Assert.assertThat(res, CoreMatchers.equalTo(false));
	}
}