#include <string>
#include <vector>

using namespace std;

class Solution {
 public:
  bool isMatch(string s, string p) {
    const int slen = s.size(), plen = p.size();
    vector<bool> npres(plen + 1);

    // init npres when match substring (0, 0) of string s
    npres[0] = true;
    for (int i = 2; i < plen + 1; i++) npres[i] = npres[i - 2] && p[i - 1] == '*';

    bool ahead;
    for (int i = 0; i < slen; i++) {
      char sc = s[i];

      ahead = npres[0];
      npres[0] = false;
      for (int j = 0; j < plen; j++) {
        bool temp = npres[j + 1];
        char pc = p[j];
        if (pc != '*') {
          npres[j + 1] = ahead && (pc == sc || pc == '.');
        } else {
          npres[j + 1] = npres[j - 1] || (npres[j + 1] && (p[j - 1] == sc || p[j - 1] == '.'));
        }
        ahead = temp;
      }
    }

    return npres[plen];
  }
};

