struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
 public:
  ListNode* deleteDuplicates(ListNode* head) {
    if(head==nullptr) return head;

    ListNode *ahead = head, *cur = head->next;
    while(cur != nullptr) {
      if(ahead->val == cur->val) {
        ahead->next = cur->next;
        delete cur;
        cur = ahead->next;
      }else {
        ahead = cur;
        cur = ahead->next;
      }
    }
    return head;
  }
};

