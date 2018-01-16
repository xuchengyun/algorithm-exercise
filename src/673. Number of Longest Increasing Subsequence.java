class Solution {
    // Using dp to solve this problem
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, max_len = 0, res = 0;
        int[] len = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[j] + 1 == len[i]) {
                        cnt[i] += cnt[j];
                    }
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max_len == len[i]) {
                res += cnt[i];
             }
            if(max_len < len[i]){
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}