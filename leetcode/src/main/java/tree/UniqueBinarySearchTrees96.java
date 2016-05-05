package tree;

/**
 * Created by matt on 5/5/16.
 */
public class UniqueBinarySearchTrees96 {
	/**
	 * 使用卡特兰数
	 * 动态规划+树
	 *
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int[] ans = new int[n + 1];
		ans[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				ans[i] += ans[j] * ans[i - 1 - j];
			}
		}
		return ans[n];
	}
}
