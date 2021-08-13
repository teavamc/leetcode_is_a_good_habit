package leetcode.editor.cn.part_two;
 
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1383 👎 0

import leetcode.editor.cn.TreeNode;

public class 对称二叉树{
    public static void main(String[] args) {
        Solution solution = new 对称二叉树().new Solution();
         
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return compare(root.left,root.right);
    }

    // 递归比较
    // dfs
    public boolean compare(TreeNode l, TreeNode r){
        // 都是空
       if (l == null && r == null){
           return true;
       }
       // 只有一个节点
       if (l == null || r == null){
           return false;
       }
       // 值不相等
       if (l.val != r.val){
           return false;
       }
       // 外围 && 内部
       return compare(l.left,r.right) && compare(l.right,r.left);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}