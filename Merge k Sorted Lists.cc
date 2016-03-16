struct ListNode {
  int val;
  ListNode* next;
  ListNode(int x) : val(x), next(nullptr) {}
};

#include <vector>

using namespace std;

class Solution {
 public:
  ListNode* mergeKLists(vector<ListNode*>& lists) {
    int size = lists.size();
    if (size == 0) return nullptr;
    if (size == 1) return lists[0];
    return merge(lists, 0, size - 1);
  }

 private:
  ListNode* merge(vector<ListNode*>& lists, int start, int end) {
    if(start == end) return lists[start];
    int mid = (start + end) / 2;
    ListNode* l = merge(lists, start, mid);
    ListNode* r = merge(lists, mid + 1, end);

    ListNode fhead(-1);
    ListNode* cur = &fhead;
    while(l != nullptr && r != nullptr) {
      ListNode** min = l->val < r->val ? &l : &r;
      cur->next = *min;
      cur = cur->next;
      *min = (*min)->next;
    }

    cur->next = l == nullptr ? r : l;

    return fhead.next;
  }
};
#include <iostream>

int main() {}

