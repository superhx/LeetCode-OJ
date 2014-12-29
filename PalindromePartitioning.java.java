import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		HashMap<Integer, List<Point>> palindromes = new HashMap<Integer, List<Point>>();
		List<List<String>> list = new LinkedList<List<String>>();
		char[] str = s.toCharArray();
		int len = str.length;
		for (int i = 0; i < str.length; i++)
			palindromes.put(i, new LinkedList<Point>());
		for (Point point : getPalindrome(str))
			palindromes.get(point.x).add(point);
		Stack<Iterator<Point>> stack = new Stack<Iterator<Point>>();
		LinkedList<Point> points = new LinkedList<Point>();
		stack.add(palindromes.get(0).iterator());
		while (!stack.isEmpty()) {
			while (stack.peek().hasNext()) {
				Point temp = stack.peek().next();
				points.add(temp);
				if (temp.y == len - 1) {
					LinkedList<String> newList = new LinkedList<String>();
					for (Point point : points)
						newList.add(s.substring(point.x, point.y + 1));
					list.add(newList);
					points.removeLast();
				} else {
					stack.add(palindromes.get(temp.y+1).iterator());
				}
			}
			stack.pop();
			if(!stack.isEmpty()){
				points.removeLast();	
			}
		}
		return list;
	}

	List<Point> getPalindrome(char[] str) {
		ArrayList<Point> points = new ArrayList<Point>();
		int len = str.length;
		int stretch = 0;
		for (int i = 0; i < str.length; i++) {
			stretch = 0;
			while (true) {
				int start = i - stretch;
				int end = i + stretch;
				if ((start >= 0) && (end < len) && (str[start] == str[end])) {
					points.add(new Point(start, end));
					stretch++;
				} else
					break;
			}
			stretch = 0;
			while (true) {
				int start = i - stretch;
				int end = i + stretch + 1;
				if ((start >= 0) && (end < len) && (str[start] == str[end])) {
					points.add(new Point(start, end));
					stretch++;
				} else
					break;
			}
		}
		return points;
	}
}