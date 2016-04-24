package bitmap;

/**
 * Created by matt on 4/24/16.
 */
public class PowerofTwo231 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(isPowerOfTwo(16));
	}

	/**
	 * 原理：2的次方的二进制最高位是1，其它位都是0
	 *
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwo(int n) {
		return n > 0 && ((n & (n - 1)) == 0);
	}
}
