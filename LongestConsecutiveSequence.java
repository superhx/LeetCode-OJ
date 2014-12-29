package Practice;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		if(num.length<=1) return num.length;
		Set<Integer> nums=new TreeSet<Integer>();
		for(int i=0,len=num.length;i<len;i++){
			nums.add(num[i]);
		}
		int maxLen=0;
		while(!nums.isEmpty()){
			Iterator<Integer> it=nums.iterator();
			int head=it.next();
			it.remove();
			int temp;
			int len=1;
			while(it.hasNext()&&(temp=it.next())==head+1){
				it.remove();
				head=temp;
				len++;
			}
			maxLen=Math.max(len, maxLen);
		}
		return maxLen;
	}
}