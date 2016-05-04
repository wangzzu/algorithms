package bitmap;

import java.util.Arrays;

/**
 * Created by matt on 5/4/16.
 */
public class MissingNumber268 {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		System.out.println(missingNumber2(nums));
	}

	/**
	 * use the bit operation xor
	 *
	 * @param nums
	 * @return
	 */
	public int missingNumber1(int[] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			ans ^= i ^ nums[i];
		}
		return ans ^ nums.length;
	}

	/**
	 * 这个是使用二分查找，由于输入数组不是有序，所以这种方法的性能步入第一种方法
	 *
	 * @param nums
	 * @return
	 */
	public static int missingNumber2(int[] nums) {
		int ans = nums.length;
		Arrays.sort(nums);
		if (nums[ans - 1] == ans - 1) {
			return ans;
		} else if (nums[0] != 0) {
			return 0;
		} else {
			return missingNumber(nums, 0, ans - 1);
		}
	}

	public static int missingNumber(int[] nums, int start, int end) {
		int ans = 0;
		int mid = (start + end) / 2;
		if (nums[mid] == mid) {
			ans = missingNumber(nums, mid + 1, end);
		} else {
			if (nums[mid - 1] == mid - 1) {
				return mid;
			} else {
				ans = missingNumber(nums, start, mid);
			}
		}
		return ans;
	}
}
