import java.util.HashSet;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class LinkedListCycle {
	HashSet<ListNode> set=new HashSet<ListNode>();
    public boolean hasCycle(ListNode head) {
    	if(head==null||head.next==null)
    		return false;
    	if(head.next==head)
    		return true;
    	ListNode temp=head;
    	while(temp!=null){
    		if(set.contains(temp.next))
    			return true;
    		set.add(temp);
    		temp=temp.next;
    	}
        return false;
    }
}