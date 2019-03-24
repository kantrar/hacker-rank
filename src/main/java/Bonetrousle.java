public class Bonetrousle {

	static long[] bonetrousle(long total, long maxNumber, int boxes) {

		long min;
		long max;

		if (boxes % 2 == 0) {
			min = boxes / 2;
			min = min * (boxes + 1);
		} else {
			min = (boxes + 1) / 2;
			min = min * boxes;
		}

		if (total < min) {
			return new long[] {-1};
		}

		long[] answers = new long[boxes];

		long remainder = (total - min) % boxes;
		long equalParts = (total - min) / boxes;

		for (int i = boxes - 1; i >= 0; i--) {
			if (remainder > 0) {
				answers[i] = i + 1 + equalParts + 1;
				remainder--;
			} else {
				answers[i] = i + 1 + equalParts;
			}
		}

		if (answers[boxes - 1] > maxNumber) {
			return new long[] {-1};
		}

		return answers;
	}

	// Timeout
	static long[] bonetrousle2(long total, long maxNumber, int boxes) {

		long min = boxes * (boxes + 1) / 2;
		long max = boxes * (2 * maxNumber - boxes + 1) / 2;

		if (total < min || total > max) {
			return new long[] {-1};
		}

		long border = maxNumber > total ? total : maxNumber;
		for (long i = border; i >= 1; i--) {
			if (total - i == 0 && boxes - 1 != 0) {
				continue;
			}

			if (total - i == 0 && boxes - 1 == 0) {
				return new long[] {i};
			}

			long[] tempAnswers = bonetrousle2(total - i, i - 1, boxes - 1);
			if (tempAnswers[0] != -1) {
				long[] answers = new long[boxes];
				for (int j = 0; j < boxes - 1; j++) {
					answers[j] = tempAnswers[j];
				}
				answers[boxes - 1] = i;
				return answers;
			}
		}

		return new long[] {-1};
	}
}
