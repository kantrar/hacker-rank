public class RemoveAllAdjacentDuplicatesInStringII {
	public String removeDuplicates(String s, int k) {
		boolean canDelete = true;
		String cur = s;
		while (canDelete) {
			canDelete = false;
			int count = 1;
			int i = 1;
			int idx = 0;
			StringBuilder sb = new StringBuilder();
			addSafely(sb, idx++, cur.charAt(0));
			while (i < cur.length()) {
				if (cur.charAt(i) == cur.charAt(i - 1)) {
					addSafely(sb, idx++, cur.charAt(i));
					count++;
					if (count == k) {
						canDelete = true;
						idx -= count;
						count = 0;
					}
				} else {
					addSafely(sb, idx++, cur.charAt(i));
					count = 1;
				}

				i++;
			}
			cur = sb.substring(0, idx);
		}
		return cur;
	}

	private void addSafely(StringBuilder sb, int idx, char c) {
		if (idx >= sb.length()) {
			sb.append(c);
		} else {
			sb.setCharAt(idx, c);
		}
	}
}
