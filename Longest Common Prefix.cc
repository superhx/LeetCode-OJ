#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  string longestCommonPrefix(vector<string> &strs) {
    if (strs.size() == 0) return "";
    string prefix = strs[0];
    for (auto it = strs.cbegin() + 1, end = strs.cend(); it != end; it++) {
      auto pit = prefix.begin(), pend = prefix.end();
      for (char c : *it) {
        if(c != *pit || pit == pend) break;
        pit++;
      }
      prefix.erase(pit, pend);
    }
    return prefix;
  }
};

