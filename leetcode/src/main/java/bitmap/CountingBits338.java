package bitmap;

/**
 * Created by matt on 5/4/16.
 */
public class CountingBits338 {
	public static int[] countBits(int num) {
		int[] ans=new int[num+1];
		ans[0]=0;
		for(int i=0;i<num+1;i++){
			ans[i]=ans[i>>1]+i%2;
		}
		return ans;
	}
}
