package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * use greedy algorithm
 * Created by matt on 4/21/16.
 */
public class LargestNumber {

	public static void main(String[] args) {
		int[] a = {5, 69, 1, 25, 2, 3, 7, 41, 0, 32};
		System.out.println(largestNumber(a));
		System.out.println((new Integer(2)).compareTo(new Integer(3)));
	}

	public static String largestNumber(int[] nums) {
		Integer[] ints = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			ints[i] = nums[i];
		}
		Arrays.sort(ints, new Comparator<Integer>() {
			public int compare(Integer n1, Integer n2) {
				String str1 = String.valueOf(n1);
				String str2 = String.valueOf(n2);
				return (str2 + str1).compareTo(str1 + str2);
			}
		});
		if (ints[0] == 0) {
			return "0";
		}
		StringBuilder large = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			large.append(ints[i]);
		}
		return large.toString();
	}
}
