package string;

/**
 * Created by matt on 5/19/16.
 */
public class CountandSay38 {
	public String countAndSay(int n) {
		String ret = "" + 1;
		while (--n > 0)
			ret = apply(ret);
		return ret;
	}

	String apply(String s) {
		StringBuilder ret = new StringBuilder();
		for (int i = 0, count = 0; i < s.length(); ) {
			while (i + count < s.length() && s.charAt(i) == s.charAt(i + count))
				count++;
			ret.append(count).append(s.charAt(i));
			i += count;
			count = 0;
		}
		return ret.toString();
	}
}
