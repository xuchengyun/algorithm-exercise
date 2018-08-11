/*
special case binary search
estimate in the fist half part or the last half part
based on compare mid with start , mid with end
*/

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start)/2 + start;
            if (nums[mid] == target) return mid;
            if (nums[start] < nums[mid]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target <= nums[end] && target >= nums[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
}