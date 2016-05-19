package String;

/**
 * Created by matt on 5/19/16.
 */
public class ImplementstrStr28 {
	public int strStr(String haystack, String needle) {
		int len1=haystack.length();
		int len2=needle.length();
		if(len1<len2||haystack==null){
			return -1;
		}
		for(int i=0;i<=len1-len2;i++){
			String str=haystack.substring(i,i+len2);
			if(str.equals(needle)){
				return i;
			}
		}
		return -1;
	}
}
