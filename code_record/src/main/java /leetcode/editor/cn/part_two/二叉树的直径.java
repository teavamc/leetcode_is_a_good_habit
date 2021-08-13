package leetcode.editor.cn.part_two;
 
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 704 👎 0

import leetcode.editor.cn.TreeNode;

public class 二叉树的直径{
    public static void main(String[] args) {
        Solution solution = new 二叉树的直径().new Solution();
         
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
    int maxd = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root);
        return maxd;
    }

    // 拿到每个节点的直径
    // 如何判断当前节点的直径 : 左子树的最大深度 + 右子树的最大深度
    // 暂存所有节点的最大直径返回就好
    int dfs(TreeNode tree){
        if (tree == null){
            return 0;
        }
        // 拿到左子树的深度
        int left = dfs(tree.left);
        // 拿到右边子树的深度
        int right = dfs(tree.right);
        // 比较当前暂存的直径, 替换最大的直径
        maxd = Math.max(left+right,maxd);
        // 返回当前节点的深度
        return Math.max(left,right)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}