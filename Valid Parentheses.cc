#include <string>
#include <stack>

using namespace std;

class Solution {
 public:
  bool isValid(string s) {
    stack<char> pairs;
    for (char c : s) {
      if (c == '(' || c == '[' || c == '{') {
        pairs.push(c);
      } else if (!pairs.empty()) {
        if (isPair(pairs.top(), c)) {
          pairs.pop();
        } else {
          return false;
        }
      } else {
        return false;
      }
    }
    return pairs.empty();
  }

 private:
  bool isPair(char l, char r) {
    if (l == '(' && r == ')') return true;
    if (l == '[' && r == ']') return true;
    if (l == '{' && r == '}') return true;
    return false;
  }
};

