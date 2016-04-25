
package dynamicprogramming;

/**
 * Created by matt on 4/25/16.
 */
public class MaximumSubarray53 {
	public static void main(String[] args) {
		int[] a = {1, 2, -3, 5, 0, 7, -2, -3, 4, 5, -1};
		System.out.println(maxSubArray1(a));
	}

	/**
	 * 使用一个额外的数组，时间为O(n)
	 *
	 * @param nums
	 * @return
	 */
	public static int maxSubArray1(int[] nums) {
		int[] sum = new int[nums.length];
		int max = nums[0];
		sum[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
			max = Math.max(max, sum[i]);
		}
		return max;
	}

	/**
	 * 减少了空间占用率
	 * @param nums
	 * @return
	 */
	public static int maxSubArray2(int[] nums){
		int nowMax=nums[0];
		int max=nums[0];
		for(int i=1;i<nums.length;i++){
			nowMax=Math.max(nums[i],nums[i]+nowMax);
			max=Math.max(max,nowMax);
		}
		return max;
	}
}
