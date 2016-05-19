package String;

/**
 * Created by matt on 5/19/16.
 */
public class AddBinary68 {
	public String addBinary(String a, String b) {
		int lena = a.length();
		int lenb = b.length();
		String ans = "";
		int re = 0; // remainder
		int i = 0;
		while (i < lena || i < lenb || re > 0) {
			int a1 = (i < lena) ? (a.charAt(lena - 1 - i) - '0') : 0;
			int b1 = (i < lenb) ? (b.charAt(lenb - 1 - i) - '0') : 0;
			ans = (a1 + b1 + re) % 2 + ans;
			re = (a1 + b1 + re) / 2;
			i++;
		}
		return ans;
	}
}
