import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class FindTheDifferenceTest {
	@Test
	public void test() {
		FindTheDifference f = new FindTheDifference();
		char result = f.findTheDifference("abcd", "abcde");
		Assert.assertThat(result, CoreMatchers.equalTo('e'));
	}
}