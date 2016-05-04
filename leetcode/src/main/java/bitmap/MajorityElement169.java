package bitmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by matt on 5/3/16.
 */
public class MajorityElement169 {
	public static void main(String[] args) {
		System.out.println(majorityElement1(new int[]{3, 3, 4}));
		System.out.println(majorityElement2(new int[]{3, 3, 4}));
		System.out.println(majorityElement3(new int[]{3, 3, 4}));
	}

	/**
	 * the simplest method, but its runtime is too long and it needs extra memory
	 *
	 * @param nums
	 * @return
	 */
	public static int majorityElement1(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		Iterator it = map.keySet().iterator();
		int max = 0;
		while (it.hasNext()) {
			int cur = (int) it.next();
			if (max < map.get(cur)) {
				max = map.get(cur);
				ans = cur;
			}
		}
		return ans;
	}

	/**
	 * use the sort
	 *
	 * @param nums
	 * @return
	 */
	public static int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	/**
	 * use the property of array
	 *
	 * @param nums
	 * @return
	 */
	public static int majorityElement3(int[] nums) {
		int ans = nums[0];
		int counter = 0;
		for (int num : nums) {
			if (ans == num) {
				counter++;
			} else {
				counter--;
			}
			if (counter == 0) {
				ans = num;
				counter = 1;
			}
		}
		return ans;
	}
}
