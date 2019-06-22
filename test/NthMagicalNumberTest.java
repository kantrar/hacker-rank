import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class NthMagicalNumberTest {
	@Test
	public void test() {
		NthMagicalNumber n = new NthMagicalNumber();
		int result = n.nthMagicalNumber(1000000000, 39999, 40000);
		Assert.assertThat(result, CoreMatchers.equalTo(999860007));
	}
}