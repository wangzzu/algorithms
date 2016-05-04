package bitmap;

/**
 * Created by matt on 5/3/16.
 */
public class ReverseBits190 {
	public static void main(String[] args) {
		System.out.println(reverseBits1(100));
	}

	/**
	 * @param n
	 * @return
	 */
	public static int reverseBits1(int n) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			ans = (ans << 1) | (n & 1);
			n = n >> 1;
		}
		return ans;
	}
}
