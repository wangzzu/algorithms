package notags;

/**
 * Created by matt on 5/3/16.
 */
public class ReverseInteger7 {
	public static void main(String[] args) {
		System.out.println(reverse(-998));
	}

	/**
	 * you should take care of the boundary condition, it's similar to the 190.
	 *
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		long ans = 0;
		int flag = 0;
		if (x < 0) {
			flag = 1;
			x = -x;
		}
		while (x != 0) {
			ans = ans * 10 + (x % 10);
			x = x / 10;
		}
		if (flag == 1) {
			ans = -ans;
		}
		if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
			ans = 0;
		}
		return (int) ans;
	}
}
