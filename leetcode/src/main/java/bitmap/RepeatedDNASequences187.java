package bitmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by matt on 5/3/16.
 */
public class RepeatedDNASequences187 {
	public static void main(String[] args) {
		List<String> ans = findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		Iterator it = ans.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	/**
	 * @param s
	 * @return
	 */
	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> ans = new LinkedList<String>();
		if (s.length() == 0 || s == null) {
			return ans;
		}
		HashMap<Character, Integer> bitmap = new HashMap<>();
		bitmap.put('A', 0);
		bitmap.put('C', 1);
		bitmap.put('G', 2);
		bitmap.put('T', 3);
		HashMap<Integer, Integer> substr = new HashMap<>();
		for (int i = 0; i <= s.length() - 10; i++) {
			int cur = 0;
			for (int j = i; j < i + 10; j++) {
				cur = cur << 2;
				cur += bitmap.get(s.charAt(j));
			}
			if (!substr.containsKey(cur)) {
				substr.put(cur, 1);
			} else if (substr.get(cur) == 1) {
				substr.put(cur, 2);
				ans.add(s.substring(i, i + 10));
			}
		}
		return ans;
	}

	/**
	 * use th property of set
	 *
	 * @param s
	 * @return
	 */
	public static List<String> findRepeatedDnaSequences2(String s) {
		Set<String> all = new HashSet<String>();
		Set<String> ans = new HashSet<String>();
		for (int i = 0; i <= s.length() - 10; i++) {
			if (!all.add(s.substring(i, i + 10))) {
				ans.add(s.substring(i, i + 10));
			}
		}
		return new ArrayList(ans);
	}

	/**
	 * use the bit operation
	 *
	 * @param s
	 * @return
	 */
	public List<String> findRepeatedDnaSequences3(String s) {
		List<String> ans = new ArrayList<String>();
		if (s == null || s.length() < 10) {
			return ans;
		}
		HashSet<Integer> once = new HashSet<>();
		HashSet<Integer> twice = new HashSet<>();
		int[] abc = new int[26];
		abc['A' - 'A'] = 0;
		abc['C' - 'A'] = 1;
		abc['G' - 'A'] = 2;
		abc['T' - 'A'] = 3;
		int tmp = 0;
		for (int i = 0; i < 9; i++) {
			tmp <<= 2;
			tmp |= abc[s.charAt(i) - 'A'];
		}
		for (int i = 9; i < s.length(); i++) {
			tmp <<= 2;
			tmp &= 0xfffff;
			tmp |= abc[s.charAt(i) - 'A'];
			if (!once.add(tmp) && twice.add(tmp)) {
				ans.add(s.substring(i - 9, i + 1));
			}
		}
		return ans;
	}
}
