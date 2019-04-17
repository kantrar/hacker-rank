import java.util.List;

import org.junit.Test;

public class PacificAtlanticWaterFlowTest {
	@Test
	public void test() {
		PacificAtlanticWaterFlow p = new PacificAtlanticWaterFlow();
		List<int[]> result;
		//		result = p.pacificAtlantic(
		//				new int[][] {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});

		//		result = p.pacificAtlantic(new int[][] {{1, 1}, {1, 1}, {1, 1}});

		//		result = p.pacificAtlantic(new int[][] {{11, 3, 2, 4, 14, 6, 13, 18, 1, 4, 12, 2, 4, 1, 16},
		//				{5, 11, 18, 0, 15, 14, 6, 17, 2, 17, 19, 15, 12, 3, 14},
		//				{10, 2, 5, 13, 11, 11, 13, 19, 11, 17, 14, 18, 14, 3, 11}, {14, 2, 10, 7, 5, 11, 6, 11, 15, 11, 6, 11,
		// 12, 3,
		//				11},
		//				{13, 1, 16, 15, 8, 2, 16, 10, 9, 9, 10, 14, 7, 15, 13}, {17, 12, 4, 17, 16, 5, 0, 4, 10, 15, 15, 15, 14,
		// 5, 18},
		//				{9, 13, 18, 4, 14, 6, 7, 8, 5, 5, 6, 16, 13, 7, 2}, {19, 9, 16, 19, 16, 6, 1, 11, 7, 2, 12, 10, 9, 18,
		// 19},
		//				{19, 5, 19, 10, 7, 18, 6, 10, 7, 12, 14, 8, 4, 11, 16}, {13, 3, 18, 9, 16, 12, 1, 0, 1, 14, 2, 6, 1, 16,
		// 6},
		//				{14, 1, 12, 16, 7, 15, 9, 19, 14, 4, 16, 6, 11, 15, 7}, {6, 15, 19, 13, 3, 2, 13, 7, 19, 11, 13, 16, 0,
		// 16, 16},
		//				{1, 5, 9, 7, 12, 9, 2, 18, 6, 12, 1, 8, 1, 10, 19}, {10, 11, 10, 11, 3, 5, 12, 0, 0, 8, 15, 7, 5, 13,
		// 19},
		//				{8, 1, 17, 18, 3, 6, 8, 15, 0, 9, 8, 8, 12, 5, 18}, {8, 3, 6, 12, 18, 15, 10, 10, 12, 19, 16, 7, 17, 17,
		// 1},
		//				{12, 13, 6, 4, 12, 18, 18, 9, 4, 9, 13, 11, 5, 3, 14}, {8, 4, 12, 11, 2, 2, 10, 3, 11, 17, 14, 2, 17, 4,
		// 7},
		//				{8, 0, 14, 0, 13, 17, 11, 0, 16, 13, 15, 17, 4, 8, 3}, {18, 15, 8, 11, 18, 3, 10, 18, 3, 3, 15, 9, 11,
		// 15, 15}});

		//		result = p.pacificAtlantic(new int[][] {
		//				{11, 2, 11, 0, 15, 12, 4, 15, 0, 14, 11, 3, 19, 11, 5, 11, 18, 19, 4, 3, 11, 1, 9, 17, 5, 2, 15, 18, 11,
		// 15},
		//				{12, 10, 8, 15, 4, 7, 4, 5, 7, 8, 5, 12, 3, 3, 10, 12, 16, 15, 17, 13, 13, 16, 0, 0, 17, 17, 11, 3, 14,
		// 0},
		//				{8, 18, 1, 6, 15, 16, 14, 11, 9, 11, 3, 4, 17, 7, 2, 16, 18, 2, 0, 0, 16, 18, 10, 15, 14, 18, 10, 19,
		// 17, 6},
		//				{14, 17, 4, 13, 13, 6, 16, 1, 3, 18, 18, 18, 4, 1, 15, 4, 0, 9, 19, 3, 6, 7, 19, 13, 11, 11, 10, 19, 3,
		// 15},
		//				{16, 6, 19, 17, 19, 17, 5, 12, 6, 3, 1, 0, 3, 10, 13, 18, 4, 3, 9, 0, 1, 18, 9, 15, 18, 3, 4, 6, 1, 15},
		//				{1, 2, 12, 9, 9, 7, 17, 0, 1, 14, 18, 1, 5, 3, 0, 7, 2, 19, 7, 19, 1, 11, 1, 3, 2, 4, 0, 3, 16, 18},
		//				{18, 10, 10, 3, 12, 11, 7, 8, 3, 16, 7, 11, 11, 12, 15, 1, 13, 9, 8, 17, 1, 9, 7, 19, 1, 14, 8, 10, 18,
		// 14},
		//				{5, 19, 9, 4, 10, 14, 1, 5, 11, 16, 11, 3, 5, 4, 19, 8, 11, 16, 19, 12, 6, 3, 18, 16, 17, 8, 11, 19, 7,
		// 14},
		//				{0, 15, 17, 11, 10, 13, 19, 0, 10, 3, 15, 19, 3, 3, 3, 4, 3, 12, 17, 10, 5, 16, 12, 5, 5, 17, 5, 17, 6,
		// 6},
		//				{8, 19, 9, 3, 13, 8, 13, 17, 4, 12, 13, 8, 13, 12, 10, 10, 16, 7, 2, 8, 17, 3, 7, 1, 7, 16, 11, 19, 13,
		// 19},
		//				{6, 19, 6, 13, 10, 5, 14, 7, 3, 1, 10, 6, 4, 8, 15, 0, 0, 2, 12, 13, 14, 14, 7, 5, 1, 16, 15, 15, 4, 7},
		//				{7, 7, 11, 14, 2, 4, 14, 2, 2, 0, 6, 11, 15, 14, 11, 13, 2, 3, 14, 9, 16, 3, 8, 15, 2, 18, 15, 15, 2, 2},
		//				{7, 5, 12, 10, 14, 3, 6, 9, 2, 1, 2, 15, 0, 4, 7, 9, 7, 12, 15, 9, 2, 13, 7, 8, 7, 9, 4, 3, 5, 19},
		//				{11, 9, 1, 8, 0, 15, 1, 6, 5, 11, 14, 19, 6, 11, 0, 12, 1, 6, 8, 7, 0, 1, 2, 9, 14, 4, 5, 8, 3, 16},
		//				{8, 0, 11, 5, 14, 4, 19, 0, 6, 8, 1, 10, 13, 8, 18, 6, 6, 4, 5, 9, 10, 14, 14, 13, 12, 16, 4, 3, 3, 11},
		//				{0, 9, 6, 19, 16, 4, 5, 10, 13, 19, 8, 15, 14, 7, 13, 11, 17, 18, 14, 18, 19, 11, 0, 4, 12, 11, 2, 8,
		// 17, 14},
		//				{16, 19, 16, 9, 9, 14, 5, 13, 7, 10, 18, 6, 15, 12, 12, 1, 11, 16, 1, 8, 1, 7, 16, 7, 19, 6, 12, 0, 15,
		// 0},
		//				{2, 4, 18, 15, 13, 9, 4, 18, 19, 5, 16, 7, 10, 1, 7, 7, 4, 4, 10, 8, 13, 15, 9, 4, 16, 13, 6, 3, 13, 7},
		//				{3, 11, 10, 13, 6, 4, 0, 13, 11, 4, 5, 6, 19, 13, 8, 10, 8, 9, 2, 4, 4, 11, 12, 8, 12, 15, 6, 1, 10, 12},
		//				{7, 6, 19, 3, 2, 14, 15, 6, 9, 1, 6, 14, 4, 15, 13, 9, 14, 7, 10, 12, 17, 18, 6, 4, 12, 4, 1, 6, 6, 12},
		//				{15, 17, 9, 15, 9, 15, 9, 10, 10, 11, 12, 17, 2, 18, 11, 0, 6, 11, 14, 17, 2, 13, 9, 13, 3, 4, 3, 1, 8,
		// 11},
		//				{17, 13, 12, 17, 4, 19, 19, 7, 7, 13, 19, 10, 4, 16, 1, 18, 14, 2, 9, 18, 2, 8, 3, 1, 10, 9, 12, 6, 2,
		// 11},
		//				{17, 12, 6, 8, 3, 16, 5, 2, 16, 3, 13, 3, 13, 9, 11, 11, 5, 12, 14, 16, 3, 19, 16, 16, 1, 14, 5, 3, 17,
		// 19},
		//				{1, 4, 0, 3, 1, 17, 5, 15, 2, 19, 12, 7, 18, 13, 1, 0, 7, 2, 9, 18, 10, 18, 8, 9, 13, 13, 8, 10, 14, 14},
		//				{9, 14, 4, 18, 10, 18, 3, 9, 9, 17, 16, 4, 19, 7, 3, 18, 7, 0, 10, 13, 9, 10, 11, 16, 3, 5, 1, 2, 16,
		// 19},
		//				{8, 10, 13, 8, 7, 2, 9, 4, 16, 15, 5, 4, 15, 7, 9, 7, 15, 2, 6, 17, 14, 3, 13, 3, 4, 15, 13, 10, 8, 16},
		//				{17, 7, 19, 19, 13, 12, 6, 0, 11, 4, 10, 4, 1, 9, 15, 9, 7, 7, 14, 6, 7, 18, 9, 13, 6, 16, 5, 2, 17, 1},
		//				{2, 7, 0, 4, 8, 18, 4, 11, 13, 4, 11, 12, 3, 18, 11, 2, 4, 18, 3, 3, 17, 9, 18, 11, 9, 15, 14, 19, 7,
		// 17},
		//				{13, 1, 15, 18, 4, 12, 18, 18, 15, 16, 7, 17, 9, 15, 11, 3, 9, 7, 18, 13, 3, 11, 7, 19, 10, 10, 7, 13,
		// 7, 19},
		//				{17, 17, 14, 3, 19, 7, 1, 13, 9, 3, 6, 16, 10, 8, 14, 8, 17, 18, 12, 11, 4, 11, 10, 15, 9, 0, 4, 12, 7,
		// 15},
		//				{4, 4, 8, 1, 7, 11, 13, 4, 11, 5, 18, 2, 16, 11, 16, 13, 0, 13, 13, 12, 11, 15, 8, 4, 0, 3, 2, 9, 8, 15},
		//				{17, 4, 13, 5, 3, 17, 14, 4, 7, 6, 6, 11, 16, 18, 2, 0, 3, 12, 1, 5, 12, 16, 3, 14, 4, 16, 5, 8, 15, 9},
		//				{5, 3, 17, 17, 6, 4, 19, 5, 4, 6, 11, 4, 14, 18, 4, 19, 16, 15, 1, 17, 3, 8, 13, 14, 16, 13, 18, 19, 6,
		// 4},
		//				{15, 0, 8, 15, 6, 6, 11, 8, 18, 2, 4, 10, 18, 16, 15, 8, 1, 5, 9, 13, 7, 19, 12, 2, 9, 18, 1, 15, 12, 8},
		//				{5, 0, 18, 14, 1, 8, 18, 15, 5, 13, 15, 7, 8, 8, 9, 0, 14, 12, 4, 17, 2, 10, 9, 7, 19, 7, 19, 9, 7, 1},
		//				{7, 4, 16, 16, 13, 4, 3, 6, 15, 11, 14, 7, 3, 0, 5, 15, 10, 13, 18, 18, 11, 6, 7, 9, 19, 13, 4, 2, 7, 9},
		//				{9, 14, 15, 11, 14, 5, 15, 1, 19, 15, 3, 4, 0, 10, 4, 1, 2, 15, 18, 15, 15, 2, 9, 0, 3, 10, 9, 16, 4, 1},
		//				{14, 13, 17, 19, 0, 13, 15, 9, 16, 18, 5, 6, 16, 16, 6, 10, 14, 15, 17, 5, 9, 2, 5, 11, 19, 19, 11, 6,
		// 15, 14},
		//				{17, 7, 19, 6, 5, 19, 10, 2, 11, 17, 17, 13, 16, 13, 19, 4, 12, 3, 4, 13, 7, 9, 19, 9, 12, 3, 16, 8, 18,
		// 13}});
		//		result = p.pacificAtlantic(new int[][] {
		//				{10, 10, 10},
		//				{10, 1, 10},
		//				{10, 10, 10}});

		result = p.pacificAtlantic(new int[][] {{6, 8, 15, 4, 0, 5, 2}, {11, 2, 18, 0, 16, 9, 19}, {18, 10, 7, 6, 0, 18, 2},
				{16, 16, 7, 9, 13, 14, 18}, {17, 18, 3, 2, 2, 0, 16}, {1, 12, 18, 9, 11, 17, 3}, {14, 5, 5, 14, 16, 15, 13},
				{15, 1, 18, 8, 15, 19, 4}, {16, 17, 16, 10, 17, 7, 4}, {8, 14, 8, 7, 10, 5, 11}, {6, 19, 4, 10, 12, 14, 10},
				{10, 18, 12, 3, 6, 16, 12}, {2, 16, 11, 19, 9, 3, 1}, {9, 18, 8, 7, 2, 12, 15}, {10, 14, 12, 1, 4, 14, 12},
				{13, 19, 3, 3, 16, 14, 2}, {7, 4, 4, 3, 15, 4, 18}, {12, 8, 5, 11, 18, 16, 11}, {10, 14, 18, 15, 9, 9, 5},
				{8, 9, 6, 15, 2, 19, 5}, {14, 7, 10, 9, 0, 3, 6}, {11, 8, 18, 5, 11, 17, 9}, {4, 17, 18, 15, 3, 0, 11},
				{19, 18, 19, 15, 7, 16, 17}, {7, 11, 11, 7, 16, 16, 0}, {13, 9, 13, 1, 17, 1, 19}, {12, 7, 16, 1, 4, 10, 12},
				{2, 16, 18, 19, 11, 4, 9}, {7, 14, 0, 4, 19, 2, 11}, {1, 9, 14, 9, 13, 13, 16}, {9, 12, 9, 6, 15, 2, 6},
				{7, 18, 2, 4, 8, 14, 14}, {18, 19, 16, 14, 1, 2, 3}, {2, 11, 17, 11, 19, 4, 6}, {1, 14, 17, 9, 11, 8, 9},
				{0, 2, 10, 1, 17, 6, 16}, {8, 18, 1, 10, 4, 19, 8}, {14, 1, 3, 15, 13, 7, 2}, {12, 2, 10, 3, 0, 8, 6},
				{1, 6, 9, 17, 12, 5, 12}, {3, 10, 5, 13, 9, 0, 17}, {11, 2, 19, 8, 2, 10, 8}, {2, 11, 3, 8, 14, 17, 11},
				{10, 14, 11, 13, 15, 3, 16}, {8, 7, 12, 19, 11, 17, 2}, {3, 14, 1, 14, 0, 2, 15}, {3, 5, 4, 13, 18, 17, 8},
				{14, 16, 12, 2, 10, 11, 15}, {16, 2, 5, 12, 19, 4, 6}, {9, 9, 12, 9, 8, 8, 2}} );
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).length; j++) {
				System.out.print(result.get(i)[j] + ", ");

			}
			System.out.println();
		}

	}
}