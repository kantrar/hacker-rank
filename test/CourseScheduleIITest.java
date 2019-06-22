import org.junit.Test;

public class CourseScheduleIITest {
	@Test
	public void test() {
		CourseScheduleII c = new CourseScheduleII();
		int[] result;
		result = c.findOrder(2, new int[][] {{0,1}, {1, 0}});

		result = c.findOrder(3, new int[][] {{0, 1}, {0, 2}, {1, 2}});


	}
}