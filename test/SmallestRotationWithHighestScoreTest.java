import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SmallestRotationWithHighestScoreTest {
	@Test
	public void test() {
		SmallestRotationWithHighestScore s = new SmallestRotationWithHighestScore();
		int result;
		result = s.bestRotation(new int[] {2, 3, 1, 4, 0});
		Assert.assertThat(result, CoreMatchers.equalTo(3));

		result = s.bestRotation(new int[] {1, 3, 0, 2, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = s.bestRotation(new int[] {5, 2, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(3));

		result = s.bestRotation(new int[] {0, 1, 2, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = s.bestRotation(new int[] {1, 2, 3, 0});
		Assert.assertThat(result, CoreMatchers.equalTo(3));

		result = s.bestRotation(new int[] {3, 6, 5, 3, 0, 12, 6});
		Assert.assertThat(result, CoreMatchers.equalTo(4));
	}
}