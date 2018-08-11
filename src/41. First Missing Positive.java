// bucket sort 
// corresponding space to store corresponding number
class Solution {
    // put integer to correct postion
    public int firstMissingPositive(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) return 1;
        // swap A[i] and A[A[i] - 1]
        for (int i = 0; i < nums.length; i++) {
            // the condition for swap
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}