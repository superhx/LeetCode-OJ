import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class CopyListwithRandomPointer  {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null)
			return head;
		HashMap<RandomListNode, Integer> oldMap = new HashMap<RandomListNode, Integer>();
		ArrayList<RandomListNode> list = new ArrayList<RandomListNode>();
		int index = 0;
		while (head != null) {
			RandomListNode node = new RandomListNode(head.label);
			oldMap.put(head, index++);
			list.add(node);
			head = head.next;
		}
		int len=list.size();
		RandomListNode temp;
		for (Entry<RandomListNode, Integer> e : oldMap.entrySet()) {
			index=e.getValue();
			temp=list.get(index);
			if(index<len-1){
				temp.next=list.get(index+1);
			}
			RandomListNode random=e.getKey().random;
			temp.random=(random==null)?null:list.get(oldMap.get(random));
		}
		return list.get(0);
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}