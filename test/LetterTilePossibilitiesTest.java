import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class LetterTilePossibilitiesTest {
	@Test
	public void test() {
		LetterTilePossibilities l = new LetterTilePossibilities();
		int result;
//		result = l.numTilePossibilities("AB");
//		Assert.assertThat(result, CoreMatchers.equalTo(4));

		result = l.numTilePossibilities("AAB");
		Assert.assertThat(result, CoreMatchers.equalTo(8));
	}
}