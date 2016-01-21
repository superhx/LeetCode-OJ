struct ListNode {
  int val;
  ListNode* next;
  ListNode(int x): val(x), next(nullptr) {}
};

#include <memory>

using namespace std;

class Solution {
 public:
  ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
    shared_ptr<ListNode> head = make_shared<ListNode>(-1);
    ListNode* ahead = head.get();
    int plus = 0;
    while(l1 != nullptr && l2 != nullptr) {
      int sum = l1->val + l2->val + plus;
      plus = (sum >= 10 ? 1 : 0);
      ahead->next = new ListNode(sum % 10);
      ahead = ahead->next;
      l1 = l1->next, l2 = l2->next;
    }
    if(l1 != nullptr || l2 != nullptr) {
      ListNode* tail = (l1 == nullptr ? l2 : l1);
      while(tail != nullptr) {
        int sum = tail->val + plus;
        plus = (sum >= 10 ? 1 : 0);
        ahead->next = new ListNode(sum % 10);
        ahead = ahead->next;
        tail = tail->next;
      }
    }

    if(plus != 0) {
      ahead->next = new ListNode(1);
    }
    return head->next;
  }
};

