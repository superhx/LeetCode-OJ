import java.util.LinkedList;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		int len = s.length();
		if (len == 0&&dict.contains(s))
			return true;
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
		if(starts.getLast()==len)
			return true;
		return false;
	}
}