import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;


public class NumberOfValidWordsForEachPuzzleTest {
	@Test
	public void test() {
		NumberOfValidWordsForEachPuzzle n = new NumberOfValidWordsForEachPuzzle();
		List<Integer> result;

		result = n.findNumOfValidWords(new String[] {"baggage", "faced", "based", "cabbage", "beefed"}, new String[] {"abcdefg"
		});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(3)));

		result = n.findNumOfValidWords(new String[] {"baggage", "faced", "based"}, new String[] {"abcdefg", "facedb"});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(2, 1)));

		result = n.findNumOfValidWords(new String[] {"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
				new String[] {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"});
		Assert.assertThat(result, CoreMatchers.equalTo(Arrays.asList(1, 1, 3, 2, 4, 0)));
	}
}
