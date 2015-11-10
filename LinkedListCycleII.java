import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycleII {
    HashSet<ListNode> set = new HashSet<ListNode>();

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        if (head.next == head)
            return head;
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp.next))
                return temp.next;
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }

}
