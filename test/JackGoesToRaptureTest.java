import java.util.Arrays;
import java.util.Collections;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class JackGoesToRaptureTest {

	@Test
	public void test() {
		Assert.assertThat(JackGoesToRapture.getCost(1, Collections.emptyList(), Collections.emptyList(),
				Collections.emptyList()),
				CoreMatchers.equalTo(-1L));

		Assert.assertThat(JackGoesToRapture.getCost(2, Arrays.asList(1), Arrays.asList(2), Arrays.asList(50)),
				CoreMatchers.equalTo(50L));

		Assert.assertThat(JackGoesToRapture.getCost(3, Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(20, 25)),
				CoreMatchers.equalTo(25L));

		Assert.assertThat(JackGoesToRapture.getCost(4, Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4), Arrays.asList(20, 25,
				15)),
				CoreMatchers.equalTo(25L));

		Assert.assertThat(
				JackGoesToRapture.getCost(4, Arrays.asList(1, 1, 2, 3), Arrays.asList(2, 3, 4, 4), Arrays.asList(20, 25, 15,
						35)),
				CoreMatchers.equalTo(20L));

		Assert.assertThat(
				JackGoesToRapture.getCost(4, Arrays.asList(1, 1, 2, 3), Arrays.asList(2, 3, 4, 4), Arrays.asList(20, 25, 15,
						30)),
				CoreMatchers.equalTo(20L));

		Assert.assertThat(
				JackGoesToRapture.getCost(4, Arrays.asList(1, 1, 2, 3), Arrays.asList(2, 3, 4, 4), Arrays.asList(30, 25, 15,
						35)),
				CoreMatchers.equalTo(30L));

		Assert.assertThat(JackGoesToRapture
						.getCost(5, Arrays.asList(1, 1, 2, 3, 4), Arrays.asList(2, 3, 4, 4, 5), Arrays.asList(1, 1, 1, 1, 1)),
				CoreMatchers.equalTo(1L));

		Assert.assertThat(JackGoesToRapture
						.getCost(5, Arrays.asList(1, 1, 2, 3, 1), Arrays.asList(2, 3, 4, 4, 5), Arrays.asList(1, 1, 1, 1, 2)),
				CoreMatchers.equalTo(2L));

		Assert.assertThat(JackGoesToRapture
						.getCost(5, Arrays.asList(1, 1, 2, 3, 1, 4), Arrays.asList(2, 3, 4, 4, 5, 5), Arrays.asList(1, 1, 1, 1,
								2, 1)),
				CoreMatchers.equalTo(1L));

		Assert.assertThat(
				JackGoesToRapture.getCost(5, Arrays.asList(1, 2, 3, 4), Arrays.asList(2, 3, 4, 5), Arrays.asList(1, 2, 3, 4)),
				CoreMatchers.equalTo(4L));

		Assert.assertThat(JackGoesToRapture.getCost(3, Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 1), Arrays.asList(10, 40,
				30)),
				CoreMatchers.equalTo(30L));

		Assert.assertThat(JackGoesToRapture.getCost(3, Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 1), Arrays.asList(10, 30,
				30)),
				CoreMatchers.equalTo(30L));

		Assert.assertThat(JackGoesToRapture.getCost(3, Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 1), Arrays.asList(10, 20,
				30)),
				CoreMatchers.equalTo(20L));

		Assert.assertThat(JackGoesToRapture.getCost(3, Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 1), Arrays.asList(10, 15,
				30)),
				CoreMatchers.equalTo(15L));

		Assert.assertThat(JackGoesToRapture
						.getCost(5, Arrays.asList(1, 2, 3, 4, 1), Arrays.asList(2, 3, 4, 5, 5), Arrays.asList(1, 2, 3, 4, 2)),
				CoreMatchers.equalTo(2L));

		Assert.assertThat(JackGoesToRapture.getCost(5, Arrays.asList(1, 2, 3, 4, 1, 3), Arrays.asList(2, 3, 4, 5, 3, 5),
				Arrays.asList(30, 50, 70, 90, 70, 85)), CoreMatchers.equalTo(85L));

		Assert.assertThat(JackGoesToRapture
						.getCost(5, Arrays.asList(1, 3, 1, 4, 2), Arrays.asList(2, 5, 4, 5, 3), Arrays.asList(60, 70, 120, 150,
								80)),
				CoreMatchers.equalTo(80L));

		Assert.assertThat(JackGoesToRapture
						.getCost(5, Arrays.asList(1, 2, 3, 4, 1), Arrays.asList(2, 4, 4, 5, 3), Arrays.asList(20, 10, 10, 25,
								30)),
				CoreMatchers.equalTo(25L));

		Assert.assertThat(JackGoesToRapture
				.getCost(9, Arrays.asList(1, 2, 3, 4, 1, 5, 6, 5, 7, 8), Arrays.asList(2, 4, 4, 5, 3, 6, 9, 7, 8, 9),
						Arrays.asList(20, 10, 10, 25, 30, 25, 80, 30, 40, 50)), CoreMatchers.equalTo(50L));
	}
}