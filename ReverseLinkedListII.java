package leetcode;


import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode left, right, pointer;
        Stack<ListNode> reverse = new Stack<>();
        pointer = fakeHead;
        for (int i = 1; i < m; i++) pointer = pointer.next;
        left = pointer;
        for (int i = m; i <= n; i++) {
            pointer = pointer.next;
            reverse.push(pointer);
        }
        right = pointer.next;
        for (int i = m; i <= n; i++) {
            left.next = reverse.pop();
            left = left.next;
        }
        left.next = right;
        return fakeHead.next;
    }
}