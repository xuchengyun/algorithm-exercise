/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// /*
// in-order traverse
// */
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         ArrayList<TreeNode> list = new ArrayList<>();
//         inorder(list, root);
//         for (int i = 1; i < list.size(); i++) {
//             if (list.get(i - 1).val >= list.get(i).val) {
//                 return false;
//             }
//         }
//         return true;
//     }
    
//     public void inorder(List<TreeNode> list, TreeNode root) {
//         if (root == null) return;
//         inorder(list, root.left);
//         list.add(root);
//         inorder(list, root.right);
//     }

/*
based on binary search tree nature
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    public boolean helper(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val >= max) return false;
        if (root.val <= min) return false;
        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
}