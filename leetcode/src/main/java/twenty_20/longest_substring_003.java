package twenty_20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class longest_substring_003 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println(lengthOfLongestSubstring(str));
		System.out.println(getLengthOfString(str));
	}

	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		char[] strs = s.toCharArray();
		int N = strs.length;
		HashMap<Character, Integer> map = new HashMap();
		int pre = 0;
		int cuSum = 0;
		for (int i = 0; i < N; i++) {
			if (map.containsKey(strs[i])) {
				int index = map.get(strs[i]);
				map.put(strs[i], i);
				if (index < pre) {
					cuSum++;
					if (cuSum > max)
						max = cuSum;
				} else {
					pre = index + 1;
					cuSum = i - index;
				}
			} else {
				map.put(strs[i], i);
				cuSum++;
				if (cuSum > max)
					max = cuSum;
			}
		}
		return max;
	}

	public static int getLengthOfString(String str) {
		int max = 0;
		int i = 0, j = 0;
		char[] strs = str.toCharArray();
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
