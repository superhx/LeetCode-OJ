struct ListNode {
  int val;
  ListNode* next;
  ListNode(int x) : val(x), next(nullptr) {}
};

#include <memory>

using namespace std;

class Solution {
 public:
  ListNode* mergeTwoLists(ListNode* l, ListNode* r) {
    shared_ptr<ListNode> fhead = make_shared<ListNode>(-1);
    ListNode* tail = fhead.get();

    while (l != nullptr && r != nullptr) {
      if (l->val < r->val) {
        tail->next = l;
        l = l->next;
      } else {
        tail->next = r;
        r = r->next;
      }
      tail = tail->next;
    }

    tail->next = (l == nullptr ? r : l);
    return fhead->next;
  }
};

