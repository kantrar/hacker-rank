import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
	// Solution
	//	public List<Integer> findSubstring(String s, String[] words) {
	//		int N = s.length();
	//		List<Integer> indexes = new ArrayList<Integer>(s.length());
	//		if (words.length == 0) {
	//			return indexes;
	//		}
	//		int M = words[0].length();
	//		if (N < M * words.length) {
	//			return indexes;
	//		}
	//		int last = N - M + 1;
	//
	//		//map each string in words array to some index and compute target counters
	//		Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
	//		int[][] table = new int[2][words.length];
	//		int failures = 0, index = 0;
	//		for (int i = 0; i < words.length; ++i) {
	//			Integer mapped = mapping.get(words[i]);
	//			if (mapped == null) {
	//				++failures;
	//				mapping.put(words[i], index);
	//				mapped = index++;
	//			}
	//			++table[0][mapped];
	//		}
	//
	//		//find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
	//		int[] smapping = new int[last];
	//		for (int i = 0; i < last; ++i) {
	//			String section = s.substring(i, i + M);
	//			Integer mapped = mapping.get(section);
	//			if (mapped == null) {
	//				smapping[i] = -1;
	//			} else {
	//				smapping[i] = mapped;
	//			}
	//		}
	//
	//		//fix the number of linear scans
	//		for (int i = 0; i < M; ++i) {
	//			//reset scan variables
	//			int currentFailures = failures; //number of current mismatches
	//			int left = i, right = i;
	//			Arrays.fill(table[1], 0);
	//			//here, simple solve the minimum-window-substring problem
	//			while (right < last) {
	//				while (currentFailures > 0 && right < last) {
	//					int target = smapping[right];
	//					if (target != -1 && ++table[1][target] == table[0][target]) {
	//						--currentFailures;
	//					}
	//					right += M;
	//				}
	//				while (currentFailures == 0 && left < right) {
	//					int target = smapping[left];
	//					if (target != -1 && --table[1][target] == table[0][target] - 1) {
	//						int length = right - left;
	//						//instead of checking every window, we know exactly the length we want
	//						if ((length / M) == words.length) {
	//							indexes.add(left);
	//						}
	//						++currentFailures;
	//					}
	//					left += M;
	//				}
	//			}
	//
	//		}
	//		return indexes;
	//	}

	// incorrect as not able to handle some cases
	//	public List<Integer> findSubstring(String s, String[] words) {
	//		if (words.length == 0 || s.length() == 0) {
	//			return new ArrayList<>();
	//		}
	//		Map<String, List<Integer>> positions = new HashMap<>();
	//		for (int i = 0; i < words.length; i++) {
	//			String w = words[i];
	//			if (!positions.containsKey(w)) {
	//				positions.put(w, new ArrayList<>());
	//			}
	//			positions.get(w).add(i);
	//		}
	//
	//		int LEN = words[0].length();
	//		int total = LEN * words.length;
	//
	//		Map<Integer, List<Integer>> sPositions = new TreeMap<>();
	//		Map<Integer, String> map = new HashMap<>();
	//		List<Character> queue = new LinkedList<>();
	//		for (int i = 0; i < s.length(); i++) {
	//			queue.add(s.charAt(i));
	//			if (queue.size() == LEN) {
	//				String w = queue.stream().map(String::valueOf).collect(Collectors.joining());
	//				map.put(i, w);
	//				if (positions.containsKey(w)) {
	//					sPositions.put(i, positions.get(w));
	//				}
	//				queue.remove(0);
	//			}
	//		}
	//
	//		if (sPositions.isEmpty()) {
	//			return new ArrayList<>();
	//		}
	//
	//		List<Integer> res = new ArrayList<>();
	//
	//		List<Integer> list = new ArrayList<>(sPositions.keySet());
	//		int left = 0;
	//		Map<String, Integer> seen = new HashMap<>();
	//		int formed = 0;
	//		int right = 0;
	//		while (right < list.size()) {
	//			int currentPos = list.get(right);
	//			int prevPos = formed != 0 ? list.get(right - 1) : currentPos - LEN;
	//			String currentWord = map.get(currentPos);
	//			if (currentPos - prevPos == LEN) {
	//				if (seen.getOrDefault(currentWord, 0) < positions.get(currentWord).size()) {
	//					seen.put(currentWord, seen.getOrDefault(currentWord, 0) + 1);
	//					if (seen.get(currentWord) == positions.get(currentWord).size()) {
	//						formed++;
	//					}
	//				} else {
	//					while (seen.getOrDefault(currentWord, 0) >= positions.get(currentWord).size()) {
	//						String leftString = map.get(list.get(left));
	//						if (!leftString.equals(currentWord)) {
	//							seen.put(leftString, seen.getOrDefault(leftString, 0) - 1);
	//							formed--;
	//						} else {
	//							left++;
	//							break;
	//						}
	//						left++;
	//					}
	//
	//				}
	//			} else {
	//				formed = 0;
	//				seen = new HashMap<>();
	//				continue;
	//			}
	//
	//			if (formed == positions.size()) {
	//				if (currentPos - total + 1 >= 0) {
	//					res.add(currentPos - total + 1);
	//				}
	//				String leftString = map.get(list.get(left));
	//				seen.put(leftString, seen.getOrDefault(leftString, 0) - 1);
	//				formed--;
	//				left++;
	//			}
	//
	//			right++;
	//		}
	//
	//		return res;
	//	}

	public List<Integer> findSubstring(String s, String[] words) {
		if (words.length == 0 || s.length() == 0) {
			return new ArrayList<>();
		}
		Map<String, Integer> countWord = new HashMap<>();
		for (String word : words) {
			countWord.put(word, countWord.getOrDefault(word, 0) + 1);
		}

		int LEN = words[0].length();

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < LEN; i++) {
			int left = i;
			int right = i;
			Map<String, Integer> seen = new HashMap<>();
			int formed = 0;
			while (right + LEN <= s.length()) {
				while (right + LEN <= s.length() && formed != countWord.size()) {
					String temp = s.substring(right, right + LEN);
					seen.put(temp, seen.getOrDefault(temp, 0) + 1);
					if (seen.get(temp) == countWord.get(temp)) {
						formed++;
					}
					right += LEN;
				}

				while (left < right && formed == countWord.size()) {
					String temp = s.substring(left, left + LEN);
					if ((right - left) / LEN == words.length) {
						res.add(left);
					}
					if (seen.get(temp) == countWord.get(temp)) {
						formed--;
					}
					seen.put(temp, seen.getOrDefault(temp, 0) - 1);
					left += LEN;
				}
			}

		}
		return res;
	}
}
