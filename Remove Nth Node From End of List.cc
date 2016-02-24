struct ListNode {
  int val;
  ListNode* next;
  ListNode(int x) : val(x), next(nullptr) {}
};

#include <memory>

using namespace std;

class Solution {
 public:
  ListNode* removeNthFromEnd(ListNode* head, int n) {
    if (head == nullptr || n <= 0) return head;

    shared_ptr<ListNode> fakeHead = make_shared<ListNode>(-1);
    fakeHead->next = head;

    ListNode *ahead = fakeHead.get(), *ptr = head;
    while (--n > 0 && ptr->next != nullptr) ptr = ptr->next;
    while (ptr->next != nullptr) {
      ahead = ahead->next;
      ptr = ptr->next;
    }

    ListNode* temp = ahead->next;
    ahead->next = temp->next;
    delete temp;

    return fakeHead->next;
  }
};

