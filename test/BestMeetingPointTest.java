import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class BestMeetingPointTest {
	@Test
	public void test() {
		BestMeetingPoint bestMeetingPoint = new BestMeetingPoint();
		int[][] input;
		int distance;

		input = new int[][] {{1,0,1}, {0,0,0}, {0,1,0}};
		distance = bestMeetingPoint.minTotalDistance(input);
		Assert.assertThat(distance, CoreMatchers.equalTo(4));

		input = new int[][] {{1,0,0,0,1}, {0,0,0,0,0}, {0,0,1,0,0}};
		distance = bestMeetingPoint.minTotalDistance(input);
		Assert.assertThat(distance, CoreMatchers.equalTo(6));

		input = new int[][] {{1,0,0,1,0}};
		distance = bestMeetingPoint.minTotalDistance(input);
		Assert.assertThat(distance, CoreMatchers.equalTo(3));
	}
}
