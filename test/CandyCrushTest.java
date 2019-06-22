import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyCrushTest {
	private CandyCrush c;
	private int[] result;

	@Before
	public void setUp() {
		c = new CandyCrush();
	}

	@Test
	public void test() {
		result = c.candyCrush(new int[] {1, 3, 3, 3, 2, 2, 2, 3, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 1}));
	}

	@Test
	public void test2() {
		result = c.candyCrush(new int[] {1, 3, 3, 3, 2, 2, 3, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 2, 2, 3, 1}));
	}

	@Test
	public void test3() {
		result = c.candyCrush(new int[] {1, 3, 3, 3, 2, 2, 3, 3, 3, 2, 2, 1, 4, 5});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 1, 4, 5}));
	}

	@Test
	public void test4() {
		result = c.candyCrush(new int[] {1, 3, 3, 3, 2, 2, 3, 3, 3, 2, 2, 1, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {}));
	}

	@Test
	public void test5() {
		result = c.candyCrush(new int[] {});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {}));
	}

	@Test
	public void test6() {
		result = c.candyCrush(new int[] {1, 1, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {}));
	}

	@Test
	public void test7() {
		result = c.candyCrush(new int[] {1, 1, 1, 1, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {}));
	}

	@Test
	public void test8() {
		result = c.candyCrush(new int[] {1, 1, 1, 1, 2, 1, 2, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {2, 1, 2, 2}));
	}

	@Test
	public void test9() {
		result = c.candyCrush(new int[] {1, 1, 2, 2, 2, 1, 1, 2, 2, 2, 1, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {}));
	}

	@Test
	public void test10() {
		result = c.candyCrush(new int[] {1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {}));
	}

	@Test
	public void test11() {
		result = c.candyCrush(new int[] {1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 2, 2});
		//		1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 2, 2
		//		0     2        5        8       11    13
		// 		2	  3        3 		3  		2 	   2
		//		1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15
		Assert.assertThat(result,
				CoreMatchers.anyOf(CoreMatchers.equalTo(new int[] {2, 2}), CoreMatchers.equalTo(new int[] {1, 1})));
	}

	@Test
	public void test12() {
		result = c.candyCrush(new int[] {2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 2, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {}));
	}

	@Test
	public void test13() {
		result = c.candyCrush(new int[] {2, 2, 1, 1, 2, 2, 2, 1, 1, 2, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {}));
	}

	@Test
	public void test14() {
		result = c.candyCrush(new int[] {1, 1, 2, 1, 1, 1, 2, 1, 1, 2, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(new int[] {1, 1, 2, 2, 1, 1, 2, 2}));
	}
}