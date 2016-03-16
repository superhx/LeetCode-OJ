struct ListNode {
  int val;
  ListNode* next;
  ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
 public:
  ListNode* swapPairs(ListNode* head) {
    if(!head || !head->next) return head;
    ListNode* second = head->next;
    head->next = swapPairs(second->next);
    second->next = head;
    return second;
  }
};

