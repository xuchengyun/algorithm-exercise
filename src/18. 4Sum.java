// Using set to avoid repetition

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // remove duplicates
                        left ++; 
                        right --;
                    } else if (sum < target) {
                        left ++;
                    } else {
                        right --;
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(res);
    }
}