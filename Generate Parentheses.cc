#include <vector>
#include <string>

using namespace std;

class Solution {
 public:
  vector<string> generateParenthesis(int n) {
    string str(2 * n, ')');
    vector<string> ret;
    generate(0, 0, str, ret, n);
    return ret;
  }

 private:

  // l is the num of '(', r is the num of ')'
  void generate(int l, int r, string& str, vector<string>& ret, int n) {
    // if there already are n '(', then add str to ret
    if (l == n) {
      ret.push_back(str);
      return;
    }

    // r should never be bigger than l
    if (r < l) generate(l, r + 1, str, ret, n);

    str[l + r] = '(';
    generate(l + 1, r, str, ret, n);
    str[l + r] = ')';
  }
};

