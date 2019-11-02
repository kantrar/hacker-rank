import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SuperEggDropTest {
	SuperEggDrop s = new SuperEggDrop();
	int res;

	@Test
	public void test() {
		assertMethod(1, 3, 3);
		assertMethod(2, 1, 1);
		assertMethod(2, 2, 2);
		assertMethod(2, 3, 2);
		assertMethod(2, 4, 3);
		assertMethod(2, 5, 3);
		assertMethod(2, 6, 3);
		assertMethod(2, 7, 4);
		assertMethod(3, 14, 4);
		assertMethod(8, 8, 4);
		assertMethod(15, 15, 4);
		assertMethod(16, 16, 5);
		assertMethod(4, 1000, 13);
	}

	private void assertMethod(int k, int n, int expected) {
		res = s.superEggDrop(k, n);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}
