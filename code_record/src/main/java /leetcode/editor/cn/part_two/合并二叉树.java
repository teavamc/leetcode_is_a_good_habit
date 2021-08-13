package leetcode.editor.cn.part_two;
 
//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 688 👎 0

import leetcode.editor.cn.TreeNode;

public class 合并二叉树{
    public static void main(String[] args) {
        Solution solution = new 合并二叉树().new Solution();
         
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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return null;
        }
        // 使用一颗新树来合并
        TreeNode newTree = new TreeNode();
        dfs(root1,root2,newTree);
        return newTree;
    }

    void dfs(TreeNode root1, TreeNode root2, TreeNode newTree){
        // 更改新树的值
        newTree.val = (root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val);
        // 但凡有一边有左子树, 就合并
        if ((root1 != null && root1.left != null) || (root2 != null && root2.left != null)){
            newTree.left = new TreeNode();
            dfs(root1 == null ? null : root1.left, root2 == null ? null : root2.left,
                    newTree.left);
        }
        // 但凡有一边有右子树就合并
        if ((root1!=null && root1.right != null) || (root2!=null && root2.right !=null)){
            newTree.right = new TreeNode();
            dfs(root1 == null ? null : root1.right,
                    root2 == null ? null : root2.right,
                    newTree.right);

        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}