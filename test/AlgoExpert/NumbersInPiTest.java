package AlgoExpert;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NumbersInPiTest {
	@Test
	public void test() {
		int res;
//		res = NumbersInPi.numbersInPi("123456789", new String[] {"123456", "7", "8", "9", "1234", "5678"});
//		Assert.assertThat(res, CoreMatchers.equalTo(2));
//
//		res = NumbersInPi.numbersInPi("", new String[] {"123456", "7", "8", "9", "1234", "5678"});
//		Assert.assertThat(res, CoreMatchers.equalTo(0));
//
//		res = NumbersInPi.numbersInPi("123456", new String[] {"123456", "7", "8", "9", "1234", "5678"});
//		Assert.assertThat(res, CoreMatchers.equalTo(0));

		res = NumbersInPi.numbersInPi("1234567", new String[] {"123456", "7", "8", "9", "1234", "5678"});
		Assert.assertThat(res, CoreMatchers.equalTo(1));
	}
}
