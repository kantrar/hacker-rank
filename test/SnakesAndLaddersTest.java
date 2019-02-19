import java.io.ByteArrayInputStream;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class SnakesAndLaddersTest {
	@Test
	public void testSample() {
		String input = "3\n" + "32 62\n" + "42 68\n" + "12 98\n" + "7\n" + "95 13\n" + "97 25\n" + "93 37\n" + "79 27\n" + "75 "
				+ " 19\n " + "49 47\n" + "67 17\n";
		assertAnswer(input, 3);

		input = "4\n" + "8 52\n" + "6 80\n" + "26 42\n" + "2 72\n" + "9\n" + "51 19\n" + "39 11\n" + "37 29\n" + "81 3\n"
				+ "59 5\n" + "79 23\n" + "53 7\n" + "43 33\n" + "77 21";

		assertAnswer(input, 5);

		input = "2 5 15 14 98 0";
		assertAnswer(input, 4);
		input = "2 5 15 14 98 1 12 4";
		assertAnswer(input, 4);

		input = "0 0";
		assertAnswer(input, 17);

		input = "0 1 96 34";
		assertAnswer(input, 17);

		input = "0 5 12 6 17 5 22 12 27 13 26 11";
		assertAnswer(input, 17);

		input = "3 1 15 14 98 6 96 0";
		assertAnswer(input, 2);

		input = "3 1 15 14 98 7 96 0";
		assertAnswer(input, 2);

		input = "3 1 15 14 45 6 17 0";
		assertAnswer(input, 13);

		input = "3 2 12 14 45 6 17 0";
		assertAnswer(input, 12);

		input = "2 2 12 6 9 0";
		assertAnswer(input, 16);

		input = "3 2 15 14 98 6 96 3 5 2 98 56 99 63";
		assertAnswer(input, 2);

		input = "3 2 15 14 45 6 17 3 5 2 98 56 99 63";
		assertAnswer(input, 13);

		input = "2 2 12 6 9 3 6 2 98 56 99 63";
		assertAnswer(input, 16);

		input = "2\n" + "3 54\n" + "37 100\n" + "1\n" + "56 33";
		assertAnswer(input, 3);

		input = "2\n" + "3 57\n" + "8 100\n" + "1\n" + "88 44";
		assertAnswer(input, 2);

		input = "1\n" + "7 98\n" + "1\n" + "99 1";
		assertAnswer(input, 2);

		input = "0 6 99 1 98 2 97 3 96 5 95 5 94 4";
		assertAnswer(input, -1);
//
//		input = "0 5 99 1 98 2 97 3 96 5 95 5";
//		assertAnswer(input, 17);
	}

	private void assertAnswer(String input, int expectedOutcome) {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		Assert.assertThat(SnakesAndLadders.quickestWayUp(), CoreMatchers.equalTo(expectedOutcome));

		System.setIn(System.in);
	}

}