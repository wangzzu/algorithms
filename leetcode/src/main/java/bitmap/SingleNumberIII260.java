package bitmap;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by matt on 5/3/16.
 */
public class SingleNumberIII260 {
	public static void main(String[] args) {
		int[] nums = {-1, 0};
		int[] ans = singleNumber1(nums);
		System.out.println(ans[0] + " " + ans[1]);
		System.out.println(12 & (-12));

		ans = singleNumber2(nums);
		System.out.println(ans[0] + " " + ans[1]);
	}

	/**
	 * this method is simple, but it needs extra memory, and this method does not use the advantage of bitmap
	 *
	 * @param nums
	 * @return
	 */
	public static int[] singleNumber1(int[] nums) {
		int[] ans = new int[2];
		if (nums == null || nums.length == 0) {
			return ans;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			if (!set.remove(num)) {
				set.add(num);
			}
		}
		if (set.size() == 2) {
			int i = 0;
			Iterator it = set.iterator();
			while (it.hasNext()) {
				ans[i] = (int) it.next();
				i++;
			}
		}
		return ans;
	}

	/**
	 * the runtime of this method is fewest, and it uses the advantage of bit operation
	 *
	 * @param nums
	 * @return
	 */
	public static int[] singleNumber2(int[] nums) {
		int[] ans = {0, 0};
		if (nums == null || nums.length == 0) {
			return ans;
		}
		int axorb = 0;
		for (int num : nums) {
			axorb ^= num;
		}
		int mark = axorb & (-axorb);
		for (int num : nums) {
			if ((num & mark) == 0) {
				ans[0] ^= num;
			} else {
				ans[1] ^= num;
			}
		}
		return ans;
	}
}
