import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class OrdinalNumberOfDateTest {
	OrdinalNumberOfDate o = new OrdinalNumberOfDate();
	int res;

	@Test
	public void test() {
		assertResult("2019-01-09", 9);
		assertResult("2019-02-10", 41);
		assertResult("2003-03-01", 60);
		assertResult("2004-03-01", 61);
		assertResult("2004-12-31", 366);
		assertResult("2003-12-31", 365);
		assertResult("2000-12-31", 366);
		assertResult("1900-12-31", 365);
	}

	private void assertResult(String date, int expected) {
		res = o.dayOfYear(date);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}