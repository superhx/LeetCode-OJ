#include <string>
#include <climits>

using namespace std;

class Solution {
 public:
  int myAtoi(string str) {
    string::iterator it = str.begin();
    for(string::iterator end = str.end(); it != end; it++) {
      if(*it != ' ' && *it != '0') break;
    }

    bool positive = true;
    if(*it == '-') {
      positive = false;
      it++;
    }else if(*it == '+') {
      positive = true;
      it++;
    }

    int res = 0;
    for(string::iterator end = str.end(); it != end; it++) {
      if(*it < 48 || *it > 57) break;
      int temp = res * 10 + (positive ? (*it - 48) : -(*it - 48));
      if(temp / 10 != res) return positive ? INT_MAX : INT_MIN;
      res = temp;
    }
    return res;
  }
};

