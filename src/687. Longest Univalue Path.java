/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// DFS recursion
class Solution {
    int res;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        res = 0;
        pathLen(root);
        return res;
    }
    
    public int pathLen(TreeNode node) {
        if (node == null) return 0;
        int left = pathLen(node.left);
        int right = pathLen(node.right);
        left = (node.left != null && node.val == node.left.val) ? left + 1 : 0;
        right = (node.right != null && node.val == node.right.val) ? right + 1 : 0;
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
    
}