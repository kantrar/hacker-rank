import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ValidPermutationsForDISequenceTest {
	@Test
	public void test() {
		ValidPermutationsForDISequence v = new ValidPermutationsForDISequence();
		int answer = v.numPermsDISequence("DID");
		Assert.assertThat(answer, CoreMatchers.equalTo(5));
	}
}