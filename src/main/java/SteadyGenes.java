import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SteadyGenes {

	static int steadyGene(String gene) {
		int size = gene.length() / 4;
		int[] count = new int[4];
		Map<String, Integer> answers = new HashMap<>();

		for (int i = 0; i < gene.length(); i++) {
			count[getKey(gene.charAt(i))]++;
		}

		Integer[] total = new Integer[4];
		int[] required = new int[4];
		for (int i = 0; i < 4; i++) {
			if (count[i] > size) {
				required[i] = count[i] - size;
				total[i] = count[i];
			} else {
				total[i] = null;
			}
		}

		return findSubstring(gene, 0, gene.length() - 1, total, required, answers);
	}

	private static int findSubstring(String gene, int left, int right, Integer[] total, int[] required,
			Map<String, Integer> answers) {
		if (left > right) {
			return 0;
		}

		String answerKey = gene.substring(left, right + 1);

		int leftKey = getKey(gene.charAt(left));
		int rightKey = getKey(gene.charAt(right));
		if (total[leftKey] == null) {
			int res = findSubstring(gene, left + 1, right, total, required, answers);
			answers.put(answerKey, res);
			return res;
		}

		if (total[rightKey] == null) {
			int res = findSubstring(gene, left, right - 1, total, required, answers);
			answers.put(answerKey, res);
			return res;
		}

		if (total[leftKey] == required[leftKey] && total[rightKey] == required[rightKey]) {
			answers.put(answerKey, right - left + 1);
			return right - left + 1;
		}

		if (total[leftKey] == required[leftKey]) {
			total[rightKey]--;
			int res = findSubstring(gene, left, right - 1, total, required, answers);
			total[rightKey]++;

			answers.put(answerKey, res);
			return res;
		}

		if (total[rightKey] == required[rightKey]) {
			total[leftKey]--;
			int res = findSubstring(gene, left + 1, right, total, required, answers);
			total[leftKey]++;
			return res;
		}

		int res1 = Integer.MAX_VALUE;
		int res2 = Integer.MAX_VALUE;
		if (total[leftKey] > required[leftKey]) {
			total[leftKey]--;
			res1 = findSubstring(gene, left + 1, right, total, required, answers);
			total[leftKey]++;
		}

		if (total[rightKey] > required[rightKey]) {
			total[rightKey]--;
			res2 = findSubstring(gene, left, right - 1, total, required, answers);
			total[rightKey]++;
		}

		int result = Math.min(res1, res2);
		if (result == Integer.MAX_VALUE) {
			answers.put(answerKey, right - left + 1);
			return right - left + 1;
		} else {
			answers.put(answerKey, result);
			return result;
		}
	}

	private static int getKey(char c) {
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
