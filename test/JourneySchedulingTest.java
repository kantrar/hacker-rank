import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class JourneySchedulingTest {
	@Test
	public void test() {
		long[] result;
		result = JourneyScheduling.journeyScheduling(8, new int[][] {{2, 1}, {3, 2}, {4, 2}, {5, 1}, {6, 1}, {7, 1}, {8, 7}},
				new int[][] {{4, 6}, {3, 4}, {6, 3}, {7, 6}, {4, 6}, {7, 1}, {2, 6}});
		Assert.assertThat(result, CoreMatchers.equalTo(new long[] {24, 16, 11, 23, 24, 3, 23}));

		result = JourneyScheduling
				.journeyScheduling(6, new int[][] {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}}, new int[][] {{1, 6}, {2, 4}});
		Assert.assertThat(result, CoreMatchers.equalTo(new long[] {11, 8}));

		result = JourneyScheduling
				.journeyScheduling(6, new int[][] {{1, 2}, {1, 3}, {1, 4}, {4, 5}, {4, 6}}, new int[][] {{1, 2}, {2, 1}, {4,
						4}});
		Assert.assertThat(result, CoreMatchers.equalTo(new long[] {5, 3, 11}));

		result = JourneyScheduling.journeyScheduling(100,
				new int[][] {{12, 41}, {12, 57}, {41, 22}, {41, 4}, {53, 41}, {49, 22}, {57, 75}, {22, 96}, {4, 66}, {96, 31},
						{96, 76}, {94, 96}, {61, 66}, {28, 94}, {61, 60}, {50, 60}, {60, 7}, {28, 91}, {28, 51}, {60, 79},
						{7, 30}, {30, 24}, {27, 79}, {30, 65}, {30, 97}, {27, 84}, {97, 2}, {56, 2}, {14, 56}, {14, 86}, {86,
						23},
						{14, 44}, {70, 44}, {23, 43}, {43, 90}, {70, 32}, {43, 54}, {82, 54}, {90, 81}, {83, 82}, {82, 67},
						{83, 46}, {72, 82}, {100, 67}, {100, 71}, {26, 72}, {72, 36}, {36, 64}, {71, 89}, {36, 25}, {26, 20},
						{80, 89}, {64, 48}, {63, 25}, {11, 48}, {87, 20}, {80, 1}, {1, 19}, {1, 21}, {37, 87}, {37, 69}, {19, 5},
						{37, 33}, {69, 10}, {45, 33}, {35, 33}, {40, 10}, {13, 45}, {6, 13}, {15, 40}, {85, 6}, {6, 47}, {13, 8},
						{47, 98}, {99, 85}, {16, 47}, {88, 98}, {88, 9}, {55, 99}, {99, 92}, {9, 93}, {77, 93}, {59, 55},
						{62, 93}, {18, 77}, {18, 39}, {18, 73}, {38, 62}, {58, 73}, {95, 73}, {73, 42}, {34, 95}, {52, 34},
						{34, 74}, {3, 52}, {3, 68}, {17, 52}, {74, 29}, {78, 29}},
				new int[][] {{29, 1}, {85, 827633810}, {45, 349400802}});
		Assert.assertThat(result, CoreMatchers.equalTo(new long[] {41, 34760620008L, 14674833669L}));
	}
}