import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SmallestNumberOfLargestCliqueTest {
	@Test
	public void test() {
		Assert.assertThat(SmallestNumberOfLargestClique.clique(15,144), CoreMatchers.equalTo(16));
	}
}