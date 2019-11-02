import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class DiceRollSimulationTest {
	@Test
	public void test() {
		DiceRollSimulation d = new DiceRollSimulation();
		int res = d.dieSimulator(2, new int[] {1, 1, 2, 2, 2, 3});
		Assert.assertThat(res, CoreMatchers.equalTo(34));
	}
}
