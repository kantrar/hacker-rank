import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SuperUglyNumberTest {
	@Test
	public void test() {
		SuperUglyNumber s = new SuperUglyNumber();
		int result;
		result = s.nthSuperUglyNumber(12, new int[] {2, 7, 13, 19});
		Assert.assertThat(result, CoreMatchers.equalTo(32));

		result = s.nthSuperUglyNumber(18000,
				new int[] {7, 19, 29, 37, 41, 47, 53, 59, 61, 79, 83, 89, 101, 103, 109, 127, 131, 137, 139, 157, 167, 179, 181,
						199, 211, 229, 233, 239, 241, 251});
		Assert.assertThat(result, CoreMatchers.equalTo(27503131));
	}
}