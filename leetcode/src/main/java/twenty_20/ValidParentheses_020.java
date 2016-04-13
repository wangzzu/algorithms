package twenty_20;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses_020 {

	public static void main(String[] args) {
		String string = "]";
		System.out.println(isValid(string));
	}

	public static boolean isValid(String s) {
		boolean isvalid = false;
		char[] left = { '{', '[', '(' };
		char[] right = { '}', ']', ')' };
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < left.length; i++)
			map.put(left[i], right[i]);
		Stack<Character> stack = new Stack<Character>();
		char[] chars = s.toCharArray();
		for (char charc : chars) {
			if (map.containsKey(charc))
				stack.push(charc);
			if (map.containsValue(charc)) {
				if (stack.size() == 0) {
					return isvalid;
				} else {
					if (charc != map.get(stack.pop()))
						return isvalid;
				}
			}
		}
		if (stack.size() == 0)
			isvalid = true;
		return isvalid;
	}
}
