import java.util.LinkedList;
import java.util.Queue;

public class UglyCode {
	public int nthUglyNumber(int max) {
		int n = max;
		if (n == 1) {
			return 1;
		}

		Queue<Integer> queue2 = new LinkedList<>();
		Queue<Integer> queue3 = new LinkedList<>();
		Queue<Integer> queue5 = new LinkedList<>();

		queue2.add(2);
		queue3.add(3);
		queue5.add(5);
		n--;
		int min = 0;
		int count = 3;

		while (n > 0) {
			int v2 = Integer.MAX_VALUE;
			int v3 = Integer.MAX_VALUE;
			int v5 = Integer.MAX_VALUE;
			if (!queue2.isEmpty()) {
				v2 = queue2.peek();
			}
			if (!queue3.isEmpty()) {
				v3 = queue3.peek();
			}
			if (!queue5.isEmpty()) {
				v5 = queue5.peek();
			}

			min = Math.min(v5, Math.min(v2, v3));

			int popElement = 0;
			if (min == v2) {
				popElement = queue2.remove();

				if (queue2.size() <= n) {
					queue2.add(popElement * 2);
					queue3.add(popElement * 3);
					queue5.add(popElement * 5);
				}

			} else if (min == v3) {
				popElement = queue3.remove();
				if (queue3.size() <= n) {
					queue3.add(popElement * 3);
					queue5.add(popElement * 5);
				}
			} else if (min == v5) {
				popElement = queue5.remove();
				if (queue5.size() <= n) {
					queue5.add(popElement * 5);
				}
			}

			n--;
		}

		return min;
	}

	public static void main(String[] args) {
		UglyCode uglyCode = new UglyCode();
		int result = uglyCode.nthUglyNumber(1600);
		System.out.println(result);
	}
}
