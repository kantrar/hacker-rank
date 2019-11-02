import java.util.Arrays;

public class TripleSum {

	static long triplets(int[] a, int[] b, int[] c) {
		int aIdx = 0;
		int bIdx = 0;
		int cIdx = 0;
		long answer = 0;

		a = Arrays.stream(a).sorted().distinct().toArray();
		b = Arrays.stream(b).sorted().distinct().toArray();
		c = Arrays.stream(c).sorted().distinct().toArray();

		while (bIdx < b.length) {

			while (aIdx < a.length && a[aIdx] <= b[bIdx]) {
				aIdx++;
			}

			while (cIdx < c.length && c[cIdx] <= b[bIdx]) {
				cIdx++;
			}

			answer += (long) aIdx * (long) cIdx;
			bIdx++;
		}

		return answer;

	}

	// Still incorrect, too many edge cases place be handled
	static long triplets2(int[] a, int[] b, int[] c) {
		int aIdx = 0;
		int bIdx = 0;
		int cIdx = 0;
		int answer = 0;

		// 1 3 5    aIdx = 1
		// 2 3      bIdx = 0
		// 1 2 3    cIdx = 2
		// answer = 2
		// 1 3 5    aIdx = 2
		// 2 3      bIdx = 1
		// 1 2 3    cIdx = 3

		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		while (aIdx < a.length && bIdx < b.length && cIdx < c.length) {
			while (aIdx < a.length && bIdx < b.length && a[aIdx] > b[bIdx]) {
				bIdx++;
			}

			while (bIdx < b.length && cIdx < c.length && b[bIdx] < c[cIdx]) {
				bIdx++;
			}

			if (bIdx >= b.length) {
				bIdx--;

				while (aIdx < a.length && a[aIdx] <= b[bIdx]) {
					aIdx++;
				}

				while (cIdx < c.length && c[cIdx] <= b[bIdx]) {
					cIdx++;
				}

				answer += (aIdx * cIdx);
				return answer;
			} else {
				while (aIdx < a.length && a[aIdx] <= b[bIdx]) {
					aIdx++;
				}

				while (cIdx < c.length && c[cIdx] <= b[bIdx]) {
					cIdx++;
				}

				answer += (aIdx * cIdx);
			}
		}

		while (aIdx >= a.length && bIdx < b.length && cIdx < c.length) {
			while (bIdx < b.length && cIdx < c.length && b[bIdx] < c[cIdx]) {
				bIdx++;
			}

			if (bIdx >= b.length) {
				return answer;
			}

			while (cIdx < c.length && c[cIdx] <= b[bIdx]) {
				cIdx++;
			}
			answer += (aIdx * cIdx);
		}

		while (cIdx >= c.length && bIdx < b.length && aIdx < a.length) {
			while (aIdx < a.length && bIdx < b.length && a[aIdx] > b[bIdx]) {
				bIdx++;
			}

			if (bIdx >= b.length) {
				return answer;
			}

			while (aIdx < a.length && a[aIdx] <= b[bIdx]) {
				aIdx++;
			}
			answer += (aIdx * cIdx);
		}

		bIdx++;
		while (bIdx < b.length) {
			while (aIdx < a.length && bIdx < b.length && a[aIdx] > b[bIdx]) {
				bIdx++;
			}
			while (bIdx < b.length && cIdx < c.length && b[bIdx] < c[cIdx]) {
				bIdx++;
			}
			answer += (aIdx * cIdx);
			bIdx++;
		}

		return answer;
	}
}
