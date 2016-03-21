package search_three;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.StdOut;

/**
 * 一个使用符号表的性能测试用例，用来统计一个文件中单词的频率
 * 
 * @author matt
 *
 */
public class FrequencyCounter {
	private FrequencyCounter() {
	}

	public static void main(String[] args) {
		int distinct = 0;
		int words = 0;
		int minlen = Integer.parseInt(args[0]);
		ST<String, Integer> st = new ST<String, Integer>();

		FileReader reader;

		try {
			reader = new FileReader("/home/matt/data/suanfadata/tale");
			BufferedReader br = new BufferedReader(reader);
			String msg = null;
			while ((msg = br.readLine()) != null) {
				String[] msgs = msg.split(" ");

				for (String key : msgs) {
					if (key.length() < minlen)
						continue;
					words++;// 记录长度大于minlen的总单词数
					if (st.contains(key)) {
						st.put(key, st.get(key) + 1);
					} else {
						st.put(key, 1);
						distinct++;// 记录长度大于minlen的单词数（不重复）
					}
				}
			}
			br.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String max = "";
		st.put(max, 0);
		for (String word : st.keys()) {
			if (st.get(word) > st.get(max))
				max = word;
		}
		StdOut.println(max + " " + st.get(max));
		StdOut.println("distinct = " + distinct);
		StdOut.println("words = " + words);
	}
}
