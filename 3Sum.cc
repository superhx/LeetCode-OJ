#include <vector>

using namespace std;

class Solution {
 public:
  vector<vector<int>> threeSum(vector<int> &nums) {
    vector<vector<int>> res;
    if (nums.size() < 3) return res;

    sort(nums.begin(), nums.end());

    for (int i = 0, size = nums.size(); i < size - 2; i++) {
      if (nums[i] > 0) break;
      if (i != 0 && nums[i] == nums[i - 1]) continue;

      int left = i + 1, right = size - 1, target = -nums[i];
      while (left < right) {

        int twoSum = nums[left] + nums[right];
        if (twoSum > target) {
          right--;
        } else if (twoSum < target) {
          left++;
        } else {
          res.push_back({nums[i], nums[left], nums[right]});
          left++;
          right--;
        }

        while(left > i + 1 && nums[left] == nums[left - 1]) left++;
        while(right < size -1 && nums[right] == nums[right + 1]) right--;

      }
    }

    return res;
  }
};

