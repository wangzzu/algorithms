package dynamicprogramming;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Map;

/**
 * Created by matt on 4/25/16.
 */
public class MaximumProductSubarray152 {
	public static void main(String[] args) {
		int[] a = {1, -2, 6, 9, 0, 1, 8, -3, 4, 5};
		int[] b = null;
		System.out.println("第一种方法：");
		System.out.println(maxProduct1(a));
		System.out.println(maxProduct1(b));

		System.out.println("第二种方法：");
		System.out.println(maxProduct2(a));
		System.out.println(maxProduct2(b));

		System.out.println("第三种方法：");
		System.out.println(maxProduct3(a));
		System.out.println(maxProduct3(b));
	}

	/**
	 * 最简单的思路，但是需要三层循环，时间复杂度为O(n^3)
	 *
	 * @param nums
	 * @return
	 */
	public static int maxProduct1(int[] nums) {
		int max = 0;
		if (nums == null || nums.length == 0) {
			return max;
		}
		for (int i = 0; i <= nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				int cur = 1;
				for (int k = i; k <= j; k++) {
					cur *= nums[k];
				}
				if (cur > max) {
					max = cur;
				}
			}
		}
		return max;
	}

	/**
	 * 第一次优化：减少中间变量的计算，时间复杂度为：O(n^2)；
	 *
	 * @param nums
	 * @return
	 */
	public static int maxProduct2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[][] productArray = new int[nums.length][nums.length];
		int maxProduct = nums[0];

		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (j == i) {
					productArray[i][i] = nums[i];
				} else {
					productArray[i][j] = productArray[i][j - 1] * nums[j];
				}
				if (productArray[i][j] > maxProduct) {
					maxProduct = productArray[i][j];
				}
			}
		}
		return maxProduct;
	}

	/**
	 * 根据规律再次进行改进（其实子数组乘积最大值的可能性为：累乘的最大值碰到了一个正数；或者，累乘的最小值（负数），碰到了一个负数）
	 *
	 * @param nums
	 * @return
	 */
	public static int maxProduct3(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int maxProduct = nums[0];
		int max_tmp = nums[0];
		int min_tmp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int a = max_tmp * nums[i];
			int b = min_tmp * nums[i];
			max_tmp = Math.max(Math.max(a, b), nums[i]);
			min_tmp = Math.min(Math.min(a, b), nums[i]);
			maxProduct = Math.max(maxProduct, max_tmp);
		}
		return maxProduct;
	}
}
