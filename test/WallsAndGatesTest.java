import org.junit.Test;

public class WallsAndGatesTest {
	@Test
	public void test() {
		WallsAndGates w = new WallsAndGates();
		int[][] result = {
				{2147483647, -1, 0, 2147483647},
				{2147483647, 2147483647, 2147483647, -1},
				{2147483647, -1, 2147483647, -1},
				{0, -1, 2147483647, 2147483647}};
		w.wallsAndGates(result);

	}
}