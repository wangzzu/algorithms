package twenty_20;

import java.util.HashMap;

public class two_sum_001 {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 4 };
		int target = 6;
		int[] ans = twoSum(nums, target);
		for (int i = 0; i < ans.length; i++)
			System.out.println(ans[i]);

	}

	public static int[] twoSum(int[] nums, int target) {
		int[] ans = new int[2];
		int length = nums.length;
		if (length != 0) {
			HashMap<Integer, Integer> numsmap = new HashMap<Integer, Integer>(length);
			for (int i = 0; i < length; i++)
				numsmap.put(nums[i], i);
			for (int i = 0; i < length; i++) {
				int found = target - nums[i];
				if (numsmap.containsKey(found) && numsmap.get(found) != i) {
					ans[0] = i;
					ans[1] = numsmap.get(found);
					return ans;
				}

			}
		}
		return null;
	}
}
