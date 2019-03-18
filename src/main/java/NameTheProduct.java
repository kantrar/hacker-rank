import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NameTheProduct {
	private static class CharacterWithCount {
		char character;
		int count;

		public CharacterWithCount(char c) {
			this.character = c;
		}

		public int getCount() {
			return count;
		}

		public int getCharacterDesc() {
			return -character;
		}
	}

	public static String productName(List<String> names) {
		List<List<CharacterWithCount>> answers = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			List<CharacterWithCount> list = new ArrayList<>();
			for (char c = 'a'; c <= 'z'; c++) {
				list.add(new CharacterWithCount(c));
			}
			answers.add(list);
		}

		for (String name : names) {
			updateAnswer(answers, name, 0);
			updateAnswer(answers, name, 1);
			updateAnswer(answers, name, 2);
			updateAnswer(answers, name, 3);
			updateAnswer(answers, name, 4);
		}

		String answer = "";

		for (List<CharacterWithCount> characterWithCounts : answers) {
			Collections.sort(characterWithCounts,
					Comparator.comparingInt(CharacterWithCount::getCount).thenComparingInt(CharacterWithCount::getCharacterDesc));
			answer += characterWithCounts.get(0).character;
		}

		return answer;
	}

	private static void updateAnswer(List<List<CharacterWithCount>> answers, String name, int pos) {
		CharacterWithCount cWithCount = answers.get(pos).get(name.charAt(pos) - 'a');
		cWithCount.count++;
	}
}
