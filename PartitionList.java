class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode ltHead = new ListNode(-1), geHead = new ListNode(-1); // less than, great or equal
        ListNode ltTail = ltHead, geTail = geHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                ltTail.next = cur;
                ltTail = cur;
            } else {
                geTail.next = cur;
                geTail = cur;
            }
            cur = cur.next;
        }
        ltTail.next = geHead.next;
        geTail.next = null;
        return ltHead.next;
    }

}

