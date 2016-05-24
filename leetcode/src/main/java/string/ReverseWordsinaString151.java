package string;

/**
 * 此题还需要考虑如果是连续两个空格，甚至是三个空格，该如何处理
 * <p/>
 * Created by matt on 5/18/16.
 */
public class ReverseWordsinaString151 {
	public static void main(String[] args) {
		System.out.println(reverseWords(" 1 "));
	}

	/**
	 * runtime: 56s
	 * 这个是自己实现的方法，运行时间果然太长
	 *
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		if (s == null) {
			return null;
		}
		String[] strs = s.split(" ");
		int len = strs.length;
		System.out.println(len + strs[0] + strs[1]);
		if (len == 0) {
			System.out.println(len);
			return s;
		}
		for (int i = 0; i < len / 2; i++) {
			swap(strs, i, len - 1 - i);
		}

		StringBuilder ans = new StringBuilder(strs[0]);
		for (int i = 1; i < len; i++) {
			ans.append(" " + strs[i]);
		}
		return new String(ans);
	}

	public static void swap(String[] str, int i, int j) {
		String tmp = str[i];
		str[i] = str[j];
		str[j] = tmp;
	}

	/**
	 * runtime: 12s
	 * 这里对上面的方法做了两个改进，一个是使用s.trim()出去两边的空格，另一个不用反转字符串了直接从后面开始往前面输出
	 *
	 * @param s
	 * @return
	 */
	public String reverseWords2(String s) {
		String[] parts = s.trim().split("\\s+");
		StringBuilder ans = new StringBuilder();
		for (int i = parts.length - 1; i > 0; i--) {
			ans.append(parts[i]);
			ans.append(" ");
		}
		return new String(ans.append(parts[0]));
	}

	/**
	 * runtime: 5s
	 * StringBuffer提供了toString()的方法，但是这个不是性能差的原因，推断是因为上面使用了parts[i] + " "，而不是分别进行append
	 *
	 * @param s
	 * @return
	 */
	public String reverseWords3(String s) {
		String[] t = s.trim().split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = t.length - 1; i >= 0; i--) {
			if (t[i].isEmpty()) continue; // 排除多个空格的情况
			else {
				sb.append(t[i]);
				if (i > 0) sb.append(" ");
			}
		}
		return sb.toString();
	}
}
