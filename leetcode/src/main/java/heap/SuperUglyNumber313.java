package heap;

/**
 * Created by matt on 5/17/16.
 */
public class SuperUglyNumber313 {
	public static void main(String[] args) {
		int[] nums = {2, 7,13,19};
		System.out.println("\n"+nthSuperUglyNumber(10, nums));
	}

	public static int nthSuperUglyNumber(int n, int[] primes) {
		if (n <= 0 || primes == null || primes.length == 0) {
			return 0;
		}
		int[] nums = new int[n];
		int size = primes.length;
		int[] ps = new int[size];
		nums[0] = 1;
		for (int p : ps) {
			p = 0;
		}
		int i = 1;
		while (i < n) {
			int flag = 0;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < size; j++) {
				int tmp = nums[ps[j]] * primes[j];
				while (tmp<=nums[i-1]){
					ps[j]++;
					tmp = nums[ps[j]] * primes[j];
				}
				if (tmp < min) {
					min = tmp;
					flag = j;
				}
			}
			System.out.println(min);
			nums[i]=min;
			ps[flag]++;
			i++;
		}
		return nums[n - 1];
	}
}
