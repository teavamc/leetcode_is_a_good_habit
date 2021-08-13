package leetcode.editor.cn.part_two;
 
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 878 👎 0

import leetcode.editor.cn.TreeNode;

public class 二叉树的最大深度{
    public static void main(String[] args) {
        Solution solution = new 二叉树的最大深度().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int defaultDepth = 0;
        return dfs(root,defaultDepth);
    }

    int dfs(TreeNode root, int depth){
        // 节点无效就直接返回
        if (root==null){
            return depth;
        }
        // 否者加一层
        depth++;
        // 取最大的深度返回
        return Math.max(dfs(root.left,depth),dfs(root.right,depth));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}