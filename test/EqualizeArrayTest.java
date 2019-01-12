import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class EqualizeArrayTest {
	@Test
	public void testSimple() {
		Assert.assertThat(EqualizeArray.equalizeArray(new int[] {1, 2, 2, 3}), CoreMatchers.equalTo(2));
		Assert.assertThat(EqualizeArray.equalizeArray(new int[] {3, 3, 2, 1, 3}), CoreMatchers.equalTo(2));
		Assert.assertThat(EqualizeArray.equalizeArray(new int[] {1, 2, 3, 5, 10}), CoreMatchers.equalTo(4));
		Assert.assertThat(EqualizeArray.equalizeArray(new int[] {3, 3, 3, 2, 2}), CoreMatchers.equalTo(2));
		Assert.assertThat(EqualizeArray.equalizeArray(new int[] {3, 3, 2, 3, 2, 2}), CoreMatchers.equalTo(3));
		Assert.assertThat(EqualizeArray.equalizeArray(new int[] {3, 3, 3, 3, 3, 3}), CoreMatchers.equalTo(0));
	}
}