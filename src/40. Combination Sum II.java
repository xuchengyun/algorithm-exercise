class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //corner case
        if(candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(0, candidates, target, res, new ArrayList<Integer>());
        return res;
    }

    // the duplicates in array should be ignored
    public void helper(int start, int[] candidates, int target, List<List<Integer>> res, List<Integer> temp) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // remove duplicate
            if (start < i && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            // each number can only be used once
            helper(i + 1, candidates, target - candidates[i], res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}