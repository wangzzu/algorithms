package bitmap;

/**
 * Created by matt on 5/3/16.
 */
public class SingleNumberII137 {
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 23, 23, 23, 4, 5, 4, 5, 3, 4, 5};
		System.out.println(singleNumber1(nums));
		System.out.println(singleNumber2(nums));
	}

	/**
	 * the first method I can think of
	 *
	 * @param nums
	 * @return
	 */
	public static int singleNumber1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int res = 0;
		int[] bit = new int[32];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < 32; j++) {
				if (((nums[i] >> j) & 1) == 1) {
					bit[j]++;
				}
			}
		}
		for (int i = 0; i < 32; i++) {
			res |= ((bit[i] % 3) << i);
		}
		return res;
	}

	/**
	 * make some implement base on the first method
	 *
	 * @param nums
	 * @return
	 */
	public static int singleNumber2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int res = 0;
		int[] bit = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (((nums[j] >> i) & 1) == 1) {
					bit[i]++;
				}
			}
			res |= ((bit[i] % 3) << i);
		}
		return res;
	}

	/**
	 * the fastest method, but it's difficult to understand
	 * @param nums
	 * @return
	 */
	public static int singleNumber3(int[] nums) {
		int ones = 0, twos = 0, threes = 0;

		for (int i = 0; i < nums.length; i++) {
			// twos holds the num that appears twice
			twos |= ones & nums[i];

			// ones holds the num that appears once
			ones ^= nums[i];

			// threes holds the num that appears three times
			threes = ones & twos;

			// if num[i] appears three times
			// doing this will clear ones and twos
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}
}
