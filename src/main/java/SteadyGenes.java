import java.io.IOException;
import java.util.Scanner;

public class SteadyGenes {

	// Complete the steadyGene function below.
	static int steadyGene(String gene) {
		int requiredForEach = gene.length() / 4;
		int[] count = countGenes(gene);
		int[] canBeReplaced = countCanBeReplaced(count, requiredForEach);
		int result = findSubstring(gene, canBeReplaced, 0, gene.length());
		return result;
	}

	private static int[] countCanBeReplaced(int[] count, int requiredForEach) {
		int[] canBeReplaced = new int[4];
		for (int i = 0; i < count.length; i++) {
			if (count[i] > requiredForEach) {
				canBeReplaced[i] = requiredForEach;
			} else {
				canBeReplaced[i] = count[i];
			}
		}
		return canBeReplaced;
	}

	private static int findSubstring(String gene, int[] canBeReplaced, int start, int end) {

		if (start >= end) {
			return 0;
		}

		boolean done = true;
		for (int i = 0; i < canBeReplaced.length; i++) {
			if (canBeReplaced[i] != 0) {
				done = false;
			}
		}

		if (done) {
			return end - start;
		}

		int[] clone1 = canBeReplaced.clone();
		int removeLeft = -1;
		int leftValue = convertGeneToValue(gene.charAt(start));
		if (clone1[leftValue] > 0) {
			clone1[leftValue]--;
			removeLeft = findSubstring(gene, clone1, start + 1, end);
		}

		int[] clone2 = canBeReplaced.clone();
		int removeRight = -1;
		int rightValue = convertGeneToValue(gene.charAt(end - 1));
		if (clone2[rightValue] > 0) {
			clone2[rightValue]--;
			removeRight = findSubstring(gene, clone2, start, end - 1);
		}

		if (removeLeft == -1 && removeRight == -1) {
			return end - start;
		}
		if (removeLeft == -1) {
			return removeRight;
		}
		if (removeRight == -1) {
			return removeLeft;
		}
		return Math.min(removeLeft, removeRight);
	}

	private static int[] countGenes(String gene) {
		int[] count = new int[4];
		for (int i = 0; i < gene.length(); i++) {
			count[convertGeneToValue(gene.charAt(i))]++;
		}
		return count;
	}

	private static int convertGeneToValue(char c) {
		if (c == 'A') {
			return 0;
		}
		if (c == 'C') {
			return 1;
		}
		if (c == 'G') {
			return 2;
		}
		if (c == 'T') {
			return 3;
		}
		return -1;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String gene = "GAAATAAA";

		int result = steadyGene(gene);
		System.out.println(result);
	}
}
