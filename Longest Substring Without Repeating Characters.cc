#include <string>
#include <algorithm>

using namespace std;

class Solution {
 public:
  int lengthOfLongestSubstring(string s) {
    if(s.size() == 0) return 0;
    int lastLen = 1;
    int max = 1;
    for(int i = 0, size = s.size(); i < size - 1; i++) {
      string::size_type pos = s.substr(i - lastLen + 1, lastLen).find(s[i + 1]);
      if(pos != string::npos) {
        lastLen -= pos;
      }else {
        lastLen++;
      }
      if(lastLen > max) max = lastLen;
    }
    return max;
  }

};

