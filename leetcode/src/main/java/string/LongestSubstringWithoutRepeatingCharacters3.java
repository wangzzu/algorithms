package string;

import java.util.HashSet;

/**
 * Created by matt on 5/19/16.
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int i = 0, j = 0;
		char[] strs = s.toCharArray();
		HashSet<Character> set = new HashSet();
		while (j < strs.length) {
			if (set.contains(strs[j])) {
				set.remove(strs[i++]);
			} else {
				set.add(strs[j++]);
				max = Math.max(max, set.size());
			}
		}
		return max;
	}
}
