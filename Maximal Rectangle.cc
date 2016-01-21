#include <vector>
#include <stack>

using namespace std;

class Solution {
 public:
  int largestRectangleArea(vector<int> heights) {
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

  int maximalRectangle(vector<vector<char>>& matrix) {
    if(matrix.empty() || matrix[0].empty()) return 0;
    int row = matrix.size(), col = matrix[0].size();
    vector<int> heights(col);

    int maxArea = 0;
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
      }

      int area = largestRectangleArea(heights);
      if(area > maxArea) maxArea = area;
    }
    return maxArea;            
  }
};
