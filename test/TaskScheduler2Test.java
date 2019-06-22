import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TaskScheduler2Test {
	@Test
	public void test() {
		TaskScheduler2 t = new TaskScheduler2();
		int result = t.leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2);
		Assert.assertThat(result, CoreMatchers.equalTo(8));
	}
}