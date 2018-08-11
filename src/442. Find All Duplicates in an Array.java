/*
not hard to understand
When we meet an element n, flip nums[n - 1] to negative(to ensure the array is not out of boundary)
if an element is duplicate, the nums[n - 1] should be negative
 */

// input: nums = [4, 3, 2, 7, 8, 2, 3, 1]

class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // make sure the index is within the boundary
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index];
        }
        return res;
    }
}