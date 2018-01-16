/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
//     // Hashtable DFS, change two sum array to a BST
//     public boolean findTarget(TreeNode root, int k) {
//         // corner case
//         if (root == null) return false;
//         Set<Integer> set = new HashSet<>();
//         return find(root, k, set);
//     }
    
//     public boolean find(TreeNode node, int k, Set<Integer> set) {
//         if (node == null) return false;
//         if (set.contains(k - node.val)) return true;
//         set.add(node.val);
//         return find(node.left, k, set) || find(node.right, k, set);
//     }
    
    // Hashtable BFS, 
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.peek();
            if (set.contains(k - node.val)) return true;
            set.add(node.val);
            q.remove();
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        return false;
    }
}