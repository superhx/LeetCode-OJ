#include <string>

using namespace std;

class Solution {
 public:
  string longestPalindrome(string s) {
    string longest;
    for(int i = 0, size = s.size(); i < size; i++) {
      string oddPalindrome = findOddPalindrome(s, i);
      string evenPalindrome = findEvenPalindrome(s, i);
      string palindrome = oddPalindrome.size() > evenPalindrome.size() ? oddPalindrome : evenPalindrome;
      if(palindrome.size() > longest.size()) longest = palindrome;
    }
    return longest;
  }

  private:
    string findOddPalindrome(string s, int center) {
      int offset = 1;
      int size = s.size();
      while(center - offset >= 0 && center + offset < size) {
        if(s[center - offset] != s[center + offset]) break;
        offset++;
      }
      return s.substr(center - offset + 1, (offset - 1) * 2 + 1);
    }

    string findEvenPalindrome(string s, int left) {
      int size = s.size();
      if(left == size || s[left] != s[left + 1]) return "";
      int offset = 1;
      while(left - offset >= 0 && left + 1 + offset < size) {
        if(s[left - offset] != s[left + 1 + offset]) break;
        offset++;
      }
      return s.substr(left - offset + 1, (offset - 1) * 2 + 2);
    }
};
