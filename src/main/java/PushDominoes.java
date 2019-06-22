public class PushDominoes {
	public String pushDominoes(String dominoes) {
		if (dominoes.length() <= 1) {
			return dominoes;
		}
		int[] pos = new int[dominoes.length()];
		int currentPos = dominoes.length();

		for (int i = dominoes.length() - 1; i >= 0; i--) {
			if (dominoes.charAt(i) == '.') {
				pos[i] = currentPos;
			} else {
				pos[i] = currentPos;
				currentPos = i;
			}
		}
		String answer = "";
		int i = 0;
		char last = dominoes.charAt(0);
		while (pos[i] < dominoes.length()) {
			char currentChar = dominoes.charAt(i);
			char nextChar = dominoes.charAt(pos[i]);

			char c = '.';
			if (nextChar == 'R') {
				c = currentChar;
			} else if (nextChar == 'L') {
				c = 'L';
			}

			if (currentChar == '.') {
				currentChar = c;
			}

			answer += currentChar;
			int back = pos[i] - 1;
			int next = i + 1;
			while (next < back) {
				answer += currentChar == 'L' ? '.' : currentChar;
				next++;
				back--;
			}
			if (next == back) {
				answer += ".";
			}
			back = pos[i] - 1;
			next = i + 1;
			while (next < back) {
				answer += nextChar == 'R' ? '.' : currentChar;
				next++;
				back--;
			}

			last = nextChar;
			i = pos[i];
		}

		answer += last;
		while (answer.length() < dominoes.length()) {
			answer += last == 'R' ? 'R' : '.';
		}
		return answer;
	}
}
