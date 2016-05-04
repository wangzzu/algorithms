package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by matt on 5/4/16.
 */
public class SubsetsII90 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
	}

	/**
	 * the idea comes from 78
	 *
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsetsWithDup1(int[] nums) {
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
				if (!ans.contains(newList)) {
					ans.add(newList);
				}
			}
		}
		return ans;
	}

	/**
	 * ArrayList是基于数组实现，这里可以利用元素插入ArrayList时有序性
	 * 这也证明了如果使用list每次都做判断的话，效率比较低(contains方法是从左到右进行遍历，时间复杂度很高)
	 *
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsetsWithDup2(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		ans.add(list);
		if (nums == null || nums.length == 0) {
			return ans;
		}
		Arrays.sort(nums);
		int begin = 0;
		for (int i = 0; i < nums.length; i++) {
			int size = ans.size();
			if (i == 0 || nums[i] != nums[i - 1]) {
				begin = 0;
			}
			for (int j = begin; j < size; j++) {
				List<Integer> newList = new ArrayList<Integer>(ans.get(j));
				newList.add(nums[i]);
				ans.add(newList);
			}
			begin = size;
		}
		return ans;
	}
}
