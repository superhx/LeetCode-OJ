class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class SortList {

    //merge sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode first = head, second = head, split = head, tmp = null;

        //split
        while (split != null && split.next != null) {
            split = split.next.next;
            tmp = second;
            second = second.next;
        }
        tmp.next = null;

        first = sortList(first);
        second = sortList(second);


        if (first.val <= second.val) {
            tmp = first;
            first = first.next;
        } else {
            tmp = second;
            second = second.next;
        }
        head = tmp;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                tmp.next = first;
                first = first.next;
            } else {
                tmp.next = second;
                second = second.next;
            }
            tmp = tmp.next;
        }
        while (first != null) {
            tmp.next = first;
            tmp = tmp.next;
            first = first.next;
        }
        while (second != null) {
            tmp.next = second;
            tmp = tmp.next;
            second = second.next;
        }

        return head;
    }
}
