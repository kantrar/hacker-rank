import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class RaceCarTest {
	RaceCar r = new RaceCar();
	int res;

	@Test
	public void test() {
//		assertResult(14, 6);
//		assertResult(17, 9);
		assertResult(2, 4);
//		assertResult(18, 8);
	}

	private void assertResult(int input, int expected) {
		res = r.racecar(input);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}
