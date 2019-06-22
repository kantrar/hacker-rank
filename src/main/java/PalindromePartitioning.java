import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {

		List<List<String>> answers = new ArrayList<>();
		answers.add(new ArrayList<>());

		for (int i = s.length() - 1; i >= 0; i--) {
			answers = updatePalindrome(s, i, answers);
		}

		return answers;
	}

	public List<List<String>> updatePalindrome(String s, int pos, List<List<String>> answers) {
		List<List<String>> newAnswers = new ArrayList<>();
		char currentChar = s.charAt(pos);

		for (int i = 0; i < answers.size(); i++) {
			String currentCharAsStr = s.substring(pos, pos + 1);
			if (answers.get(0).isEmpty()) {
				newAnswers.add(Arrays.asList(currentCharAsStr));
			} else {
				String str = answers.get(i).get(0);
				char lastChar = str.charAt(str.length() - 1);

				if (currentChar != lastChar) {
					List<String> newAnswer = new ArrayList<>();
					newAnswer.add(currentCharAsStr);
					newAnswer.addAll(answers.get(i));
					newAnswers.add(newAnswer);
				} else {
					List<String> newAnswer = new ArrayList<>();
					newAnswer.add(currentCharAsStr);
					newAnswer.addAll(answers.get(i));
					newAnswers.add(newAnswer);

					newAnswer = new ArrayList<>();
					newAnswer.add(currentChar + str);
					newAnswers.add(newAnswer);
				}
			}
		}

		return newAnswers;
	}
}
