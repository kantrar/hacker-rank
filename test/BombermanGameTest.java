import org.junit.Test;

public class BombermanGameTest {

	@Test
	public void test() {
//		String[] result = BombermanGame
//				.bomberMan(3, new String[] {".......", "...O...", "....O..", ".......", "OO.....", "OO....."});
//		for (String s : result) {
//			System.out.println(s);
//		}

	}

	@Test
	public void test2() {
		String[] result = BombermanGame
				.bomberMan(5, new String[] {".......", "...O.O.", "....O..", "..O....", "OO...OO", "OO.O..."});
		for (String s : result) {
			System.out.println(s);
		}


	}

}