import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ShortestSuperString {
	public class StringPair {
		String first;
		String second;
		int overlapping;

		public StringPair(String f, String s, int o) {
			this.first = f;
			this.second = s;
			this.overlapping = o;
		}

		public StringPair(String f, int o) {
			this.first = f;
			this.overlapping = o;
		}
	}

	public class PairComparator implements Comparator<StringPair> {
		@Override
		public int compare(StringPair a, StringPair b) {
			if (a.overlapping != b.overlapping) {
				return b.overlapping - a.overlapping;
			}
			return a.first.compareTo(b.first) == 0 ? a.second.compareTo(b.second) : a.first.compareTo(b.first);
		}
	}

	// Incorrect in this case, ["catg","ctaagt","gcta","ttca","atgcatc"]
	// ttcatgcatcgctaagt
	// gctaagttcatgcatc

	public String shortestSuperstring(String[] A) {

		String answer = "";
		List<StringPair> answers = new LinkedList<>();
		Set<String> used = new HashSet<>();
		Set<String> parents = new HashSet<>();

		Set<StringPair> set = new TreeSet<>(new PairComparator());

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (i == j) {
					continue;
				}

				int len = Math.min(A[i].length(), A[j].length());
				int overlapping = 0;
				for (int k = 1; k <= len && j + k <= A[j].length(); k++) {
					if (A[i].endsWith(A[j].substring(0, k))) {
						overlapping = k;
						break;
					}
				}

				set.add(new StringPair(A[i], A[j], overlapping));
			}
		}

		List<StringPair> list = set.stream().collect(Collectors.toList());

		for (StringPair sp : list) {
			if (used.contains(sp.second) || parents.contains(sp.first) || (used.contains(sp.first) && parents
					.contains(sp.second))) {
				continue;
			}

			if (parents.contains(sp.second)) {
				int pos = findBefore(answers, sp.second);
				answers.add(pos, new StringPair(sp.first, sp.overlapping));
			} else if (used.contains(sp.first)) {
				int pos = findAfter(answers, sp.first);
				answers.set(pos, new StringPair(sp.first, sp.overlapping));
				answers.add(new StringPair(sp.second, 0));
			} else {
				answers.add(new StringPair(sp.first, sp.overlapping));
				answers.add(new StringPair(sp.second, 0));
			}
			parents.add(sp.first);
			used.add(sp.second);
		}

		int overlapping = 0;
		for (int i = 0; i < answers.size(); i++) {
			answer += answers.get(i).first.substring(overlapping);
			overlapping = answers.get(i).overlapping;
		}

		return answer;
	}

	public int findBefore(List<StringPair> list, String target) {
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).first.equals(target)) {
				return i - 1;
			}
		}

		return 0;
	}

	public int findAfter(List<StringPair> list, String target) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).first.equals(target)) {
				return i + 1;
			}
		}

		return list.size() - 1;
	}

	public static void main(String[] args) {
		ShortestSuperString shortestSuperString = new ShortestSuperString();
		String result = shortestSuperString.shortestSuperstring(new String[] {"catg","ctaagt","gcta","ttca","atgcatc"});
		System.out.println(result);
	}
}
