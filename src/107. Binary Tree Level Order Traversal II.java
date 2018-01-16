/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// BFS and DFS
class Solution {
// BS(Using queue)
// reverse traverse
    // public List<List<Integer>> levelOrderBottom(TreeNode root) {
    //     Queue<TreeNode> queue = new LinkedList<TreeNode>();
    //     LinkedList<List<Integer>> res = new LinkedList<>();
    //     if (root == null) return res;
    //     queue.offer(root);
    //     while (!queue.isEmpty()) {
    //         int levelNum = queue.size();
    //         LinkedList<Integer> sub = new LinkedList<>();
    //         for (int i = 0; i < levelNum; i++) {
    //             if (queue.peek().left != null) {
    //                 queue.offer(queue.peek().left);
    //             }
    //             if (queue.peek().right != null) {
    //                 queue.offer(queue.peek().right);
    //             }
    //             sub.add(queue.poll().val);
    //         }
    //         res.add(0, sub);
    //     }
    //     return res;
    // }
// DFS(recursion)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        dfs(res, 0, root);
        return res;
    }
    
    public void dfs(LinkedList<List<Integer>> res, int level, TreeNode root) {
        if (root == null) return;
        // let listsize equals to level
        if (res.size() <= level) {
            res.add(0, new LinkedList<Integer>());
        }
        dfs(res, level + 1, root.left);
        dfs(res, level + 1, root.right);
        res.get(res.size() - level - 1).add(root.val);
    }
}