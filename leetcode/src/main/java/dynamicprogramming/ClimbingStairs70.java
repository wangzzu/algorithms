package dynamicprogramming;

/**
 * Created by matt on 4/25/16.
 */
public class ClimbingStairs70 {
	public static void main(String[] args) {
		System.out.println(climbStairs1(10));
		System.out.println(climbStairs2(10));
	}

	/**
	 * 递归，但是会有很多重复计算
	 *
	 * @param n
	 * @return
	 */
	public static int climbStairs1(int n) {
		if (n < 1) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			return climbStairs1(n - 1) + climbStairs1(n - 2);
		}
	}

	/**
	 * 减少重复计算
	 * @param n
	 * @return
	 */
	public static int climbStairs2(int n) {
		int ans=0;
		int ans1=1;
		int ans2=2;
		if (n < 1) {
			return 0;
		} else if (n == 1) {
			ans=ans1;
		} else if (n == 2) {
			ans=ans2;
		}else {
			for (int i = 3; i <= n; i++) {
				ans = ans1 + ans2;
				ans1 = ans2;
				ans2 = ans;
			}
		}
		return ans;
	}
}
