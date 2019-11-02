import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OrdinalNumberOfDate {

	private static Set<Integer> set31days = new HashSet<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
	private static Set<Integer> set30days = new HashSet<>(Arrays.asList(4, 6, 9, 11));

	public int dayOfYear(String date) {
		String[] dateStr = date.split("-");
		int year, month, day;
		try {
			year = Integer.parseInt(dateStr[0]);
			month = Integer.parseInt(dateStr[1]);
			day = Integer.parseInt(dateStr[2]);
		} catch (Exception e) {
			return -1;
		}

		boolean leapYear = false;
		if (year % 4 == 0) {
			leapYear = true;
			if (year % 100 == 0) {
				leapYear = false;
				if (year % 400 == 0) {
					leapYear = true;
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < month - 1; i++) {
			if (set31days.contains(i + 1)) {
				ans += 31;
			} else if (set30days.contains(i + 1)) {
				ans += 30;
			} else {
				ans += leapYear ? 29 : 28;
			}
		}
		ans += day;
		return ans;
	}
}
