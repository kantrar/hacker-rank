import org.junit.Test;

public class KClosestPointToOriginTest {
	@Test
	public void test() {
		KClosestPointToOrigin k = new KClosestPointToOrigin();
		k.kClosest(new int[][] {{10, -2}, {2, -2}, {10, 10}, {9, 4}, {-8, 1}}, 4);
	}
}