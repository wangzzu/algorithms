package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by matt on 4/21/16.
 */
public class ValidAnagram242 {
	public static void main(String[] args) {
		System.out.println(solution("qwertqw","trwqeqw"));
		System.out.println(solution2("qwertqw", "trwqeqw"));
		System.out.println(solution3("qwertqw", "trwqeqw"));
	}

	/**
	 * HashMap store the char of the String, but the runnning time is too long
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean solution(String s, String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		int length = sc.length;
		if (tc.length != length) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		for (char sc1 : sc) {
			if (!map.containsKey(sc1)) {
				map.put(sc1, 1);
			} else {
				map.put(sc1, map.get(sc1) + 1);
			}
		}
		for (char tc1 : tc) {
			if (!map.containsKey(tc1)) {
				return false;
			} else {
				map.put(tc1, map.get(tc1) - 1);
			}
		}
		for (char key : map.keySet()) {
			if (map.get(key) != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * use sort algorithm
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean solution2(String s, String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		int length = sc.length;
		if (tc.length != length) {
			return false;
		}
		Arrays.sort(sc);
		Arrays.sort(tc);
		for(int i=0;i<sc.length;i++){
			if(sc[i]!=tc[i]){
				return false;
			}
		}
		return true;
	}

	/**
	 * use the array of letter
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean solution3(String s, String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		if (sc.length != tc.length) return false;
		int[] m = new int[26];
		for (int i = 0; i < sc.length; ++i){
			++m[sc[i] - 'a'];
		}
		for (int i = 0; i < tc.length; ++i) {
			if (--m[tc[i] - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
}
