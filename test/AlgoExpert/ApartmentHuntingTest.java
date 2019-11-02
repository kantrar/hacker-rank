package AlgoExpert;

import java.util.ArrayList;
import java.util.HashMap;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ApartmentHuntingTest {
	@Test
	public void test() {
		String[] reqs = new String[] {"gym", "school", "store"};
		ArrayList<HashMap<String, Boolean>> blocks = new ArrayList<>();
		HashMap<String, Boolean> map1 = new HashMap<>();
		map1.put("gym", false);
		map1.put("school", true);
		map1.put("store", false);
		blocks.add(map1);

		HashMap<String, Boolean> map2 = new HashMap<>();
		map2.put("gym", true);
		map2.put("school", false);
		map2.put("store", false);
		blocks.add(map2);

		HashMap<String, Boolean> map3 = new HashMap<>();
		map3.put("gym", true);
		map3.put("school", true);
		map3.put("store", false);
		blocks.add(map3);

		HashMap<String, Boolean> map4 = new HashMap<>();
		map4.put("gym", false);
		map4.put("school", true);
		map4.put("store", false);
		blocks.add(map4);

		HashMap<String, Boolean> map5 = new HashMap<>();
		map5.put("gym", false);
		map5.put("school", true);
		map5.put("store", true);
		blocks.add(map5);

		int res = ApartmentHunting.apartmentHunting(blocks, reqs);
		Assert.assertThat(res, CoreMatchers.equalTo(3));
	}
}
