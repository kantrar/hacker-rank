public class PossibleCombinations {

	public static void main(String[] args) {

		int[] inputs = {1, 2, 3, 4, 5};

		for (int i = 0; i < 5; i++) {
			int[] data = new int[i + 1];
			printPossibleCombinations(inputs, data, 0, 4, 0, i+1);
		}

	}

	private static void printPossibleCombinations(int[] inputs, int[] data, int start, int end, int index, int size) {
		if (index == size) {
			for (int i = 0; i < data.length; i++) {
				System.out.print(data[i]);
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= end && end - i + 1 >= size - index; i++) {
			data[index] = inputs[i];
			printPossibleCombinations(inputs, data, i + 1, end, index + 1, size);
		}
	}
}
