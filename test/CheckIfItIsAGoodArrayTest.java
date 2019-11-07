import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CheckIfItIsAGoodArrayTest {
	@Test
	public void test() {
		CheckIfItIsAGoodArray c = new CheckIfItIsAGoodArray();
		boolean res;
//		res = c.isGoodArray(new int[] {100, 90, 70, 80, 40, 75, 135, 120, 150, 150, 1000});
//		Assert.assertThat(res, CoreMatchers.equalTo(false));

//		res = c.isGoodArray(new int[] {30, 6, 18, 24, 30, 27, 27, 18, 6, 9, 6, 15, 9, 12, 15, 18, 24, 15, 24, 27, 8});
//		Assert.assertThat(res, CoreMatchers.equalTo(true));

		res = c.isGoodArray(new int[] {60,12,54,36,36,48,6,18,12,30,60,100,30,70,70,50,100,100,80,100});
		Assert.assertThat(res, CoreMatchers.equalTo(false));
	}
}
