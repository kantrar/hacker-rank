import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class RegionsCutBySlashesTest {
	RegionsCutBySlashes r = new RegionsCutBySlashes();
	int result;

	@Test
	public void test() {
		assertResult(new String[] {" /", "/ "}, 2);
		assertResult(new String[] {" /", "  "}, 1);
		assertResult(new String[] {"//", "/ "}, 3);
//		assertResult(new String[] {"\\/", "/\\"}, 4);

	}

	private void assertResult(String[] grid, int expected) {
		result = r.regionsBySlashes(grid);
		Assert.assertThat(result, CoreMatchers.equalTo(expected));
	}
}
