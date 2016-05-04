package bitmap;

/**
 * Created by matt on 5/3/16.
 */
public class Numberof1Bits191 {
	public static void main(String[] args) {
		System.out.println(hammingWeight1(2147483641));
	}

	public static int hammingWeight1(int n) {
		int ans=0;
		if (n<Integer.MIN_VALUE||n>Integer.MAX_VALUE){
			return ans;
		}
		int bit=1;
		while(n!=0){
			if((n&bit)==1){
				ans++;
			}
			n=n>>1;
		}
		return ans;
	}
}
