package sort;

/**
 * Created by matt on 5/16/16.
 */
public class SortColors75 {
	public void sortColors(int[] nums) {
		int a0=0;
		int a1=0;
		int a2=0;
		int total=nums.length;
		for(int i=0;i<total;i++){
			if(nums[i]==0){
				a0++;
			}else if(nums[i]==1){
				a1++;
			}else{
				a2++;
			}
		}
		for(int i=0;i<total;i++){
			if(i<a0){
				nums[i]=0;
			}else if(i<a0+a1){
				nums[i]=1;
			}else{
				nums[i]=2;
			}
		}
	}
}
