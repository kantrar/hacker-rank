import org.junit.Test;

public class BonetrousleTest {
	@Test
	public void test() {
		long[] result = Bonetrousle.bonetrousle(4, 3, 2);
		for (int i = 0; i < result.length; i++) {
		System.out.println(result[i]);

		}
	}
}