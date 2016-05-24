package string;

/**
 * Created by matt on 5/19/16.
 */
public class LongestPalindromicSubstring5 {
	public static void main(String[] args) {
		String str = "abvasgfabbasdfa";
		System.out.println(longestPalindrome2(str));
	}

	/**
	 * using the Dynamic Programming, the key is finding the law
	 * 108s
	 *
	 * @param s
	 * @return
	 */
	public String longestPalindrome1(String s) {
		int len = s.length();
		if (s == null || len == 0) {
			return s;
		}
		int maxlen = 0;
		String ans = null;
		boolean[][] dp = new boolean[len][len];
		for (int k = 0; k < len; k++) { // k means the interval
			for (int i = 0; i < len - k; i++) {
				int j = i + k;
				if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
					if (j - i >= maxlen) {
						maxlen = j - i + 1;
						ans = s.substring(i, j + 1);
					}
				}
			}
		}
		return ans;
	}

	/**
	 * find the center of the Palindromic String
	 * 36s
	 *
	 * @param s
	 * @return
	 */
	public static String longestPalindrome2(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		int len = s.length();
		String ans = s.substring(0, 1);
		for (int i = 0; i < len; i++) {
			String tmp = help(s, i, i);
			if (tmp.length() > ans.length()) {
				System.out.println("1: " + ans);
				ans = tmp;
			}
			tmp = help(s, i, i + 1);
			if (tmp.length() > ans.length()) {
				System.out.println("2: " + ans);
				ans = tmp;
			}
		}
		return ans;
	}

	public static String help(String s, int start, int end) {
		while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		return s.substring(start + 1, end);
	}
}
