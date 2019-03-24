import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class JourneyToTheMoonTest {
	@Test
	public void test() {
		long result = JourneyToTheMoon.journeyToMoon(100000, new int[][] {{1, 2}, {3, 4}});
		Assert.assertThat(result, CoreMatchers.equalTo(0L));
	}
}