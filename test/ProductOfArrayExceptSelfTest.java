import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ProductOfArrayExceptSelfTest {
	@Test
	public void test() {
		ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
		int[] result = p.productExceptSelf(new int[] {1, 2, 3, 4});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {24, 12, 8, 6}));
	}
}