// Using recursion to solve this problem(backtracking)

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res, "", n, n);
        return res;
    }
    
    public void backtrack(List<String> res, String str, int left, int right){
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left > 0) {
            backtrack(res, str + '(', left - 1, right);
        }
        if (right > 0) {
            backtrack(res, str + ")", left, right - 1);
        }
        
    }
}