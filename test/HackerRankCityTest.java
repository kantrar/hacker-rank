import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class HackerRankCityTest {
	@Test
	public void testSimple1_1() {
		int result = HackerRankCity.hackerRankCity(new int[]{1});
		Assert.assertThat(result, CoreMatchers.equalTo(29));
	}

	@Test
	public void testSimple1_2() {
		int result = HackerRankCity.hackerRankCity(new int[]{2});
		Assert.assertThat(result, CoreMatchers.equalTo(58));
	}

	@Test
	public void testSimple1_3() {
		int result = HackerRankCity.hackerRankCity(new int[]{3});
		Assert.assertThat(result, CoreMatchers.equalTo(87));
	}

	@Test
	public void testSimple2_2_1() {
		int result = HackerRankCity.hackerRankCity(new int[]{2, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(2641));
	}
}