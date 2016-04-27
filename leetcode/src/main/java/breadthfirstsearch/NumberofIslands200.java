package breadthfirstsearch;

/**
 * Created by matt on 4/27/16.
 */
public class NumberofIslands200 {

	public static void main(String[] args) {
		char[][] chars = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
		System.out.println(numIslands(chars));
	}

	public static int numIslands(char[][] grid) {
		int m = grid.length;
		if(m==0){
			return 0;
		}
		int n = grid[0].length;
		if (n == 0) {
			return 0;
		}
		int ans = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] != '1') {
					continue;
				} else {
					ans++;
					dfs(grid, i, j, m, n);
				}
			}
		}
		return ans;
	}

	public static void dfs(char[][] grid, int i, int j, int m, int n) {
		if (i < 0 || i >= m || j < 0 || j >= n) {
			return;
		}
		if (grid[i][j] == '1') {
			grid[i][j]='0';
			dfs(grid, i - 1, j, m, n);
			dfs(grid, i + 1, j, m, n);
			dfs(grid, i, j - 1, m, n);
			dfs(grid, i, j + 1, m, n);
		}
	}
}
