public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ahead = new ListNode(-1), fake = ahead;
        ahead.next = head;

        ListNode tail = ahead.next;
        while (tail != null) {
            {
                ListNode next = tail;
                for (int i = 0; i < k - 1; i++) {
                    if ((next = next.next) == null) return fake.next;
                }
            }

            for (int i = 0; i < k - 1; i++) {
                ListNode cur = tail.next;
                tail.next = cur.next;
                cur.next = ahead.next;
                ahead.next = cur;
            }

            ahead = tail;
            tail = tail.next;
        }
        return fake.next;
    }
}
