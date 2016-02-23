#include <vector>
#include <string>
#include <utility>

using namespace std;

class Solution {
 private:
  static const vector<vector<char>> digitLetterMapping;

  const vector<char>& getlettersMapping(char digit) {
    int offset = digit - '1';
    if (offset < 0 || offset > 8) return digitLetterMapping[0];
    return digitLetterMapping[offset];
  }

 public:
  vector<string> letterCombinations(string digits) {
    if(digits.size() == 0) return {};
    vector<string> combinations = {""};
    for (char digit : digits) {
      const vector<char>& letters = getlettersMapping(digit);
      vector<string> temp;
      for (string str : combinations) {
        for (char letter : letters) {
          temp.push_back(str + letter);
        }
      }
      combinations = std::move(temp);
    }
    return combinations;
  }
};

const vector<vector<char>> Solution::digitLetterMapping = {
    {},
    {'a', 'b', 'c'},
    {'d', 'e', 'f'},
    {'g', 'h', 'i'},
    {'j', 'k', 'l'},
    {'m', 'n', 'o'},
    {'p', 'q', 'r', 's'},
    {'t', 'u', 'v'},
    {'w', 'x', 'y', 'z'}};

