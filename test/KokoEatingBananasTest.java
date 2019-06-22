import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class KokoEatingBananasTest {
	@Test
	public void test() {
		KokoEatingBananas k = new KokoEatingBananas();
		int result;

		result = k.minEatingSpeed(new int[] {980628391, 681530205, 734313996, 168632541}, 819870953);
		Assert.assertThat(result, CoreMatchers.equalTo(4));

		result = k.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 5);
		Assert.assertThat(result, CoreMatchers.equalTo(30));

		result = k.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 6);
		Assert.assertThat(result, CoreMatchers.equalTo(23));

		result = k.minEatingSpeed(new int[] {3, 6, 7, 11}, 8);
		Assert.assertThat(result, CoreMatchers.equalTo(4));

	}
}