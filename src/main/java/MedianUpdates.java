import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MedianUpdates {
	private static final String WRONG = "Wrong!";

	private static Scanner scanner = new Scanner(System.in);

	private static DecimalFormat form;

	private static class SortedList extends ArrayList<Integer> {
		public SortedList() {
		}

		public boolean addOperation(Integer integer) {
			int pos = findPosition(integer);
			super.add(pos, integer);
			printMedian();
			return true;
		}

		public boolean removeOperation(int integer) {
			if (!this.isEmpty()) {
				int pos = findPosition(integer);
				if (pos < this.size() && this.get(pos) == integer) {
					super.remove(pos);
					printMedian();
					return true;
				}
			}

			printWrong();
			return false;
		}

		private int findPosition(Integer integer) {
			if (this.isEmpty()) {
				return 0;
			}

			int left = 0;
			int right = this.size(); // exclusive
			int mid = (left + right) / 2;

			while (right - left >= 1) {
				if (this.get(mid) > integer) {
					right = mid;
				} else if (this.get(mid) < integer) {
					left = mid + 1;
				} else {
					return mid;
				}
				mid = (left + right) / 2;
			}

			if (left == this.size()) {
				return left;
			}
			if (this.get(left) > integer) {
				return left;
			} else {
				return right;
			}
		}

		public void printMedian() {
			int size = this.size();

			if (size == 0) {
				printWrong();
				return;
			}

			if (size % 2 == 0) {
				int n1 = this.get(size / 2 - 1);
				int n2 = this.get(size / 2);

				double median = n1 / 2.0 + n2 / 2.0;

				System.out.println(form.format(median));
			} else {
				System.out.println(form.format(this.get(size / 2)));
			}
		}

		private void printWrong() {
			System.out.println(WRONG);
		}

	}

	public static void main(String[] args) {

		FastReader bufferedReader = new FastReader();

		SortedList array = new SortedList();

		form = new DecimalFormat("#.##");
		form.setRoundingMode(RoundingMode.HALF_UP);

		int n = bufferedReader.nextInt();

		for (int i = 0; i < n; i++) {

			String str = bufferedReader.next();
			char operation = str.charAt(0);
			int input = bufferedReader.nextInt();

			if (operation == 'a') {
				array.addOperation(input);
			} else {
				array.removeOperation(input);
			}
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}

