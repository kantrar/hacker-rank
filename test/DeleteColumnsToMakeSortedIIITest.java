import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class DeleteColumnsToMakeSortedIIITest {
	DeleteColumnsToMakeSortedIII d = new DeleteColumnsToMakeSortedIII();
	int res;

	@Test
	public void test() {
		assertResult(new String[] {"babca", "bbazb"}, 3);
		assertResult(new String[] {"edcba"}, 4);
		assertResult(new String[] {"ghi", "def", "abc"}, 0);
	}

	private void assertResult(String[] input, int expected) {
		res = d.minDeletionSize(input);
		Assert.assertThat(res, CoreMatchers.equalTo(expected));
	}
}
