public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		// 1st Approach
		// Find positions of each element O(N)
		// Iterate over 26 letters and find the right position for each element using binary search O(logN)

		// O(N)
		// Remember the position of each character
		// When the character does appear twice, check if the smallest character before it has appear or not (We can use this
		// approach since there are only 26 possible characters)

		// Both approaches don't work in some cases

		return "";
	}

	public int key(String s, int pos) {
		return s.charAt(pos) - 'a';
	}
}
