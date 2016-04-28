package other;

/**
 * Created by matt on 4/27/16.
 */
public class CDs {

	public static void main(String[] args) {
		System.out.println(maxTowPower(7, 2, 6));
	}

	public static int maxTowPower(int n, int s, int l) {
		int ans = 0;
		if (n <= 0 || s <= 0 || l <= 0) {
			return ans;
		}
		int cds = (l + 1) / (s + 1);
		if (cds % 13 == 0) {
			cds -= 1;
		}
		if (n % cds == 0) {
			ans = n / cds;
		} else {
			ans = n / cds + 1;
			if (cds % 13 == 1 && ((n - (n / cds) * cds) == cds - 1)) {
				ans += 1;
			}

		}
		return ans;
	}
}
