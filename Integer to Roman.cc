#include <string>

using namespace std;

class Solution {
 public:
  string intToRoman(int num) {
    string c[4][9] = {{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                      {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                      {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                      {"M", "MM", "MMM"}};
    string roman;
    if (num / 1000 != 0) roman += c[3][num / 1000 - 1];
    num %= 1000;
    if (num / 100 != 0) roman += c[2][num / 100 - 1];
    num %= 100;
    if (num / 10 != 0) roman += c[1][num / 10 - 1];
    num %= 10;
    if (num != 0) roman += c[0][num - 1];
    return roman;
  }
};
