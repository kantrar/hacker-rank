import static org.junit.Assert.*;

import org.junit.Test;

public class FourSumsTest {
	@Test
	public void test() {
		FourSums f = new FourSums();
		f.fourSum(new int[] {-9, 4, 0, -3, 6, 3, -3, -9, -7, 1, 0, -7, -8, 7, 1}, -9);

		f.fourSum(new int[] {-5, -4, -2, -2, -2, -1, 0, 0, 1}, -9);
	}
}