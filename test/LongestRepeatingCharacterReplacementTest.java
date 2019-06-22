import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class LongestRepeatingCharacterReplacementTest {
	@Test
	public void test() {
		LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
		int result = l.characterReplacement("AABABBA", 1);
		Assert.assertThat(result, CoreMatchers.equalTo(4));
	}
}