public class AScratch {
	public static void main(String[] args) {
		String s = "ab";
		String t = s;

		StringBuilder builder = new StringBuilder(s);
		builder.setCharAt(1, 'c');
		System.out.println(builder.toString());

	}
}
