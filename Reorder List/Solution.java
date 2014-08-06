class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class Solution {
    public void reorderList(ListNode head) {
    	if(head==null||head.next==null||head.next.next==null)
    		return;
        ListNode middle=head;
        ListNode temp=head;
        ListNode tail;
        while(temp.next!=null&&temp.next.next!=null){
        	middle=middle.next;
        	temp=temp.next.next;
        } 
        
        tail=(temp.next==null)?temp:(temp.next);
        temp=middle;
        middle=middle.next;
        temp.next=null;

        while(middle!=tail){
        	temp=middle;
        	middle=middle.next;
        	temp.next=tail.next;
        	tail.next=temp;
        }
        
        ListNode insert=head;
        while(middle!=null){
        	temp=middle;
        	middle=middle.next;
        	temp.next=insert.next;
        	insert.next=temp;
        	insert=insert.next.next;
        }
    }
}