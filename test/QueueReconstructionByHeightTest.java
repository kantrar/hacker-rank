import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class QueueReconstructionByHeightTest {
	@Test
	public void test() {
		QueueReconstructionByHeight q = new QueueReconstructionByHeight();
		int[][] res;
		res = q.reconstructQueue(new int[][] {{7, 0}, {4, 2}, {7, 1}});
		Assert.assertThat(res, CoreMatchers.equalTo(new int[][] {{7, 0}, {7, 1}, {4, 2}}));

		res = q.reconstructQueue(new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
		Assert.assertThat(res, CoreMatchers.equalTo(new int[][] {{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}}));
	}
}
