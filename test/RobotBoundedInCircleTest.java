import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class RobotBoundedInCircleTest {
	RobotBoundedInCircle r;
	boolean result;

	@Test
	public void test() {
		r = new RobotBoundedInCircle();
		assertResult("GGLLGG", true);
		assertResult("GL", true);
		assertResult("GLGL", true);
		assertResult("GLGLGL", true);
		assertResult("GG", false);
	}

	private void assertResult(String input, boolean expected) {
		result = r.isRobotBounded(input);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}