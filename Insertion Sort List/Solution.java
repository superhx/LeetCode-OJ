/**
 * Definition for singly-linked list.
 **/
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode insertionSortList(ListNode head) {
		if(head==null)
			return head;
		ListNode list = new ListNode(0);
		ListNode prev;
		ListNode temp;
		list.next = head;
		head = head.next;
		list.next.next=null;
		while (head != null) {
			prev = list;
			while (prev.next != null) {
				temp=head;
				if(head.val<=prev.next.val){
					head=head.next;
					temp.next=prev.next;
					prev.next=temp;
					break;
				}else if(prev.next.next==null){
					head=head.next;
					prev.next.next=temp;
					temp.next=null;
					break;
				}
				prev=prev.next;
			}
		}

		return list.next;
	}
}