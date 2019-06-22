import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class OccurencesAfterBigramTest {
	@Test
	public void test() {
		OccurencesAfterBigram o = new OccurencesAfterBigram();
		String[] result;

		result = o.findOcurrences("alice is a good girl she is a good student", "a", "good");
		Assert.assertThat(result, CoreMatchers.equalTo(new String[] {"girl", "student"}));

		result = o.findOcurrences("we will we will rock you", "we", "will");
		Assert.assertThat(result, CoreMatchers.equalTo(new String[] {"we", "rock"}));

		result = o.findOcurrences("we will we will", "we", "will");
		Assert.assertThat(result, CoreMatchers.equalTo(new String[] {"we"}));

		result = o.findOcurrences("we will we will rock you we", "we", "will");
		Assert.assertThat(result, CoreMatchers.equalTo(new String[] {"we", "rock"}));
	}
}