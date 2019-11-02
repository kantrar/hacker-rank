import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ReconstructItineraryTest {
	ReconstructItinerary i = new ReconstructItinerary();
	List<String> res;

	@Test
	public void test() {

		res = i.findItinerary(Arrays.asList());
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList("JFK")));

		res = i.findItinerary(Arrays.asList(Arrays.asList("JFK", "MUC")));
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList("JFK", "MUC")));

		res = i.findItinerary(Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC")));
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList("JFK", "MUC", "LHR")));

		res = i.findItinerary(Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"), Arrays.asList("SFO",
				"SJC"),
				Arrays.asList("LHR", "SFO")));
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC")));

		res = i.findItinerary(Arrays.asList(Arrays.asList("JFK", "ATL"), Arrays.asList("JFK", "SFO"), Arrays.asList("SFO",
				"ATL"),
				Arrays.asList("ATL", "JFK"), Arrays.asList("ATL", "SFO")));
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO")));

		res = i.findItinerary(Arrays.asList(Arrays.asList("JFK", "ATL"), Arrays.asList("JFK", "ATL"), Arrays.asList("JFK",
				"ATL"),
				Arrays.asList("ATL", "JFK"), Arrays.asList("ATL", "JFK")));
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList("JFK", "ATL", "JFK", "ATL", "JFK", "ATL")));
	}

	@Test
	public void testCyclic() {
		res = i.findItinerary(
				Arrays.asList(Arrays.asList("JFK", "KUL"), Arrays.asList("JFK", "NRT"), Arrays.asList("NRT", "JFK")));
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList("JFK", "NRT", "JFK", "KUL")));
	}

	@Test
	public void testLexi() {
		res = i.findItinerary(Arrays.asList(Arrays.asList("JFK", "BAD"), Arrays.asList("JFK", "ATL"), Arrays.asList("BAD",
				"JFK"),
				Arrays.asList("ATL", "DEC")));
		Assert.assertThat(res, CoreMatchers.equalTo(Arrays.asList("JFK", "BAD", "JFK", "ATL", "DEC")));
	}
}
