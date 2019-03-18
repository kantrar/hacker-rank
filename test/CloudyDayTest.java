import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CloudyDayTest {
	@Test
	public void test() {
		long result;
		result = CloudyDay.maximumPeople(new long[] {10, 100}, new int[] {5, 100}, new long[] {4}, new long[] {1});
		Assert.assertThat(result, CoreMatchers.equalTo(110L));

		result = CloudyDay.maximumPeople(new long[] {10, 100}, new int[] {5, 100}, new long[] {}, new long[] {});
		Assert.assertThat(result, CoreMatchers.equalTo(110L));

		result = CloudyDay.maximumPeople(new long[] {10, 100}, new int[] {5, 100}, new long[] {4, 4}, new long[] {1, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(100L));

		result = CloudyDay.maximumPeople(new long[] {10, 100}, new int[] {5, 100}, new long[] {4, 4}, new long[] {1, 100});
		Assert.assertThat(result, CoreMatchers.equalTo(100L));

		result = CloudyDay.maximumPeople(new long[] {10, 100}, new int[] {5, 100}, new long[] {4, 4}, new long[] {1, 100});
		Assert.assertThat(result, CoreMatchers.equalTo(100L));

		result = CloudyDay.maximumPeople(new long[] {10, 100, 200}, new int[] {5, 100, 101}, new long[] {100}, new long[] {2});
		Assert.assertThat(result, CoreMatchers.equalTo(310L));

		result = CloudyDay
				.maximumPeople(new long[] {10, 100, 200}, new int[] {5, 100, 101}, new long[] {100, 4}, new long[] {2, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(300L));

		result = CloudyDay.maximumPeople(new long[] {10, 100, 200}, new int[] {5, 100, 101}, new long[] {5}, new long[] {5});
		Assert.assertThat(result, CoreMatchers.equalTo(310L));

		result = CloudyDay.maximumPeople(new long[] {10, 100, 200}, new int[] {5, 100, 101}, new long[] {5}, new long[] {10});
		Assert.assertThat(result, CoreMatchers.equalTo(310L));

		result = CloudyDay.maximumPeople(new long[] {10, 100, 200, 100}, new int[] {5, 100, 101, 105}, new long[] {5, 101},
				new long[] {10, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(400L));

		result = CloudyDay.maximumPeople(new long[] {10, 100, 200, 100}, new int[] {5, 100, 101, 105}, new long[] {5, 101, 106},
				new long[] {10, 2, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(300L));

		result = CloudyDay.maximumPeople(new long[] {10, 100, 200, 100}, new int[] {5, 100, 101, 105}, new long[] {5, 5, 5},
				new long[] {100, 20, 10});
		Assert.assertThat(result, CoreMatchers.equalTo(400L));

		result = CloudyDay.maximumPeople(new long[] {10, 100, 200, 100}, new int[] {5, 100, 101, 105}, new long[] {5, 5, 5},
				new long[] {100, 150, 120});
		Assert.assertThat(result, CoreMatchers.equalTo(0L));

		result = CloudyDay.maximumPeople(new long[] {10, 100, 200, 100}, new int[] {5, 100, 101, 100}, new long[] {5, 5, 5},
				new long[] {5, 10, 15});
		Assert.assertThat(result, CoreMatchers.equalTo(400L));

		result = CloudyDay.maximumPeople(new long[] {10, 100, 200, 100}, new int[] {5, 100, 101, 105}, new long[] {5, 102},
				new long[] {5, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(400L));

		result = CloudyDay.maximumPeople(new long[] {10, 100, 200, 100}, new int[] {5, 100, 104, 120}, new long[] {5, 104, 110},
				new long[] {5, 5, 10});
		Assert.assertThat(result, CoreMatchers.equalTo(100L));

		result = CloudyDay.maximumPeople(new long[] {10, 100, 200, 150}, new int[] {5, 100, 104, 108}, new long[] {5, 99, 110},
				new long[] {5, 5, 6});
		Assert.assertThat(result, CoreMatchers.equalTo(150L));

		result = CloudyDay
				.maximumPeople(new long[] {10, 100, 200, 150}, new int[] {5, 100, 104, 108}, new long[] {50}, new long[] {5});
		Assert.assertThat(result, CoreMatchers.equalTo(460L));

		result = CloudyDay.maximumPeople(new long[] {10, 100, 200, 150}, new int[] {5, 100, 104, 108}, new long[] {5, 1},
				new long[] {2, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(460L));

		result = CloudyDay.maximumPeople(new long[] {10, 100, 200, 150}, new int[] {5, 100, 104, 108}, new long[] {110, 200},
				new long[] {1, 10});
		Assert.assertThat(result, CoreMatchers.equalTo(460L));
	}

	@Test
	public void test2() {
		long result;
		result = CloudyDay.maximumPeople2(new long[] {10, 100}, new long[] {5, 100}, new long[] {4}, new long[] {1});
		Assert.assertThat(result, CoreMatchers.equalTo(110L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100}, new long[] {5, 100}, new long[] {}, new long[] {});
		Assert.assertThat(result, CoreMatchers.equalTo(110L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100}, new long[] {5, 100}, new long[] {4, 4}, new long[] {1, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(100L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100}, new long[] {5, 100}, new long[] {4, 4}, new long[] {1, 100});
		Assert.assertThat(result, CoreMatchers.equalTo(100L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100}, new long[] {5, 100}, new long[] {4, 4}, new long[] {1, 100});
		Assert.assertThat(result, CoreMatchers.equalTo(100L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100, 200}, new long[] {5, 100, 101}, new long[] {100}, new long[] {2});
		Assert.assertThat(result, CoreMatchers.equalTo(310L));

		result = CloudyDay
				.maximumPeople2(new long[] {10, 100, 200}, new long[] {5, 100, 101}, new long[] {100, 4}, new long[] {2, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(300L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100, 200}, new long[] {5, 100, 101}, new long[] {5}, new long[] {5});
		Assert.assertThat(result, CoreMatchers.equalTo(310L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100, 200}, new long[] {5, 100, 101}, new long[] {5}, new long[] {10});
		Assert.assertThat(result, CoreMatchers.equalTo(310L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100, 200, 100}, new long[] {5, 100, 101, 105}, new long[] {5, 101},
				new long[] {10, 2});
		Assert.assertThat(result, CoreMatchers.equalTo(400L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100, 200, 100}, new long[] {5, 100, 101, 105}, new long[] {5, 101,
						106},
				new long[] {10, 2, 1});
		Assert.assertThat(result, CoreMatchers.equalTo(300L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100, 200, 100}, new long[] {5, 100, 101, 105}, new long[] {5, 5, 5},
				new long[] {100, 20, 10});
		Assert.assertThat(result, CoreMatchers.equalTo(400L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100, 200, 100}, new long[] {5, 100, 101, 105}, new long[] {5, 5, 5},
				new long[] {100, 150, 120});
		Assert.assertThat(result, CoreMatchers.equalTo(0L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100, 200, 100}, new long[] {5, 100, 101, 100}, new long[] {5, 5, 5},
				new long[] {5, 10, 15});
		Assert.assertThat(result, CoreMatchers.equalTo(400L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100, 200, 100}, new long[] {5, 100, 101, 105}, new long[] {5, 102},
				new long[] {5, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(400L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100, 200, 100}, new long[] {5, 100, 104, 120}, new long[] {5, 104,
						110},
				new long[] {5, 5, 10});
		Assert.assertThat(result, CoreMatchers.equalTo(100L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100, 200, 150}, new long[] {5, 100, 104, 108}, new long[] {5, 99, 110},
				new long[] {5, 5, 6});
		Assert.assertThat(result, CoreMatchers.equalTo(150L));

		result = CloudyDay
				.maximumPeople2(new long[] {10, 100, 200, 150}, new long[] {5, 100, 104, 108}, new long[] {50}, new long[] {5});
		Assert.assertThat(result, CoreMatchers.equalTo(460L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100, 200, 150}, new long[] {5, 100, 104, 108}, new long[] {5, 1},
				new long[] {2, 3});
		Assert.assertThat(result, CoreMatchers.equalTo(460L));

		result = CloudyDay.maximumPeople2(new long[] {10, 100, 200, 150}, new long[] {5, 100, 104, 108}, new long[] {110, 200},
				new long[] {1, 10});
		Assert.assertThat(result, CoreMatchers.equalTo(460L));
	}
}