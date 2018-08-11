/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// BST take in-order traverse into priority consideration
class Solution {
    int res = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    
    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
        }
        helper(root.right);
    }
}