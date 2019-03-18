import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MinimumAverageWaitingTimeTest {
	@Test
	public void test() {
		Assert.assertThat(MinimumAverageWaitingTime.minimumAverage(new int[][] {{0, 3}, {3, 6}}), CoreMatchers.equalTo(4L));
		Assert.assertThat(MinimumAverageWaitingTime.minimumAverage(new int[][] {{0, 3}, {0, 6}}), CoreMatchers.equalTo(6L));
		Assert.assertThat(MinimumAverageWaitingTime.minimumAverage(new int[][] {{0, 3}, {1, 6}}), CoreMatchers.equalTo(5L));
		Assert.assertThat(MinimumAverageWaitingTime.minimumAverage(new int[][] {{0, 3}, {8, 6}}), CoreMatchers.equalTo(4L));
		Assert.assertThat(MinimumAverageWaitingTime.minimumAverage(new int[][] {{0, 3}, {8, 6}}), CoreMatchers.equalTo(4L));
		Assert.assertThat(MinimumAverageWaitingTime.minimumAverage(new int[][] {{0, 9}, {10, 4}}), CoreMatchers.equalTo(6L));
		Assert.assertThat(MinimumAverageWaitingTime.minimumAverage(new int[][] {{2, 9}}), CoreMatchers.equalTo(9L));
		Assert.assertThat(MinimumAverageWaitingTime.minimumAverage(new int[][] {{2, 9}, {1, 5}}), CoreMatchers.equalTo(9L));
		Assert.assertThat(MinimumAverageWaitingTime.minimumAverage(new int[][] {{0, 100}, {1, 1}, {2, 1}}),
				CoreMatchers.equalTo(100L));
		Assert.assertThat(MinimumAverageWaitingTime.minimumAverage(new int[][] {{0, 9}, {1, 3}, {2, 5}}),
				CoreMatchers.equalTo(11L));

		Assert.assertThat(MinimumAverageWaitingTime.minimumAverage(new int[][] {{4, 5}, {3, 9}, {21, 8}, {2, 3}}),
				CoreMatchers.equalTo(8L));

	}
}