import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class CourseScheduleIIITest {
	@Test
	public void test() {
		CourseScheduleIII c = new CourseScheduleIII();
		int result = c.scheduleCourse(new int[][] {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}});
		Assert.assertThat(result, CoreMatchers.equalTo(3));
	}
}
