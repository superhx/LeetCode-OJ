struct ListNode {
  int val;
  ListNode* next;
  ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
 public:
  ListNode* deleteDuplicates(ListNode* head) {
    if (head == nullptr) return head;

    ListNode* ahead = new ListNode(-1);
    ahead->next = head;
    head = ahead;

    bool repeat = false;
    while (ahead->next != nullptr && ahead->next->next != nullptr) {
      if (ahead->next->val == ahead->next->next->val) {
        repeat = true;
        ListNode* temp = ahead->next->next;
        ahead->next->next = temp->next;
        delete temp;
      } else if (repeat) {
        ListNode* temp = ahead->next;
        ahead->next = temp->next;
        delete temp;
        repeat = false;
      } else {
        ahead = ahead->next;
      }
    }
    if (repeat) {
      delete ahead->next;
      ahead->next = nullptr;
    }
    ListNode* temp = head;
    head = head->next;
    delete temp;
    return head;
  }
};
