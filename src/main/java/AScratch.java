import java.util.HashMap;
import java.util.Map;

public class AScratch {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);

		int value = 5;
		map.replaceAll((a, b) -> b + value);

		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.get(3));
	}
}
