import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
	Set<String> set;
	public int numTilePossibilities(String tiles) {
		set = new HashSet<>();
		char[] array = tiles.toCharArray();
		Arrays.sort(array);
		int visited = 0;
		return get(array, 0, visited) - 1;
	}

	public int get(char[] chars, int pos, int visited) {
		int ans = 1;
		for (int i = pos; i < chars.length; i++) {
			if ((visited & (1 << i)) == 0) {
				visited |= (1 << i);
				ans += get(chars, pos, visited);
				visited ^= (1 << i);
			}
		}

		return ans;
	}
}
