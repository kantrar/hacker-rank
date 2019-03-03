import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AliceAndBobSillyGameTest {
  @Test
  public void testSimple() {
    assertSolution(1, 1);
	assertSolution(2, 2);
	assertSolution(3, 1);
	assertSolution(4, 1);
	assertSolution(5, 2);
	assertSolution(6, 2);
    assertSolution(7, 1);
  }

  private void assertSolution(int n, int answer) {
    assertTrue(AliceAndBobSillyGame.sillyGame(n) == answer);
  }
}
