package bitmap;

import java.util.HashSet;
import java.util.Map;

/**
 * Created by matt on 5/3/16.
 */
public class SingleNumberI136 {
	public static void main(String[] args) {
		int[] nums=new int[0];
		System.out.println(singleNumber2(nums));
		int i=-2147483648;
		System.out.println(Math.abs(i));
	}

	/**
	 * the faster way（using xor）
	 * @param nums
	 * @return
	 */
	public static int singleNumber1(int[] nums) {
		if(nums==null||nums.length==0){
			return 0;
		}
		int res=0;
		for(int i=0;i<nums.length;i++){
			res=res^nums[i];
		}
		return res;
	}

	/**
	 * this method will use extra memory
	 * @param nums
	 * @return
	 */
	public static int singleNumber2(int[] nums) {
		if(nums==null||nums.length==0){
			return 0;
		}
		HashSet<Integer> check=new HashSet<>();
		for(int num:nums){
			if(!check.remove(num)){
				check.add(num);
			}
		}
		return check.iterator().next();
	}
}
