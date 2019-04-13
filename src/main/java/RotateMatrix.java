import java.util.ArrayList;

public class RotateMatrix {
	public static class Cell {
		int row;
		int col;
	}

	// ??????????????
	public static void rotate(ArrayList<ArrayList<Integer>> input) {
		int size = input.size() % 2 == 0 ? input.size() / 2 : input.size() / 2 + 1;
		for (int i = 0; i < size; i++) {
			for (int j = i; j < input.size() - i - 1; j++) {
				rotateElement(input, i, j, i, i, input.size() - i, input.size() - i, input.size() - 2 * i);
			}
		}
	}

	public static void rotateElement(ArrayList<ArrayList<Integer>> input, int row, int col, int leftBound, int upperBound,
			int rightBound, int bottomBound, int size) {
		Cell newCell = getNewCell(row, col, leftBound, upperBound, rightBound, bottomBound, size, 1);
		int temp = input.get(newCell.row).get(newCell.col);
		input.get(newCell.row).set(newCell.col, input.get(row).get(col));

		newCell = getNewCell(newCell.row, newCell.col, leftBound, upperBound, rightBound, bottomBound, size, 2);
		int temp2 = input.get(newCell.row).get(newCell.col);
		input.get(newCell.row).set(newCell.col, temp);

		newCell = getNewCell(newCell.row, newCell.col, leftBound, upperBound, rightBound, bottomBound, size, 3);
		int temp3 = input.get(newCell.row).get(newCell.col);
		input.get(newCell.row).set(newCell.col, temp2);

		input.get(row).set(col, temp3);
	}

	public static Cell getNewCell(int row, int col, int leftBound, int upperBound, int rightBound, int bottomBound, int size,
			int direction) {
		Cell newCell = new Cell();
		switch (direction) {
		// top
		case 1:
			if (col + size - 1 < rightBound) {
				newCell.col = col + size - 1;
				newCell.row = row;
			} else {
				newCell.col = rightBound - 1;
				newCell.row = row + (size - (rightBound- col));
			}

			return newCell;
		// right
		case 2:
			if (row + size - 1 < bottomBound) {
				newCell.row = row + size - 1;
				newCell.col = col;
			} else {
				newCell.row = bottomBound - 1;
				newCell.col = col - (size - (bottomBound - row));
			}
			return newCell;
		// bottom
		case 3:
			if (col - size + 1 > 0) {
				newCell.col = col - size + 1;
				newCell.row = row;
			} else {
				newCell.col = leftBound;
				newCell.row = row - (size - (col - leftBound + 1));
			}
			return newCell;
		default:
			return null;
		}
	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> input = new ArrayList<>();
		//		ArrayList<Integer> a1 = new ArrayList<>();
		//		a1.add(1);
		//		a1.add(2);
		//		a1.add(3);
		//		a1.add(4);
		//		input.add(a1);
		//
		//		ArrayList<Integer> a2 = new ArrayList<>();
		//		a2.add(5);
		//		a2.add(6);
		//		a2.add(7);
		//		a2.add(8);
		//		input.add(a2);
		//
		//		ArrayList<Integer> a3 = new ArrayList<>();
		//		a3.add(9);
		//		a3.add(10);
		//		a3.add(11);
		//		a3.add(12);
		//		input.add(a3);
		//
		//		ArrayList<Integer> a4 = new ArrayList<>();
		//		a4.add(13);
		//		a4.add(14);
		//		a4.add(15);
		//		a4.add(16);
		//		input.add(a4);
		//
		//		rotate(input);
		//
		//		for (int i = 0; i < input.size(); i++) {
		//			for (int j = 0; j < input.get(i).size(); j++) {
		//				System.out.print(input.get(i).get(j) + ", ");
		//			}
		//			System.out.println();
		//		}
		//
		//		input = new ArrayList<>();
		//		a1 = new ArrayList<>();
		//		a1.add(1);
		//		a1.add(2);
		//		a1.add(4);
		//		input.add(a1);
		//
		//		a2 = new ArrayList<>();
		//		a2.add(5);
		//		a2.add(6);
		//		a2.add(7);
		//		input.add(a2);
		//
		//		a3 = new ArrayList<>();
		//		a3.add(9);
		//		a3.add(10);
		//		a3.add(11);
		//		input.add(a3);
		//
		//		rotate(input);
		//
		//		for (int i = 0; i < input.size(); i++) {
		//			for (int j = 0; j < input.get(i).size(); j++) {
		//				System.out.print(input.get(i).get(j) + ", ");
		//			}
		//			System.out.println();
		//		}

		int[][] inputArray = new int[][] {{27, 35, 36, 47, 94, 133, 163, 164, 235, 253, 280, 310, 339, 352},
				{46, 72, 77, 95, 144, 149, 158, 174, 242, 243, 317, 371, 378, 386},
				{13, 14, 80, 83, 121, 157, 158, 163, 215, 220, 308, 325, 388, 397},
				{11, 38, 45, 84, 105, 132, 134, 145, 184, 219, 282, 298, 380, 381},
				{23, 27, 42, 118, 120, 139, 168, 225, 243, 271, 274, 349, 393, 395},
				{22, 27, 49, 85, 103, 167, 175, 234, 241, 258, 283, 296, 352, 385},
				{24, 78, 117, 119, 137, 147, 173, 189, 193, 216, 281, 304, 332, 358},
				{27, 71, 108, 109, 112, 133, 137, 145, 150, 171, 195, 225, 260, 336},
				{5, 56, 65, 114, 123, 200, 220, 222, 248, 264, 285, 317, 350, 367},
				{2, 20, 60, 72, 75, 130, 136, 149, 189, 254, 264, 295, 315, 349},
				{23, 35, 68, 77, 104, 129, 153, 165, 248, 253, 290, 316, 321, 394},
				{34, 127, 129, 154, 186, 202, 203, 210, 235, 269, 331, 344, 376, 387},
				{11, 98, 99, 118, 119, 183, 250, 252, 277, 280, 291, 307, 360, 368},
				{42, 74, 93, 119, 178, 186, 198, 221, 234, 295, 296, 319, 322, 335},};

		for (int i = 0; i < inputArray.length; i++) {
			ArrayList<Integer> arrayList = new ArrayList<>();
			for (int j = 0; j < inputArray[i].length; j++) {
				arrayList.add(inputArray[i][j]);
			}
			input.add(arrayList);
		}

		rotate(input);

		for (int i = 0; i < input.size(); i++) {
			for (int j = 0; j < input.get(i).size(); j++) {
				System.out.print(input.get(i).get(j) + ", ");
			}
			System.out.println();
		}

	}
}
