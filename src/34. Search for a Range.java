/*
find fist and last index, and subtract first index by last index
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        // find start
        int start = findStart(nums, target);
        if (start == -1) return new int[]{-1, -1};
        int end = findEnd(nums, target);
        return new int[]{start, end};
    }
    
    public int findStart(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
    
    public int findEnd(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
    }
}