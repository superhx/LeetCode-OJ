#include <vector>
#include <algorithm>
#include <cstddef>
#include <cstdlib>

using namespace std;

class Solution {
 public:
  int threeSumClosest(vector<int> &nums, int target) {
    if (nums.size() < 3) return 0;
    sort(nums.begin(), nums.end());
    int closest = nums[0] + nums[1] + nums[2];
    for (int i = 0, size = nums.size(); i < size - 2; i++) {
      int l = i + 1, r = size - 1;
      while (l < r) {
        int innerClosest = nums[i] + nums[l] + nums[r];
        if (innerClosest == target) return innerClosest;
        if (abs(closest - target) > abs(innerClosest - target)) {
          closest = innerClosest;
        }
        if (innerClosest > target) {
          r--;
        } else {
          l++;
        }
      }
    }
    return closest;
  }
};

