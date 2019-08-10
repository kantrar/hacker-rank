import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class DistributeCandiesToPeopleTest {
	@Test
	public void test() {
		DistributeCandiesToPeople d = new DistributeCandiesToPeople();
		int[] candies;

		candies = d.distributeCandies(80, 5);
		Assert.assertThat(candies, CoreMatchers.equalTo(new int[] {18, 21, 13, 13, 15}));

		candies = d.distributeCandies(59, 4);
		Assert.assertThat(candies, CoreMatchers.equalTo(new int[] {15, 18, 14, 12}));

		candies = d.distributeCandies(7, 4);
		Assert.assertThat(candies, CoreMatchers.equalTo(new int[] {1, 2, 3, 1}));

		candies = d.distributeCandies(10, 4);
		Assert.assertThat(candies, CoreMatchers.equalTo(new int[] {1, 2, 3, 4}));

		candies = d.distributeCandies(26, 4);
		Assert.assertThat(candies, CoreMatchers.equalTo(new int[] {6, 8, 8, 4}));

		candies = d.distributeCandies(36, 4);
		Assert.assertThat(candies, CoreMatchers.equalTo(new int[] {6, 8, 10, 12}));

		candies = d.distributeCandies(10, 3);
		Assert.assertThat(candies, CoreMatchers.equalTo(new int[] {5, 2, 3}));

		candies = d.distributeCandies(0, 4);
		Assert.assertThat(candies, CoreMatchers.equalTo(new int[] {0, 0, 0, 0}));

		candies = d.distributeCandies(1, 4);
		Assert.assertThat(candies, CoreMatchers.equalTo(new int[] {1, 0, 0, 0}));

		candies = d.distributeCandies(2, 4);
		Assert.assertThat(candies, CoreMatchers.equalTo(new int[] {1, 1, 0, 0}));

		candies = d.distributeCandies(3, 4);
		Assert.assertThat(candies, CoreMatchers.equalTo(new int[] {1, 2, 0, 0}));

		candies = d.distributeCandies(4, 0);
		Assert.assertThat(candies, CoreMatchers.equalTo(new int[] {}));

	}
}