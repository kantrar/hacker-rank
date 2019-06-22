import org.junit.Test;

public class SpiralMatrixIIITest {
	@Test
	public void test() {
		SpiralMatrixIII s = new SpiralMatrixIII();
		int[][] result = s.spiralMatrixIII(5, 6, 1, 4);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.println(result[i][j] + ", ");
			}
			System.out.println();
		}
	}
}