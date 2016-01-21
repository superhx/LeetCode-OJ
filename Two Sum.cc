#include<vector>
#include<map>
#include<algorithm>

using namespace std;

class Solution {
 public:
  vector<int> twoSum(vector<int>& nums, int target) {
    map<int, int> valueToIndex;
    for(int i = 0, size = nums.size(); i < size; i++) {
      if(valueToIndex.count(target - nums[i]) != 0) {
        vector<int> res = {i + 1, valueToIndex[target - nums[i]]};
        sort(res.begin(), res.end());
        return res;
      }else {
        valueToIndex[nums[i]] = i + 1;
      }
    }
    return {-1, -1};
  }
};

