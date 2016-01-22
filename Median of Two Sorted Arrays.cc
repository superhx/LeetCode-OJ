#include <vector>

using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int size = nums1.size() + nums2.size();
        if(size == 0) return 0;
        auto it1 = nums1.cbegin(), it2 = nums2.cbegin();
        auto end1 = nums1.cend(), end2 = nums2.cend();
        for(int i = 0, middle = size / 2; i < middle - 1; i++) getNext(it1, it2, end1, end2);
        if(size % 2 == 0) {
            return (getNext(it1, it2, end1, end2) + getNext(it1, it2, end1, end2)) / 2.0;
        }else {
            if(size !=1) getNext(it1, it2, end1, end2);
            return getNext(it1, it2, end1, end2);
        }
    }

private:
    int getNext(
            vector<int>::const_iterator& it1, vector<int>::const_iterator& it2,
            vector<int>::const_iterator& end1, vector<int>::const_iterator& end2
    )
    {
        if(it1 == end1) {
            return *(it2++);
        }else if(it2 == end2) {
            return *(it1++);
        }
        if(*it1 > *it2) {
            return *(it2++);
        }else {
            return *(it1++);
        }
    }
};
