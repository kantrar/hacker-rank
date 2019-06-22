import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PushDominoesTest {
	PushDominoes p = new PushDominoes();
	String result;

	@Test
	public void test() {
		assertResult(".L.R...LR..L..", "LL.RR.LLRRLL..");
		assertResult("R.L", "R.L");
		assertResult("RR.L", "RR.L");
		assertResult("LL..RR", "LL..RR");
		assertResult("LL.RRR", "LL.RRR");
		assertResult("R....L", "RRRLLL");
		assertResult("R...L", "RR.LL");
		assertResult("L.L.L", "LLLLL");
		assertResult("R.R.R", "RRRRR");
		assertResult("...R.R.R...", "...RRRRRRRR");
		assertResult("...L.L.L...", "LLLLLLLL...");
	}

	private void assertResult(String input, String expected) {
		result = p.pushDominoes(input);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}