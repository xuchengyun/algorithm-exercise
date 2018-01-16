//bucket sort
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE, n = nums.length;
        for (int d : nums) {
            mx = Math.max(mx, d);
            mn = Math.min(mn, d);
        }
        int size = (mx - mn) / n + 1;
        int bucket_nums = (mx - mn) / size + 1;
        int[] bucketsMIN = new int[bucket_nums]; // store the min value in that bucket
        int[] bucketsMAX = new int[bucket_nums]; // store the max value in that bucket
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        for (int d : nums) {
            int idx = (d - mn) / size;
            bucketsMIN[idx] = Math.min(bucketsMIN[idx], d);
            bucketsMAX[idx] = Math.max(bucketsMAX[idx], d);
        }
        int pre = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < bucket_nums; i++) {
            // empty bucket
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE) {
                continue;
            }
            res = Math.max(res, bucketsMIN[i] - bucketsMAX[pre]);
            pre = i;
        }
        return res;
    }
}