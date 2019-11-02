import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class RemoveAllAdjacentDuplicatesInStringIITest {
	@Test
	public void test() {
		RemoveAllAdjacentDuplicatesInStringII r = new RemoveAllAdjacentDuplicatesInStringII();
		String res;
		res = r.removeDuplicates("abcd", 2);
		Assert.assertThat(res, CoreMatchers.equalTo("abcd"));

		res = r.removeDuplicates("deeedbbcccbdaa", 3);
		Assert.assertThat(res, CoreMatchers.equalTo("aa"));

		res = r.removeDuplicates("pbbcggttciiippooaais", 2);
		Assert.assertThat(res, CoreMatchers.equalTo("ps"));

		res = r.removeDuplicates("pbcc", 2);
		Assert.assertThat(res, CoreMatchers.equalTo("pb"));

		res = r.removeDuplicates("pbccdccd", 2);
		Assert.assertThat(res, CoreMatchers.equalTo("pb"));

		res = r.removeDuplicates("pbcccccc", 2);
		Assert.assertThat(res, CoreMatchers.equalTo("pb"));
	}
}
