#include <vector>

using namespace std;

class Solution {
 public:
  int maxArea(vector<int> &height) {
    int area = 0;
    int left = 0, right = height.size() - 1;
    while (left != right) {
      int temp = 0;
      if (height[left] < height[right]) {
        temp = height[left] * (right - left);
        left++;
      } else {
        temp = height[right] * (right - left);
        right--;
      }
      if(temp > area) area = temp;
    }
    return area;
  }
};

