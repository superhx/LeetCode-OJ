#include <vector>
#include <algorithm>

using namespace std;

class Solution {
 public:
  vector<vector<int>> fourSum(vector<int>& nums, int target) {
    if (nums.size() < 4) return {};

    sort(nums.begin(), nums.end());
    vector<vector<int>> res;
    for (int i = 0, size = nums.size(); i < size - 3; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) continue;
      if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
      if (nums[i] + nums[size - 1] + nums[size - 2] + nums[size - 3] < target) continue;

      for (int j = i + 1; j < size - 2; j++) {
        if (j != i + 1 && nums[j] == nums[j - 1]) continue;

        int remainTarget = target - nums[i] - nums[j];
        int l = j + 1, r = size - 1;

        while (l < r) {
          int sum = nums[l] + nums[r];
          if (sum < remainTarget) {
            l++;
          } else if (sum > remainTarget) {
            r--;
          } else {
            res.push_back({nums[i], nums[j], nums[l], nums[r]});
            l++;
            r--;
          }
          while (l != j + 1 && nums[l] == nums[l - 1]) l++;
          while (r != size - 1 && nums[r] == nums[r + 1]) r--;
        }
      }
    }
    return res;
  }
};

