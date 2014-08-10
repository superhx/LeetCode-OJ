import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
	public List<String> wordBreak(String s, Set<String> dict) {
		LinkedList<String> list = new LinkedList<String>();
		int len = s.length();
		if (len == 0 && dict.contains(s)) {
			list.add(s);
			return list;
		}
		LinkedList<Integer> starts=new LinkedList<Integer>();
		starts.add(0);
		for(int i=0;i<len;i++){
			int end=i+1;
			for(Integer start : starts){
				if(dict.contains(s.substring(start, end))){
					starts.add(end);
					break;
				}
			}
		}
		if(starts.getLast()!=len)
			return list;
		LinkedList<IntegerString> map = new LinkedList<IntegerString>();
		LinkedList<IntegerString> plus=new LinkedList<IntegerString>();
		map.add(new IntegerString(0,""));
		for (int i = 0; i < len; i++) {
			int end = i + 1;
			for (IntegerString e : map) {
				String sub=s.substring(e.key,end);
				if(dict.contains(sub)){
					plus.add(new IntegerString(end,e.value+sub+" "));
				}
			}
			map.addAll(plus);
			plus.clear();
		}
		
		Iterator<IntegerString> it=map.iterator();
		while(it.hasNext()){
			IntegerString next=it.next();
			if(next.key!=len){
				it.remove();
			}else{
				list.add(next.value.substring(0, next.value.length()-1));
			}
		}
		return list;
	}
	
	class IntegerString{
		public int key;
		public String value;
		public IntegerString(int key,String value){
			this.key=key;
			this.value=value;
		}
	}
}