package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by matt on 5/17/16.
 */
public class EvaluateReversePolishNotation150 {
	public int evalRPN(String[] tokens) {
		Stack<Integer> nums=new Stack();
		List<String> opt=new ArrayList<>();
		opt.add("+");
		opt.add("-");
		opt.add("*");
		opt.add("/");
		for(String str:tokens){
			if(opt.contains(str)){
				if(nums.size()<2){
					return 0;
				}
				int num1=nums.pop();
				int num2=nums.pop();
				if(str.equals("+")){
					nums.push(num1+num2);
				}else if(str.equals("-")){
					nums.push(num2-num1);
				}else if(str.equals("*")){
					nums.push(num1*num2);
				}else if(str.equals("/")){
					nums.push(num2/num1);
				}
			}else{
				int tmp=Integer.valueOf(str);
				nums.push(tmp);
			}
		}
		return nums.pop();
	}
}
