/*
*Given an input string, reverse the string word by word.
*For example,
*Given s = "the sky is blue",
*return "blue is sky the".
*/

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public String reverseWords(String s) {
       Pattern regrex=Pattern.compile("\\S+");
		Matcher match=regrex.matcher(s);
		StringBuffer strBuffer = new StringBuffer();
		Stack<String> stack=new Stack<String>();
		while(match.find()){
			stack.add(match.group());
		}
		while(!stack.isEmpty()){
			strBuffer.append(stack.pop());
			if(!stack.isEmpty()){
				strBuffer.append(" ");
			}
		}
		return strBuffer.toString();
    }
}