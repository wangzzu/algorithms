package ten;

import java.util.Scanner;

/**
 * 题目：请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are
 * Happy.则经过替换之后的字符串为We%20Are%20Happy。O（n）。
 * http://ac.jobdu.com/problem.php?pid=1510
 * 
 * @author matt
 *
 */
public class ReplaceBlank_04 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		RepalceBlank(str);
	}

	public static void RepalceBlank(String msgs) {
		char[] msg = msgs.toCharArray();
		int length = msg.length;
		if (msg == null || length == 0)
			return;
		int numOfBlank = 0;
		for (int i = 0; i < length; i++) {
			if (msg[i] == ' ')
				numOfBlank++;
		}
		int newLength = length + numOfBlank * 2;
		char[] newMsg = new char[newLength];
		for (int i = length - 1; i >= 0; i--) {
			if (msg[i] == ' ') {
				newMsg[newLength - 1] = '0';
				newLength--;
				newMsg[newLength - 1] = '2';
				newLength--;
				newMsg[newLength - 1] = '%';
				newLength--;
			} else {
				newMsg[newLength - 1] = msg[i];
				newLength--;
			}
		}
		System.out.println(msgs + "转换之后的数组为：" + String.valueOf(newMsg));
	}
}
