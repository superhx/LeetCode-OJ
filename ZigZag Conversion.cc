#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  string convert(string text, int nRows) {
    if(nRows == 1) return text;
    vector<string> zigzag(nRows);
    int row = 0;
    int step = 1;
    for(char c : text) {
      zigzag[row].push_back(c);
      if(row == nRows - 1) step = -1;
      if(row == 0) step = 1;
      row += step;
    }

    string res;
    for(auto s : zigzag) {
      res += s;
    }
    return res;
  }
};

