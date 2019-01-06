public class Ema {

	// Complete the twoPluses function below.
	static int twoPluses(String[] grid) {

		int row = grid.length;
		if (row == 0) {
			return 0;
		}

		int column = grid[0].length();
		if (column == 0) {
			return 0;
		}

		return getBiggest(grid, row, column, 2);
	}

	private static int getBiggest(String[] grid, int row, int column, int remaining) {

		int maxArea = 0;

		if (remaining == 0) {
			return 1;
		}

		int maxLength = row > column ? column : row;
		if (maxLength % 2 == 0) {
			maxLength--;
		}

		while (maxLength > 0) {
			int radius = (maxLength - 1) / 2;
			int possibleArea = radius*4 + 1;
			if (maxArea >= possibleArea * possibleArea && maxArea != 0) {
				break;
			}
			for (int startRow = radius; startRow < row - radius; startRow++) {
				for (int startCol = radius; startCol < column - radius; startCol++) {
					boolean success = true;
					for (int i = 0; i <= radius; i++) {
						if (isNotValid(grid, startRow, startCol, i)) {
							success = false;
							break;
						}
					}
					if (success) {
						String[] newGrid = markGrid(grid, startRow, startCol, radius);
						int currentArea = (radius * 4 + 1) * getBiggest(newGrid, row, column, remaining - 1);
						if (currentArea > maxArea) {
							maxArea = currentArea;
						}
					}
				}
			}
			maxLength--;
		}
		return maxArea;
	}

	private static boolean isNotValid(String[] grid, int startRow, int startCol, int r) {
		return grid[startRow].charAt(startCol - r) != 'G' || grid[startRow].charAt(startCol + r) != 'G'
				|| grid[startRow - r].charAt(startCol) != 'G' || grid[startRow + r].charAt(startCol) != 'G';
	}

	public static String[] markGrid(String[] grid, int row, int col, int radius) {
		String[] newGrid = new String[grid.length];
		for (int i = 0; i < grid.length; i++) {
			newGrid[i] = grid[i];
		}

		String insertedChars = "B";
		newGrid[row] = grid[row].substring(0, col).concat("B").concat(grid[row].substring(col + 1));
		for (int i = 1; i <= radius; i++) {
			newGrid[row - i] = grid[row - i].substring(0, col).concat("B").concat(grid[row - i].substring(col + 1));
			newGrid[row + i] = grid[row + i].substring(0, col).concat("B").concat(grid[row + i].substring(col + 1));
			insertedChars = insertedChars.concat("BB");
		}
		newGrid[row] = grid[row].substring(0, col - radius).concat(insertedChars).concat(grid[row].substring(col + radius + 1));

		return newGrid;
	}

	public static void main(String[] args) {
		//		String[] grid = new String[10];
		//		grid[0] = "bGbbbbbbbb";
		//		grid[1] = "bGbbbbbbbb";
		//		grid[2] = "bGbbbbbbbb";
		//		grid[3] = "bGbbbbbbbb";
		//		grid[4] = "GGGbbbbbbb";
		//		grid[5] = "bGbbbGbbbb";
		//		grid[6] = "bGbbGGGbbb";
		//		grid[7] = "bGbbbGbbbb";
		//		grid[8] = "bGbbbbbbbb";
		//		grid[9] = "bGbbbbbbbb";

		//		String[] grid = new String[5];
		//		grid[0] = "GGGGGG";
		//		grid[1] = "GBBBGB";
		//		grid[2] = "GGGGGG";
		//		grid[3] = "GGBBGB";
		//		grid[4] = "GGGGGG";

		String[] grid = new String[12];
		grid[0] =  "GGGGGGGGGGGG";
		grid[1] =  "GBGGBBBBBBBG";
		grid[2] =  "GBGGBBBBBBBG";
		grid[3] =  "GGGGGGGGGGGG";
		grid[4] =  "GGGGGGGGGGGG";
		grid[5] =  "GGGGGGGGGGGG";
		grid[6] =  "GGGGGGGGGGGG";
		grid[7] =  "GBGGBBBBBBBG";
		grid[8] =  "GBGGBBBBBBBG";
		grid[9] =  "GBGGBBBBBBBG";
		grid[10] = "GGGGGGGGGGGG";
		grid[11] = "GBGGBBBBBBBG";

		System.out.println("result: " + twoPluses(grid));
		//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		//
		//		String[] nm = scanner.nextLine().split(" ");
		//
		//		int n = Integer.parseInt(nm[0]);
		//
		//		int m = Integer.parseInt(nm[1]);
		//
		//		String[] grid = new String[n];
		//
		//		for (int i = 0; i < n; i++) {
		//			String gridItem = scanner.nextLine();
		//			grid[i] = gridItem;
		//		}
		//
		//		int result = twoPluses(grid);
		//
		//		bufferedWriter.write(String.valueOf(result));
		//		bufferedWriter.newLine();
		//
		//		bufferedWriter.close();
		//
		//		scanner.close();
	}
}
