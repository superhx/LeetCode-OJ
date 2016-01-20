#include <vector>
#include <stack>

using namespace std;

class Solution {
 public:
  int largestRectangleArea(vector<int>& heights) {
    int maxArea = 0;
    stack<int> high;

    heights.push_back(0);
    for(int i = 0, size = heights.size(); i < size; i++) {

      if(high.empty() || heights[i] >= heights[high.top()]) {
        high.push(i);
        continue;
      }

      int topHigh = high.top();
      high.pop();

      int area = heights[topHigh] * (high.empty() ? i : i - high.top() - 1);
      if(area > maxArea) maxArea = area;

      i--;
    }
    return maxArea;
  }
};
