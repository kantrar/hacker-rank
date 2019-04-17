import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class JourneyToTheMoon2Test {
	@Test
	public void test() {
		long result = JourneyToTheMoon2.journeyToMoon(4, new int[][] {{0, 2}});
		Assert.assertThat(result, CoreMatchers.equalTo(5L));
//		long result = JourneyToTheMoon.journeyToMoon(100000, new int[][] {{1, 2}, {3, 4}});
//		Assert.assertThat(result, CoreMatchers.equalTo(0L));
	}
}