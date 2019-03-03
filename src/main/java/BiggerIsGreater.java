import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BiggerIsGreater {
	static String biggerIsGreater(String w) {
		List<Character> charQueue = new ArrayList<>();

		char[] charArray = w.toCharArray();
		char charToChange = 'a';

		int position = -1;
		int i = charArray.length - 1;

		charQueue.add(charArray[i]);
		// O(N)
		while (i - 1 >= 0) {
			if (charArray[i - 1] >= charArray[i]) {
				charQueue.add(charArray[i - 1]);
			} else {
				charToChange = charArray[i - 1];
				charQueue.add(charToChange);
				position = i - 1;
				break;
			}
			i--;
		}

		if (position == -1) {
			return "no answer";
		}

		// O(NlogN)
		Collections.sort(charQueue);

		char changeTo = '*';
		StringBuilder builder = new StringBuilder();
		// O(N)
		for (Character c : charQueue) {
			if (changeTo == '*' && c > charToChange) {
				changeTo = c;
			} else {
				builder.append(c);
			}
		}

		return w.substring(0, position).concat(new String(new char[] {changeTo})).concat(builder.toString());
	}

}
