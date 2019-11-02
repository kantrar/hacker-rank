import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CriticalConnectionsInANetworkTest {
	@Test
	public void test() {
		CriticalConnectionsInANetwork c = new CriticalConnectionsInANetwork();
		List<List<Integer>> res = c.criticalConnections(4,
				Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0), Arrays.asList(1, 3)));
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList(Arrays.asList(1, 3))));
	}
}
