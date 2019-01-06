import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class GoodLandElectricityTest {

	@Test
	public void testDistance1() {
		assertGame(1, new int[] {1, 1, 1}, 3);
	}

	@Test
	public void testNotFound0() {
		assertGame(1, new int[] {0, 0, 0}, -1);
		assertGame(2, new int[] {0, 0, 0}, -1);
		assertGame(1, new int[] {0, 1}, -1);



	}

	@Test
	public void testNotFound() {
		assertGame(1, new int[] {1, 0, 1}, -1);
		assertGame(3, new int[] {0, 1, 1, 1, 0, 0, 0}, -1);
		assertGame(2, new int[] {0, 1, 0, 1, 0, 0}, -1);
		assertGame(5, new int[] {0, 1, 0, 0, 0, 0, 0}, -1);
		assertGame(5, new int[] {1, 1, 0, 0, 0, 0, 0}, -1);
	}

	@Test
	public void testSimple() {

		assertGame(2, new int[] {0, 1, 1, 1, 1, 0}, 2);
		assertGame(3, new int[] {0, 1, 0, 1, 0, 0}, 2);
		assertGame(2, new int[] {0, 1, 0, 0, 1, 1, 1, 0}, 3);
		assertGame(2, new int[] {0, 1, 0, 1, 1, 1, 1, 1}, 3);
		assertGame(5, new int[] {0, 1, 0}, 1);
		assertGame(5, new int[] {0, 0, 0, 0, 1}, 1);
		assertGame(5, new int[] {0, 0, 0, 1}, 1);
		assertGame(5, new int[] {0, 1, 0, 0, 0, 0}, 1);
		assertGame(5, new int[] {1, 1, 0, 0, 0, 0}, 1);
		assertGame(2, new int[] {0, 1, 0, 0, 0, 1, 1, 1, 0}, -1);
		assertGame(2, new int[] {0, 1, 0, 1, 0, 1, 0, 1, 0}, 4);
		assertGame(2, new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1}, 3);
		assertGame(2, new int[] {1, 1, 1, 1, 1, 1, 1, 1}, 3);
		assertGame(2, new int[] {1, 1, 1, 1, 1, 1, 1}, 3);
		assertGame(2, new int[] {1, 1, 0, 0, 1, 1, 1}, 3);

	}

	@Test
	public void testAdvanced() {
		assertGame(2, new int[] {1, 1, 0, 0, 1, 1, 0, 0, 1}, 4);
		assertGame(4, new int[] {0, 0, 0, 1, 1, 0, 0, 0}, 2);
	}

	private void assertGame(int distance, int[] inputs, int expected) {
		Assert.assertThat(GoodLandElectricity.pylons(distance, inputs), CoreMatchers.equalTo(expected));
	}
}