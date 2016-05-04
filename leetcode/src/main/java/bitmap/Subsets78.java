package bitmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by matt on 5/4/16.
 */
public class Subsets78 {
	public static void main(String[] args) {

	}

	/**
	 * 先对这个数组进行排序，然后取出ans中的所有list，然后为所有的list添加一个元素，并且保留之前的所有list，
	 * [参考](http://www.cnblogs.com/Dylan-Java-NYC/p/4841881.html)
	 *
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		ans.add(list);
		if (nums == null || nums.length == 0) {
			return ans;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int size = ans.size();
			for (int j = 0; j < size; j++) {
				List<Integer> newList = new ArrayList<Integer>(ans.get(j));
				newList.add(nums[i]);
				ans.add(newList);
			}
		}
		return ans;
	}
}
