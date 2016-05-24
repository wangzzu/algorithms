package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by matt on 5/19/16.
 */
public class RegularExpressionMatching10 {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<List<String>>();
		}
		HashMap<String, List<String>> map = new HashMap<>();
		Arrays.sort(strs); // sort first
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String st = String.valueOf(chars);
			if (map.containsKey(st)) {
				map.get(st).add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(st, list);
			}
		}
		return new ArrayList<List<String>>(map.values());
	}
}
