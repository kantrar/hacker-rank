import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ShortestPathToGetAllKeysTest {
	@Test
	public void test() {
		ShortestPathToGetAllKeys s = new ShortestPathToGetAllKeys();
		int res;
		res = s.shortestPathAllKeys(new String[] {"@.a.#", "###.#", "b.A.B"});
		Assert.assertThat(res, CoreMatchers.equalTo(8));

		res = s.shortestPathAllKeys(new String[] {"@.aA#"});
		Assert.assertThat(res, CoreMatchers.equalTo(2));

		res = s.shortestPathAllKeys(new String[] {"@Aa.#"});
		Assert.assertThat(res, CoreMatchers.equalTo(-1));
	}
}
