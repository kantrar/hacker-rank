import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class FindPeakElementTest {
	@Test
	public void test() {
		FindPeakElement f = new FindPeakElement();
		int result;

		result = f.findPeakElement(new int[] {2, 1, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(2));

		result = f.findPeakElement(new int[] {1});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = f.findPeakElement(new int[] {2, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(0));

		result = f.findPeakElement(new int[] {1, 2, 3, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(2));
	}
}