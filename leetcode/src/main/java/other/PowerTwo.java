package other;

/**
 * 给你一个n，找大于等于n的2的次方，比如给你7 则为8，给8则输出8，给9输出16
 * Created by matt on 4/25/16.
 */
public class PowerTwo {

	public static void main(String[] args){
		System.out.println(maxTowPower(15));
	}

	public static int maxTowPower(int n){
		if((n&(n-1))==0){
			return n;
		}
		int i=0;
		while(n!=0){
			n=n>>1;
			i++;
		}
		System.out.println(i);
		n=1;
		while (i!=0){
			n=n<<1;
			i--;
		}
		return n;
	}
}
