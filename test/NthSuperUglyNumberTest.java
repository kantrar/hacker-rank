import static org.junit.Assert.*;

import org.junit.Test;

public class NthSuperUglyNumberTest {
	@Test
	public void test() {
		NthSuperUglyNumber n = new NthSuperUglyNumber();
		int result = n.nthSuperUglyNumber(12, new int[] {2, 7, 13});
	}
}